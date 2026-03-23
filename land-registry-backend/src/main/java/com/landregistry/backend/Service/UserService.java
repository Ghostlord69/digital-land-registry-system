package com.landregistry.backend.Service;

import com.landregistry.backend.Model.Role;
import com.landregistry.backend.dto.UserDTO;
import com.landregistry.backend.exception.ResourceNotFoundException;
import com.landregistry.backend.mapper.UserMapper;
import com.landregistry.backend.Model.User;
import com.landregistry.backend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void assignRole(Long userId, Role role) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setRole(role);

        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}