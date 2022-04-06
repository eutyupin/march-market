package ru.geekbrains.march.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.dtos.CreateNewProductDto;
import ru.geekbrains.march.market.entities.Cart;
import ru.geekbrains.march.market.entities.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final Cart cart;
    private final ProductService productService;

    public List<Product> getAllCartItems() {
        return cart.getProductList();
    }

    public void addToCart(Long id) {
       cart.getProductList().add(productService.findById(id).get());
    }

    public void deleteFromCart(Long id) {
        List<Product> temp = cart.getProductList();
        for (Product product : temp) {
            if(product.getId().equals(id)) {
                temp.remove(product);
            }
        }
        cart.setProductList(temp);
    }

}
