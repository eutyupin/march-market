package ru.geekbrains.march.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Cart {
    private List<Product> productList;

    public Cart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
