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
    private String email;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String password;
    // private String name;


    public ECommerceUser(String email, String firstName, String lastName, String username, String password){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

    }

}
