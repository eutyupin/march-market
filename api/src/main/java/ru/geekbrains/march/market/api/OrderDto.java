package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Модель заказа")
public class OrderDto {
    @Schema(description = "ID заказа", required = true, example = "1")
    private Long id;
    @Schema(description = "Модель пользователя, сделавшего заказ", required = true)
    private UserDto userDto;
    @Schema(description = "Суммарная цена заказа", required = true, example = "1235.00")
    private BigDecimal totalPrice;
    @Schema(description = "Список элементов заказа", required = true)
    private List<OrderItemDto> itemsDto;

    public OrderDto() {
        itemsDto = new ArrayList<>();
        this.totalPrice = BigDecimal.valueOf(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDto> getItemsDto() {
        return itemsDto;
    }

    public void setItemsDto(List<OrderItemDto> itemsDto) {
        this.itemsDto = itemsDto;
    }
}
