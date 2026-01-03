package com.shop.eshop.modules.identity.model;

import com.shop.eshop.modules.identity.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Size(max = 50)
    private String firstname;

    @NotBlank
    @Size(max = 50)
    private String lastname;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @ToString.Exclude
    private String password_hash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "active")
    private boolean active;

    @Column(name = "verified")
    private boolean verified;

}
