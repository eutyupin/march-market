package ru.geekbrains.march.market.core.converters;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.CartItemDto;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.entities.OrderItem;
import ru.geekbrains.march.market.core.services.ProductService;

@Component
@RequiredArgsConstructor
@Data
public class CartItemDtoToItemConverter {
    private final DtoToProductConverter dtoToProductConverter;
    private final ProductService productService;
    private Order order;

    public OrderItem cartItemDtoConvertToItem (CartItemDto cartItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(cartItemDto.getId());
        orderItem.setProduct(productService.findById(cartItemDto.getProductId()).get());
        orderItem.setOrder(order);
        orderItem.setQuantity(cartItemDto.getQuantity());
        orderItem.setPricePerProduct(cartItemDto.getPricePerProduct());
        orderItem.setPrice(cartItemDto.getPrice());
        return orderItem;
    }
}
