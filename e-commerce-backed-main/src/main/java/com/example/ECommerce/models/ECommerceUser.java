package com.example.ECommerce.models;

import jakarta.persistence.*;
import lombok.*;
//import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="users")
public class ECommerceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    // private String name;

    public ECommerceUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
