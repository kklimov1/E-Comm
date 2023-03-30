package com.example.ECommerce.repositories;
import com.example.ECommerce.models.ECommerceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ECommerceUser, Integer> {
    Optional<ECommerceUser> findByUsernameAndPassword(String username, String password);

    Optional<ECommerceUser> findByUsername(String username);
}
