package br.com.ecommerce.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.ecommerce.auth.domain.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    UserDetails findByEmail(String email);
}
