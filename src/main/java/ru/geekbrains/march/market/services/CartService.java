package ru.geekbrains.march.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.converters.CartConverter;
import ru.geekbrains.march.market.dtos.CartDto;
import ru.geekbrains.march.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.march.market.entities.Product;
import ru.geekbrains.march.market.utils.Cart;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
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
        Product p = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + productId + " не найден"));
        cart.add(p);
    }

    public void deleteFromCart(Long productId) {
        cart.delete(productId);
    }

    public void decrementFromCart(Long productId) {
        cart.decrement(productId);
    }
}
