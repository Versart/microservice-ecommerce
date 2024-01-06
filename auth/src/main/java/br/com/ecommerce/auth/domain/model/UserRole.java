package br.com.ecommerce.auth.domain.model;

public enum UserRole {
    
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }
    
}
