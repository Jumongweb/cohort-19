package com.jumong.devopsclass.serviceTest;

import com.jumong.devopsclass.Exceptions.UserNotFoundException;
import com.jumong.devopsclass.dtos.request.LoginRequest;
import com.jumong.devopsclass.dtos.request.RegisterRequest;
import com.jumong.devopsclass.dtos.response.LoginResponse;
import com.jumong.devopsclass.dtos.response.RegisterResponse;
import com.jumong.devopsclass.service.UserService;
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
