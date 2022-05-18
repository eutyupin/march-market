package ru.geekbrains.march.market.cart;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.cart.converters.CartConverter;
import ru.geekbrains.march.market.cart.integration.ProductServiceIntegration;
import ru.geekbrains.march.market.cart.services.CartService;
import ru.geekbrains.march.market.cart.utils.Cart;

import java.math.BigDecimal;

@SpringBootTest(classes = CartService.class)
public class CartServiceTest {
    @Autowired
    private CartService cartService;
    @MockBean
    CartConverter cartConverter;
    @MockBean
    ProductServiceIntegration productServiceIntegration;
    @MockBean
    Cart cart;

    @Test
    public void addToCartTest() {
        ProductDto productDto = new ProductDto(1L, "some product", BigDecimal.valueOf(258.00),"some category");
        Mockito.doReturn(productDto)
                .when(productServiceIntegration)
                .findById(1L);
        cartService.addToCart(1L);
    }

}
