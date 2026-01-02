package com.shop.eshop.modules.identity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @NotNull
    private User user;

    @NotBlank
    private String phoneNumber;


    @Size(max = 100)
    private String StreetName;

    @NotBlank
    @Size(max = 50)
    private String city;

    @Size(max = 10)
    private String zip;

    @NotBlank
    @Size(max = 50)
    private String country;

    @Size(max = 15)
    private String digitalAddress;
}
