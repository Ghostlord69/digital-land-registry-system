package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.UserDTO;
import com.landregistry.backend.response.ApiResponse;
import com.landregistry.backend.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ApiResponse<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {

        UserDTO user = userService.registerUser(userDTO);

        return new ApiResponse<>(
                true,
                "User registered successfully",
                user
        );
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> getAllUsers() {

        List<UserDTO> users = userService.getAllUsers();

        return new ApiResponse<>(
                true,
                "Users fetched successfully",
                users
        );
    }
}