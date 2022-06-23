package ru.geekbrains.march.market.cart.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.cart.services.CartService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Tag(name = "Корзины", description = "Методы для работы с корзинами")
public class CartController {
    private final CartService cartService;

    @Operation(
            summary = "Запрос на получение id для гостя",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )
    @GetMapping("/generate_id")
    public String generateGuestCartId() {
        return UUID.randomUUID().toString();
    }

    @Operation(
            summary = "Запрос на получение текущей корзины для пользователя",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CartDto.class))
                    )
            }
    )
    @GetMapping("/{guestCartId}")
    public CartDto getCurrentCart(@RequestHeader (required = false) String username, @PathVariable String guestCartId) {
        return cartService.getCurrentCartDto(selectCartId(username, guestCartId));
    }

    @Operation(
            summary = "Добавление продукта по id в корзину",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    )
            }
    )
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

    @Operation(
            summary = "Запрос на очистку корзины",
            responses = {
                    @ApiResponse(
                            description = "Корзина очищена", responseCode = "201"
                    )
            }
    )
    @PostMapping("/{guestCartId}/clear")
    public void clearCart(@RequestHeader (required = false) String username, @PathVariable String guestCartId) {
        cartService.cartClear(selectCartId(username, guestCartId));
    }

    @Operation(
            summary = "Выбор между именем пользователя или если оно отсутствует, то id гостя"
    )
    private String selectCartId(String username, String guestCartId) {
        if (username != null) return username;
        else return guestCartId;
    }
}
