package ru.geekbrains.march.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.core.converters.DtoToProductConverter;
import ru.geekbrains.march.market.core.converters.ProductToDtoConverter;
import ru.geekbrains.march.market.core.exceptions.ResourceNotFoundException;
import ru.geekbrains.march.market.core.repositories.ProductRepository;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductToDtoConverter productToDtoConverter;
    private final DtoToProductConverter dtoToProductConverter;

    public List<ProductDto> findAll() { //возврат листа ProductDto вместо Product
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepository.findAll().forEach(p -> productDtoList.add(productToDtoConverter.entityToDto(p)));
        return productDtoList;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(ProductDto productDto) {
        Product product = dtoToProductConverter.productDtoConvertToProduct(productDto);
        product.setCategory(categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Категория с названием: " + productDto.getCategoryTitle() + " не найдена")));
        productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
