package ru.geekbrains.march.market.api;

import java.util.UUID;

public class GuestDto {
    private String cartId;

    public GuestDto(){
        this.cartId = UUID.randomUUID().toString();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
