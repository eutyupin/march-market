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

    public CartDto getCart(String username) {
        return cartServiceWebClient.get()
                .uri("/api/v1/cart/0")
                .header(username)
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clearCart(String username) {
        cartServiceWebClient.post()
                .uri("/api/v1/cart/0/clear")
                .header(username)
                .retrieve()
                .toBodilessEntity()
                .block();
    }


}
