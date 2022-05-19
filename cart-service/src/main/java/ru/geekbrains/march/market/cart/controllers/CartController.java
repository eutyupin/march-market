package ru.geekbrains.march.market.cart.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.cart.services.CartService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/generate_id")
    public String generateGuestCartId() {
        return UUID.randomUUID().toString();
    }
    @GetMapping("/{guestCartId}")
    public CartDto getCurrentCart(@RequestHeader (required = false) String username, @PathVariable String guestCartId) {
        return cartService.getCurrentCart(selectCartId(username, guestCartId));
    }

    @GetMapping("/{guestCartId}/add/{productId}")
    public void addProductToCart(@RequestHeader (required = false) String username, @PathVariable String guestCartId, @PathVariable Long productId) {
        cartService.addToCart(selectCartId(username, guestCartId), productId);
    }

//    @DeleteMapping("/{guestCartId}/delete/{productId}")
//    public void deleteFromCart(@PathVariable Long productId) {
//        cartService.deleteFromCart(productId);
//    }
//
//    @DeleteMapping("/{guestCartId}/decrement/{productId}")
//    public void decrementFromCart(@PathVariable Long productId) {
//        cartService.decrementFromCart(productId);
//    }

    @PostMapping("/{guestCartId}/clear")
    public void clearCart(@RequestHeader (required = false) String username, @PathVariable String guestCartId) {
        cartService.cartClear(selectCartId(username, guestCartId));
    }

    private String selectCartId(String username, String guestCartId) {
        if (username != null) return username;
        else return guestCartId;
    }
}
