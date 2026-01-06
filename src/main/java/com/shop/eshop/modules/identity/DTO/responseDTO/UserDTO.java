package com.shop.eshop.modules.identity.DTO.responseDTO;

import com.shop.eshop.modules.identity.model.enums.Role;

import java.util.UUID;

public record UserDTO (
        UUID userId,
        String firstname,
        String lastname,
        String email,
        Role role,
        boolean active,
        boolean verified
){}
