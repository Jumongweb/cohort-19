package com.example.userApp.serviceTest;

import com.example.userApp.Exceptions.UserNotFoundException;
import com.example.userApp.dtos.request.LoginRequest;
import com.example.userApp.dtos.request.RegisterRequest;
import com.example.userApp.dtos.response.LoginResponse;
import com.example.userApp.dtos.response.RegisterResponse;
import com.example.userApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.LoginException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    public UserService userService;

    @Test
    public void testRegisterUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("testUser@gmail.com");
        registerRequest.setPassword("password");
        RegisterResponse response = userService.register(registerRequest);
        assertThat(response).isNotNull();
    }

    @Test
    public void testLoginUser() throws UserNotFoundException, LoginException {
        testRegisterUser();
        LoginRequest request = new LoginRequest();
        request.setEmail("testUser@gmail.com");
        request.setPassword("password");
        LoginResponse response = userService.login(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Login successful");

    }


}
