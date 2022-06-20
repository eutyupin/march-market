package ru.geekbrains.march.market.core.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.PageDto;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.converters.PageToDtoConverter;
import ru.geekbrains.march.market.core.converters.ProductToDtoConverter;
import ru.geekbrains.march.market.core.entities.Product;
import ru.geekbrains.march.market.core.exceptions.AppError;
import ru.geekbrains.march.market.core.exceptions.ResourceNotFoundException;
import ru.geekbrains.march.market.core.repositories.specifications.ProductsSpecifications;
import ru.geekbrains.march.market.core.services.ProductService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Продукты", description = "Методы для работы с продуктами")
public class ProductController {
    private final ProductService productService;
    private final ProductToDtoConverter productToDtoConverter;
    private final PageToDtoConverter pageToDtoConverter;

    @GetMapping
    public PageDto getAllProducts(
            @RequestParam (name = "page", defaultValue = "1")  @Parameter(description = "Номер страницы", required = true) Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10")  @Parameter(description = "Размер страницы", required = true) Integer pageSize,
            @RequestParam(name = "title_part", required = false)  @Parameter(description = "Фильтр по части наименования продукта", required = true) String titlePart,
            @RequestParam(name = "min_price", required = false)  @Parameter(description = "Фильтр по минимальной цене", required = true) Integer minPrice,
            @RequestParam(name = "max_price", required = false)  @Parameter(description = "Фильтр по максимальной цене", required = true) Integer maxPrice) {
        if (page < 1) page = 1;
        Specification<Product> specification = Specification.where(null);
        if (titlePart != null) {
            specification = specification.and(ProductsSpecifications.titleLike(titlePart));
        }

        if (minPrice != null) {
            specification = specification.and(ProductsSpecifications.priceGreaterOrEqualsThan(BigDecimal.valueOf(minPrice)));
        }
        if (maxPrice != null) {
            specification = specification.and(ProductsSpecifications.priceLessThanOrEqualsThan(BigDecimal.valueOf(maxPrice)));
        }

        return pageToDtoConverter.pageConvertToDto(productService.findAll(specification, page - 1, pageSize));
    }

    @Operation(
            summary = "Запрос на получение продукта по id",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ProductDto.class))
                    ),
                    @ApiResponse(
                            description = "Продукт не найден", responseCode = "404",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productToDtoConverter.entityToDto(productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + id + " не найден")));
    }

    @Operation(
            summary = "Запрос на создание нового продукта",
            responses = {
                    @ApiResponse(
                            description = "Продукт успешно создан", responseCode = "201"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducts(@RequestBody ProductDto productDto) {
        productService.createNewProduct(productDto);
    }

    @Operation(
            summary = "Удаление продукта по id"
    )
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
