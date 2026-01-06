package com.shop.eshop.modules.identity.service;

import com.shop.eshop.modules.identity.DTO.responseDTO.UserDTO;
import com.shop.eshop.modules.identity.model.User;
import com.shop.eshop.modules.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO createUser(User user){
        return null;
    }

    
}
