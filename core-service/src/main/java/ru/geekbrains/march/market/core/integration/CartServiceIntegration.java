package ru.geekbrains.march.market.core.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.ProductDto;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;
    private final String CART_PRODUCTS_URI = "/api/v1/cart/";

    public CartDto getCart() {
        return cartServiceWebClient.get()
                .uri(CART_PRODUCTS_URI)
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }


}
