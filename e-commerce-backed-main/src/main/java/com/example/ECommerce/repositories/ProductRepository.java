package com.example.ECommerce.repositories;

import com.example.ECommerce.models.ECommerceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ECommerceProduct, Integer> {
}
