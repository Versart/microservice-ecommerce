package br.com.ecommerce.auth.api.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private String email;

    private LocalDateTime DateOfCreation = LocalDateTime.now();
}
