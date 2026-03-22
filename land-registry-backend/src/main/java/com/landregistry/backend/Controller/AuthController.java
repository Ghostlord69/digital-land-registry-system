package com.landregistry.backend.Controller;

import com.landregistry.backend.Security.JwtUtil;
import com.landregistry.backend.dto.*;
import com.landregistry.backend.mapper.UserMapper;
import com.landregistry.backend.Model.Role;
import com.landregistry.backend.Model.User;
import com.landregistry.backend.Repository.UserRepository;
import com.landregistry.backend.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REGISTER (Signup)
    @PostMapping("/register")
    public ApiResponse<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {

        // check if email already exists
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = UserMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        // assign default role
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        return new ApiResponse<>(
                true,
                "User registered successfully",
                UserMapper.toDTO(savedUser)
        );
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user);

        return new ApiResponse<>(
                true,
                "Login successful",
                new LoginResponse(token)
        );
    }
}