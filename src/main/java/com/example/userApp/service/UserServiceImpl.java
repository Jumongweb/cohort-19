package com.example.userApp.service;

import com.example.userApp.Exceptions.UserNotFoundException;
import com.example.userApp.data.models.User;
import com.example.userApp.data.repositories.UserRepository;
import com.example.userApp.dtos.request.LoginRequest;
import com.example.userApp.dtos.request.RegisterRequest;
import com.example.userApp.dtos.response.LoginResponse;
import com.example.userApp.dtos.response.RegisterResponse;
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
