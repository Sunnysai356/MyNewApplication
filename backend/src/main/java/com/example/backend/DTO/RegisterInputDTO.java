package com.example.backend.DTO;

import lombok.Data;

@Data
public class RegisterInputDTO {
    private String username;
    private String password;
    private String email;
}
