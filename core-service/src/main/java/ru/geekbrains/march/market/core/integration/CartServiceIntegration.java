package ru.geekbrains.march.market.core.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.ProductDto;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;
    private final String CART_PRODUCTS_URL = "http://localhost:8190/market-cart/api/v1/cart/";

    public CartDto getCart() {
        return restTemplate.getForObject(CART_PRODUCTS_URL, CartDto.class);
    }

}
