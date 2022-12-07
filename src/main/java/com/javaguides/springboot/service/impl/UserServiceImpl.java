package com.javaguides.springboot.service.impl;

import com.javaguides.springboot.dto.RegistrationDto;
import com.javaguides.springboot.entity.Role;
import com.javaguides.springboot.entity.User;
import com.javaguides.springboot.repository.RoleRepository;
import com.javaguides.springboot.repository.UserRepository;
import com.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void savedUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + "" + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        // use spring security to encrypt the password
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }
}
