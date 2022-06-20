package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Модель корзины")
public class CartDto {
    @Schema(description = "Список продуктов корзины", required = true)
    private List<CartItemDto> items;
    @Schema(description = "Суммарная цена товаров корзины", required = true, example = "1235.00")
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
