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

    private Product newProduct(CreateNewProductDto newProductDto) {
        Product product = new Product();
        product.setTitle(newProductDto.getTitle());
        product.setPrice(newProductDto.getPrice());
        return product;
    }

}
