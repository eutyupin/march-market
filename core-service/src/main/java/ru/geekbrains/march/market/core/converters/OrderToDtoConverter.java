package ru.geekbrains.march.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.core.entities.Order;

@Component
@RequiredArgsConstructor
public class OrderToDtoConverter {
    private final OrderItemToDtoConverter orderItemToDtoConverter;
    private final UserToDtoConverter userToDtoConverter;

    public OrderDto orderConvertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderDto.getId());
        orderDto.setUserDto(userToDtoConverter.userConvertToDto(order.getUser()));
        orderDto.setTotalPrice(order.getTotalPrice());
        order.getItems().forEach(i -> orderDto.getItemsDto().add(orderItemToDtoConverter.itemConvertToDto(i)));
        return orderDto;
    }
}
