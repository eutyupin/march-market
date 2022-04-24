package ru.geekbrains.march.market.cart.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.cart.utils.Cart;

@Component
@RequiredArgsConstructor
public class CartConverter {
    private final CartItemConverter cartItemConverter;

    public CartDto cartConvertToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cart.getItems().forEach(item -> cartDto.getItems().add(cartItemConverter.itemConvertToDto(item)));
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }
}
