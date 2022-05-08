package ru.geekbrains.march.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.core.entities.Order;

@Component
@RequiredArgsConstructor
public class DtoToOrderConverter {
    private final DtoToItemConverter dtoToItemConverter;
//    private final DtoToUserConverter dtoToUserConverter;

    public Order orderDtoConvrtToOrder(OrderDto orderDto) {
        Order order = new Order();
        dtoToItemConverter.setOrder(order);
        order.setTotalPrice(orderDto.getTotalPrice());
        orderDto.getItemsDto().forEach(i -> order.getItems().add(dtoToItemConverter.itemDtoConvertToItem(i)));
//        order.setUser(dtoToUserConverter.userDtoConvertToUser(orderDto.getUserDto()));
        return order;
    }
}
