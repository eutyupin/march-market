package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Модель элемента корзины")
public class CartItemDto {
    @Schema(description = "id элемента корзины", required = true, example = "1")
    private Long id;
    @Schema(description = "id продукта в элементе корзины", required = true, example = "1")
    private Long productId;
    @Schema(description = "Наименование продукта в элементе корзины", required = true, example = "Хлеб")
    private String productTitle;
    @Schema(description = "Количество продуктов в элементе корзины", required = true, example = "5")
    private int quantity;
    @Schema(description = "Цена за единицу продукта в элементе корзины", required = true, example = "56.00")
    private BigDecimal pricePerProduct;
    @Schema(description = "Общая стоимость продуктов в элементе корзины", required = true, example = "280.00")
    private BigDecimal price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
