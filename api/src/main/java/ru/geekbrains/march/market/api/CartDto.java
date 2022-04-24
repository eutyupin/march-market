package ru.geekbrains.march.market.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private List<CartItemDto> items;
    private BigDecimal totalPrice;

    public CartDto() {
        this.items = new ArrayList<>();
        this.totalPrice = BigDecimal.valueOf(0);
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
