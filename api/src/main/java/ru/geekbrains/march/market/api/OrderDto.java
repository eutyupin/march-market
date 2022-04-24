package ru.geekbrains.march.market.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long id;
    private UserDto userDto;
    private BigDecimal totalPrice;
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
