package ru.geekbrains.march.market.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.march.market.services.ProductService;
import ru.geekbrains.march.market.soap.products.*;

@Endpoint
@RequiredArgsConstructor
public class ProductsEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.ru/spring/ws/products";
    private final ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setProduct(productService.findById(request.getId()).get());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productService.findAll().forEach( p -> {
            Product tmpPr = new Product();  //сомнительное решение, но че-то умнее я не придумал
            tmpPr.setId(p.getId());
            tmpPr.setTitle(p.getTitle());
            tmpPr.setPrice(p.getPrice());
            response.getProducts().add(tmpPr);
        });
        return response;
    }
}
