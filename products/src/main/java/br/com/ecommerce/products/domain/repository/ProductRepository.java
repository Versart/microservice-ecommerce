package br.com.ecommerce.products.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.products.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
