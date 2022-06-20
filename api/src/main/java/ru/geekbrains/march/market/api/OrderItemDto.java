package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Модель элемента заказа")
public class OrderItemDto {
    @Schema(description = "ID элемента заказа", required = true, example = "1")
    private Long id;
    @Schema(description = "ID заказа", required = true, example = "1")
    private Long orderId;
    @Schema(description = "Модель продукта заказа", required = true)
    private ProductDto productDto;
    @Schema(description = "Цена за единицу элемента заказа", required = true, example = "56.00")
    private BigDecimal pricePerProduct;
    @Schema(description = "Суммарная цена заказа", required = true, example = "280.00")
    private BigDecimal price;
    @Schema(description = "Количество", required = true, example = "5")
    private int quantity;

    public OrderItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public BigDecimal getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(BigDecimal pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
