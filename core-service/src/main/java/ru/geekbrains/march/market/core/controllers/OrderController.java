package ru.geekbrains.march.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.core.converters.OrderToDtoConverter;
import ru.geekbrains.march.market.core.services.OrderService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.findAllOrders();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(@RequestBody OrderDto orderDto, Principal principal) {
        orderService.createNewOrder(orderDto);
    }
}
