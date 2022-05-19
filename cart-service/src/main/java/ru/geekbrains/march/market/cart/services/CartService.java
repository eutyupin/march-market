package ru.geekbrains.march.market.cart.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.cart.converters.CartConverter;
import ru.geekbrains.march.market.cart.exceptions.ResourceNotFoundException;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.cart.integration.ProductServiceIntegration;
import ru.geekbrains.march.market.cart.utils.Cart;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productService;
    private final CartConverter cartConverter;
    private Map<String, Cart> carts;

    @PostConstruct
    public void init() {
        carts = new HashMap<>();
    }

    public CartDto getCurrentCart(String cartId) {
        if (!carts.containsKey(cartId)) {
            Cart cart = new Cart();
            carts.put(cartId, cart);
        }
        return cartConverter.cartConvertToDto(carts.get(cartId));
    }

    public void addToCart(String cartId, Long productId) {
        ProductDto p = productService.findById(productId);
        carts.get(cartId).add(p);
    }

//    public void deleteFromCart(Long productId) {
//        cart.delete(productId);
//    }
//
//    public void decrementFromCart(Long productId) {
//        cart.decrement(productId);
//    }

    public void cartClear(String cartId) {
        carts.get(cartId).clear();
    }
}
