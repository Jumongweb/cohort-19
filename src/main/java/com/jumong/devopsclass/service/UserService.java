package com.jumong.devopsclass.service;

import com.jumong.devopsclass.Exceptions.UserNotFoundException;
import com.jumong.devopsclass.dtos.request.LoginRequest;
import com.jumong.devopsclass.dtos.request.RegisterRequest;
import com.jumong.devopsclass.dtos.response.LoginResponse;
import com.jumong.devopsclass.dtos.response.RegisterResponse;

import javax.security.auth.login.LoginException;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest request) throws LoginException, UserNotFoundException;

}
