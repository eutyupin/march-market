package ru.geekbrains.march.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.converters.CartDtoToOrderConverter;
import ru.geekbrains.march.market.core.converters.DtoToOrderConverter;
import ru.geekbrains.march.market.core.converters.OrderToDtoConverter;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.integration.CartServiceIntegration;
import ru.geekbrains.march.market.core.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderToDtoConverter orderToDtoConverter;
    private final CartServiceIntegration cartService;
    private final CartDtoToOrderConverter cartDtoToOrderConverter;

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void createNewOrder(String username) {
        CartDto cartDto = cartService.getCart();
        if (!cartDto.getItems().isEmpty()) {
            orderRepository.save(cartDtoToOrderConverter.CartDtoConvertToOrder(cartDto, username));
            cartService.clearCart(username);
        }
    }

    public List<OrderDto> findAllOrders () {
        List<OrderDto> ordersDto = new ArrayList<>();
        orderRepository.findAll().forEach(o -> ordersDto.add(orderToDtoConverter.orderConvertToDto(o)));
        return ordersDto;
    }


}
