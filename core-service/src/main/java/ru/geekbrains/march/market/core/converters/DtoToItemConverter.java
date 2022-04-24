package ru.geekbrains.march.market.core.converters;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.OrderItemDto;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.entities.OrderItem;
import ru.geekbrains.march.market.core.entities.Product;

@Component
@RequiredArgsConstructor
@Data
public class DtoToItemConverter {
    private final DtoToProductConverter dtoToProductConverter;
    private Order order;

    public OrderItem itemDtoConvertToItem (OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setProduct(dtoToProductConverter.productDtoConvertToProduct(orderItemDto.getProductDto()));
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        orderItemDto.setPrice(orderItem.getPrice());
        return orderItem;
    }
}
