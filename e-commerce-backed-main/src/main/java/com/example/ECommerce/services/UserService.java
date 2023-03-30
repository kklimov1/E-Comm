package com.example.ECommerce.services;

import com.example.ECommerce.exceptions.IncorrectLoginRequest;
import com.example.ECommerce.models.ECommerceProduct;
import com.example.ECommerce.models.ECommerceUser;
import com.example.ECommerce.repositories.ProductRepository;
import com.example.ECommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; }

    public ECommerceUser save( ECommerceUser eCommerceUser){
        return userRepository.save(eCommerceUser);
    }

    public Optional<ECommerceUser> getUser(Integer id){
        return userRepository.findById(id);
    }

    public Optional<ECommerceUser> getUser(String username, String password) throws IncorrectLoginRequest {
        Optional<ECommerceUser> eUser = userRepository.findByUsername(username);
        if(eUser.isPresent()) {
            if (eUser.get().getPassword().equals(password)) {
                return eUser;
            }
            throw new IncorrectLoginRequest("Password is not correct:(");
        }
        throw new IncorrectLoginRequest("Username does not exist in the database");
    }

}
