package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.exception.ElibAPIException;
import com.dtu.elibrary.model.Role;
import com.dtu.elibrary.model.User;
import com.dtu.elibrary.payload.RegisterDto;
import com.dtu.elibrary.repository.RoleRepository;
import com.dtu.elibrary.repository.UserRepository;
import com.dtu.elibrary.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    RoleRepository roleRepository;

    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public String register(RegisterDto registerDto) {
        // Check if database exist username or not
        if (userRepository.existsByUsername(registerDto.getUsername()))
            throw new ElibAPIException(HttpStatus.BAD_REQUEST, "This username is already used");
        if (userRepository.existsByEmail(registerDto.getEmail()))
            throw new ElibAPIException(HttpStatus.BAD_REQUEST, "This email is already used");

        User newUser = new User();
        newUser.setName(registerDto.getName());
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(registerDto.getPassword());
        newUser.setPhone(registerDto.getPhone());
        newUser.setAge(LocalDate.now().getYear() - registerDto.getBirthday().getYear());
        newUser.setDate(LocalDate.now());
        newUser.setGender(registerDto.isGender());

        Role role = roleRepository.findByRoleName("ROLE_USER");
        newUser.setRole(role);

        userRepository.save(newUser);

        return "User register successfully";
    }
}
