package com.example.userApp.service;

import com.example.userApp.Exceptions.UserNotFoundException;
import com.example.userApp.dtos.request.LoginRequest;
import com.example.userApp.dtos.request.RegisterRequest;
import com.example.userApp.dtos.response.LoginResponse;
import com.example.userApp.dtos.response.RegisterResponse;

import javax.security.auth.login.LoginException;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest request) throws LoginException, UserNotFoundException;

}
