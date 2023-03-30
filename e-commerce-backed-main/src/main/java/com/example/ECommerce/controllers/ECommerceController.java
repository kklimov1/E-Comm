package com.example.ECommerce.controllers;

import com.example.ECommerce.dtos.LoginAttempt;
import com.example.ECommerce.exceptions.IncorrectLoginRequest;
import com.example.ECommerce.models.ECommerceProduct;
import com.example.ECommerce.models.ECommerceUser;
import com.example.ECommerce.repositories.ProductRepository;
import com.example.ECommerce.services.ProductService;
import com.example.ECommerce.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
//@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "http://p3-static-hosting.s3-website.us-east-2.amazonaws.com"}, allowCredentials = "true", exposedHeaders = "Authorization")

public class ECommerceController {
    private final UserService eCommerceService;
    private final ProductService productService;

    @PostMapping("/login")
    public ResponseEntity<ECommerceUser> login(@RequestBody LoginAttempt loginAttempt, HttpSession session) throws IncorrectLoginRequest {
        Optional<ECommerceUser> eUser = eCommerceService.getUser(loginAttempt.getUsername(), loginAttempt.getPassword());
        if(!eUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        session.setAttribute("user", eUser.get());
        return ResponseEntity.ok(eUser.get());
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.removeAttribute("user");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ECommerceUser> register(@RequestBody LoginAttempt loginAttempt){
        ECommerceUser eUser = new ECommerceUser(loginAttempt.getUsername(), loginAttempt.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(eCommerceService.save(eUser));
    }

    @GetMapping("/ping")
    public String ping(HttpSession session){
        return "pong.";
    }

    @GetMapping("/products")
    public ResponseEntity<List<ECommerceProduct>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ECommerceProduct> getProduct(@PathVariable("id") Integer id){
        Optional<ECommerceProduct> prod = productService.getEcommerceProduct(id);
        if(prod.isPresent()) {
            return ResponseEntity.ok(prod.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
