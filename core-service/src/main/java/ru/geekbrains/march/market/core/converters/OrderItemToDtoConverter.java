package ru.geekbrains.march.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.OrderItemDto;
import ru.geekbrains.march.market.core.entities.OrderItem;

@Component
@RequiredArgsConstructor
public class OrderItemToDtoConverter {
    private final ProductToDtoConverter productToDtoConverter;

    public OrderItemDto itemConvertToDto (OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setOrderId(orderItem.getOrder().getId());
        orderItemDto.setProductDto(productToDtoConverter.entityToDto(orderItem.getProduct()));
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        return orderItemDto;
    }
}
