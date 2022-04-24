package ru.geekbrains.march.market.core.services;

import lombok.RequiredArgsConstructor;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.converters.DtoToOrderConverter;
import ru.geekbrains.march.market.core.converters.OrderToDtoConverter;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final DtoToOrderConverter dtoToOrderConverter;
    private final OrderToDtoConverter orderToDtoConverter;

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void createNewOrder(OrderDto orderDto) {
        orderRepository.save(dtoToOrderConverter.orderDtoConvrtToOrder(orderDto));
    }

    public List<OrderDto> findAllOrders () {
        List<OrderDto> ordersDto = new ArrayList<>();
        orderRepository.findAll().forEach(o -> ordersDto.add(orderToDtoConverter.orderConvertToDto(o)));
        return ordersDto;
    }
}
