package ru.geekbrains.march.market.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CartDto {
    private List<CartItemDto> items;
    private BigDecimal totalPrice;

    public CartDto() {
        this.items = new ArrayList<>();
        this.totalPrice = BigDecimal.valueOf(0);
    }
}
