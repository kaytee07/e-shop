package com.shop.eshop.modules.identity.repository;

import com.shop.eshop.modules.identity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
