package ru.geekbrains.march.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.services.UserService;

@Component
@RequiredArgsConstructor
public class CartDtoToOrderConverter {
    private final UserService userService;
        private final CartItemDtoToItemConverter cartItemDtoToItemConverter;

        public Order CartDtoConvertToOrder(CartDto cartDto, String username) {
            Order order = new Order();
            cartItemDtoToItemConverter.setOrder(order);
            order.setTotalPrice(cartDto.getTotalPrice());
            cartDto.getItems().forEach(i -> order.getItems().add(cartItemDtoToItemConverter.cartItemDtoConvertToItem(i)));
            order.setUser(userService.findByUsername(username).get());
            return order;
        }
}
