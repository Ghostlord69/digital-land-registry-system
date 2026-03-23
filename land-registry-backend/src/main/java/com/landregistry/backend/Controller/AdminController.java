package com.landregistry.backend.Controller;

import com.landregistry.backend.Model.Role;
import com.landregistry.backend.Service.UserService;
import com.landregistry.backend.response.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/assign-role")
    public ApiResponse<String> assignRole(@RequestParam Long userId,
                                          @RequestParam String role) {

        userService.assignRole(userId, Role.valueOf(role));

        return new ApiResponse<>(true, "Role assigned", null);
    }
}
