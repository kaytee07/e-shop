package com.shop.eshop.modules.identity.model;

import com.shop.eshop.modules.identity.model.enums.Role;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password_hash;
    private Role Role;
    private boolean is_active;
    private boolean is_verified;

}
