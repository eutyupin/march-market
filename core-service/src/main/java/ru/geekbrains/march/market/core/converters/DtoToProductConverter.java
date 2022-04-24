package ru.geekbrains.march.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.entities.Product;
import ru.geekbrains.march.market.core.services.CategoryService;

@Component
@RequiredArgsConstructor
public class DtoToProductConverter {
    private final CategoryService categoryService;

    public Product productDtoConvertToProduct(ProductDto productDto) {
        Product product = new Product();
        if (!productDto.getId().equals(null)) product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCategory(categoryService.findByTitle(productDto.getTitle()).get());
        product.setPrice(productDto.getPrice());
        return product;
    }

}
