package ru.geekbrains.march.market.cart.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.march.market.api.ProductDto;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final RestTemplate restTemplate;
    private final String CORE_PRODUCTS_URL = "http://localhost:8189/market/api/v1/products/";

    public ProductDto findById(Long id) {
        return restTemplate.getForObject(CORE_PRODUCTS_URL + id, ProductDto.class);
    }

}
