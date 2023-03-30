package com.example.ECommerce.services;

import com.example.ECommerce.models.ECommerceProduct;
import com.example.ECommerce.repositories.ProductRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    public ProductService productService;

    @Mock
    ProductRepository productRepositoryMock;


    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting product service tests");
    }

    @BeforeEach
    public void beforeEach(){
        productService = new ProductService(productRepositoryMock);
    }

    @Test
    public void createProductNew(){
        String name = "item1";
        double price = 4.0;
        ECommerceProduct newProduct = new ECommerceProduct(name, price);
    }

}
