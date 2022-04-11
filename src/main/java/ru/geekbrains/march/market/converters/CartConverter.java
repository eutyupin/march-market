package ru.geekbrains.march.market.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.dtos.CartDto;
import ru.geekbrains.march.market.utils.Cart;

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
