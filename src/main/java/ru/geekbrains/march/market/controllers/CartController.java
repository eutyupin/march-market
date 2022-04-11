package ru.geekbrains.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.dtos.CartDto;
import ru.geekbrains.march.market.services.CartService;
import ru.geekbrains.march.market.utils.Cart;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public CartDto getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId) {
        cartService.addToCart(productId);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteFromCart(@PathVariable Long productId) {
        cartService.deleteFromCart(productId);
    }

    @DeleteMapping("/decrement/{productId}")
    public void decrementFromCart(@PathVariable Long productId) {
        cartService.decrementFromCart(productId);
    }

    @PostMapping("/clear")
    public void clearCart() {
        cartService.cartClear();
    }
}
