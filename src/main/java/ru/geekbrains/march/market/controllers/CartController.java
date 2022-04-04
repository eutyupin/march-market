package ru.geekbrains.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.dtos.CreateNewProductDto;
import ru.geekbrains.march.market.entities.Product;
import ru.geekbrains.march.market.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Product> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToCart(@PathVariable Long id) {
        cartService.addToCart(id);
    }
}
