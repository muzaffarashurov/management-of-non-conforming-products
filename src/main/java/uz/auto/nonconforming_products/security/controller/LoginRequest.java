package uz.auto.nonconforming_products.security.controller;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;

}
