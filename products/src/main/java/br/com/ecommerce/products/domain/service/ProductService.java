package br.com.ecommerce.products.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecommerce.products.api.mapper.ProductMapper;
import br.com.ecommerce.products.api.model.ProductResponse;
import br.com.ecommerce.products.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public Page<ProductResponse> getAll(Pageable pageable) {
        return mapper.toModelPage(productRepository.findAll(pageable));
    }
}
