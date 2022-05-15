package ru.geekbrains.march.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.converters.DtoToOrderConverter;
import ru.geekbrains.march.market.core.converters.OrderToDtoConverter;
import ru.geekbrains.march.market.core.exceptions.ResourceNotFoundException;
import ru.geekbrains.march.market.core.services.OrderService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderToDtoConverter orderToDtoConverter;

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.findAllOrders();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(@RequestHeader String username) {
        orderService.createNewOrder(username);
    }

    @GetMapping("/{id}")
    public OrderDto getProductById(@PathVariable Long id) {
        return orderToDtoConverter.orderConvertToDto(orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Заказ с id: " + id + " не найден")));
    }
}
