package com.rovinn.backendfrontends.model;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String token;
}
