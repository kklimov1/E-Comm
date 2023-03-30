package com.example.ECommerce.services;

import com.example.ECommerce.models.ECommerceProduct;
import com.example.ECommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ECommerceProduct> getProducts(){
        return productRepository.findAll();
    }

    //public Optional<ECommerceProduct> getProduct(Integer id) { return productRepository.}
    public Optional<ECommerceProduct> getEcommerceProduct(Integer id){
        return productRepository.findById(id);
    }
}
