package ru.geekbrains.march.market.cart.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.CartItemDto;
import ru.geekbrains.march.market.cart.utils.CartItem;

@Component
public class CartItemConverter {
    public CartItemDto itemConvertToDto(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(cartItem.getProductId());
        cartItemDto.setProductTitle(cartItem.getProductTitle());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
        cartItemDto.setPrice(cartItem.getPrice());
        return cartItemDto;
    }
}
