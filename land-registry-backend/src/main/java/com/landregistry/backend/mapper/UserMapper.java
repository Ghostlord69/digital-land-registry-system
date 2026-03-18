package com.landregistry.backend.mapper;

import com.landregistry.backend.dto.UserDTO;
import com.landregistry.backend.Model.User;

public class UserMapper {

    private UserMapper(){}
    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());

        return dto;
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return user;
    }
}