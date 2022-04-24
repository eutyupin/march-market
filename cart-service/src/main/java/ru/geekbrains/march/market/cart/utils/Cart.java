package ru.geekbrains.march.market.cart.utils;

import lombok.Data;
import ru.geekbrains.march.market.api.ProductDto;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private BigDecimal totalPrice;

    public void add(ProductDto p) {
        for (CartItem item : items) {
            if (item.getProductId().equals(p.getId())) {
                item.incrementQuantity();
                recalculate();
                return;
            }
        }
        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.add(cartItem);
        recalculate();
    }

    public void clear() {
        items.clear();
        totalPrice = BigDecimal.ZERO;
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));
    }

    public void delete(Long productId) {
        items.removeIf(item -> item.getProductId().equals(productId));
        recalculate();
    }

    public void decrement(Long productId) {
        Iterator<CartItem> cartItemIterator = items.iterator();
        while(cartItemIterator.hasNext()) {
            CartItem item = cartItemIterator.next();
            if (item.getProductId().equals(productId)) {
                item.decrementQuantity();
                if (item.getQuantity() <= 0) items.remove(item);
                recalculate();
                return;
            }
        }
//        for (CartItem item : items) {
//            if(item.getProductId().equals(productId) && item.getQuantity() == 1){
//                delete(productId);
//                return;
//            }
//            if(item.getProductId().equals(productId) && item.getQuantity() > 1){
//                item.decrementQuantity();
//            }
//        }
//        recalculate();
    }
}
