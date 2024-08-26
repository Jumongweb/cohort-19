package com.jumong.devopsclass.service;

import com.jumong.devopsclass.Exceptions.UserNotFoundException;
import com.jumong.devopsclass.data.models.User;
import com.jumong.devopsclass.data.repositories.UserRepository;
import com.jumong.devopsclass.dtos.request.LoginRequest;
import com.jumong.devopsclass.dtos.request.RegisterRequest;
import com.jumong.devopsclass.dtos.response.LoginResponse;
import com.jumong.devopsclass.dtos.response.RegisterResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword());
        userRepository.save(newUser);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMessage("Registration successful");
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws LoginException, UserNotFoundException {
        User user = userRepository.findByEmail(request.getEmail());
        if(user != null) {
            if(user.getPassword().equals(request.getPassword())) {
                user.setLoginStatus(true);
                userRepository.save(user);
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMessage("Login successful");
                return loginResponse;
            }
            else{
                throw new LoginException("Invalid email or password");
            }
        }
        else {
            throw new UserNotFoundException("User not found");
        }
    }
}
