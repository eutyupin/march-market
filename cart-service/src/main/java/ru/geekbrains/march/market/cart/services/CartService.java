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

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productService;
    private final CartConverter cartConverter;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
        cart.setItems(new ArrayList<>());
    }

    public CartDto getCurrentCart() {
        return cartConverter.cartConvertToDto(cart);
    }

    public void addToCart(Long productId) {
        ProductDto p = productService.findById(productId);
        cart.add(p);
    }

    public void deleteFromCart(Long productId) {
        cart.delete(productId);
    }

    public void decrementFromCart(Long productId) {
        cart.decrement(productId);
    }

    public void cartClear() {
        cart.clear();
    }
}
