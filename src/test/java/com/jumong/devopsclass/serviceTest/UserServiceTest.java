package com.jumong.devopsclass.serviceTest;

import com.jumong.devopsclass.dtos.request.RegisterRequest;
import com.jumong.devopsclass.dtos.response.RegisterResponse;
import com.jumong.devopsclass.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


}
