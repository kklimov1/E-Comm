package com.example.ECommerce.services;

import com.example.ECommerce.exceptions.IncorrectLoginRequest;
import com.example.ECommerce.exceptions.UsernameTakenException;
import com.example.ECommerce.models.ECommerceUser;
import com.example.ECommerce.repositories.ProductRepository;
import com.example.ECommerce.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    public UserService userService;

    @Mock
    ProductRepository productRepositoryMock;

    @Mock
    UserRepository userRepositoryMock;

    @BeforeAll
    public static void  beforeAll(){
        System.out.println("Starting UserService tests");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("UserService tests complete");
    }

    @BeforeEach
    public void beforeEach(){
        userService = new UserService(userRepositoryMock);
    }

    @Test
    public void testNewUserRegistration() throws UsernameTakenException {
        ECommerceUser register = new ECommerceUser("myUsername", "myPassword");
        ECommerceUser returneValue = new ECommerceUser(1, "myUsername", "myPassword");

        Mockito.when(userRepositoryMock.save(register)).thenReturn(returneValue);

        ECommerceUser registeredUser = userService.save(register);

        Assertions.assertEquals(returneValue, registeredUser);
    }


    @Test
    public void testValidCredentials() throws IncorrectLoginRequest {
        String username = "username";
        String password = "password";
        ECommerceUser returnUser = new ECommerceUser(1, username, password);
        Mockito.when(userRepositoryMock.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(returnUser));
        Optional<ECommerceUser> out = userRepositoryMock.findByUsernameAndPassword(username, password);
        Assertions.assertEquals(Optional.of(returnUser), out);
    }

    @Test
    public void testInvalidCredentials() {
        String username = "username";
        String password = "wrongPassword";
        ECommerceUser eUser = new ECommerceUser(username, password);
        //Mockito.when(userRepositoryMock.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(eUser));
        IncorrectLoginRequest E = Assertions.assertThrows(IncorrectLoginRequest.class, ()->{userService.getUser(username, password);});
        Assertions.assertEquals("Username does not exist in the database", E.getMessage());
    }
}
