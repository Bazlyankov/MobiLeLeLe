package com.example.mobilelele.service;

import com.example.mobilelele.models.DTOs.UserRegistrationDTO;
import com.example.mobilelele.models.entities.UserEntity;
import com.example.mobilelele.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static PasswordEncoder passwordEncoder = null;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    private static UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()))
                .setEmail(userRegistrationDTO.email());
    }
}
