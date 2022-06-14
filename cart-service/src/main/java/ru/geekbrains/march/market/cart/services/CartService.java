package ru.geekbrains.march.market.cart.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.cart.converters.CartConverter;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.cart.integration.ProductServiceIntegration;
import ru.geekbrains.march.market.cart.utils.Cart;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productService;
    private final CartConverter cartConverter;
    private final RedisTemplate<String, Object> redisTemplate;

    public Cart getCurrentCart(String cartId) {
        if (!redisTemplate.hasKey(cartId)) {
            Cart cart = new Cart();
            redisTemplate.opsForValue().set(cartId, cart);
        }
        return (Cart)redisTemplate.opsForValue().get(cartId);
    }

    public CartDto getCurrentCartDto(String cartId) {
        return cartConverter.cartConvertToDto(getCurrentCart(cartId));
    }

    public void addToCart(String cartId, Long productId) {
        executeEvent(cartId, cart -> {
            ProductDto p = productService.findById(productId);
            cart.add(p);
        });
    }

    public void removeFromCart(String cartId, Long productId) {
        executeEvent(cartId, cart -> cart.remove(productId));
    }
//
//    public void decrementFromCart(Long productId) {
//        cart.decrement(productId);
//    }

    public void cartClear(String cartId) {
        executeEvent(cartId, Cart::clear);
    }

    private void executeEvent(String cartId, Consumer<Cart> action) {
        Cart cart = getCurrentCart(cartId);
        action.accept(cart);
        redisTemplate.opsForValue().set(cartId, cart);
    }
}
