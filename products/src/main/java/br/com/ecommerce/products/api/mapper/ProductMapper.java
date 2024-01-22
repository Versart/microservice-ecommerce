package br.com.ecommerce.products.api.mapper;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.ecommerce.products.api.model.ProductResponse;
import br.com.ecommerce.products.domain.model.Product;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    

    private final ModelMapper modelMapper;

    public ProductResponse toModel(Product product){
        return modelMapper.map(product, ProductResponse.class);
    }

    public Page<ProductResponse> toModelPage(Page<Product> productPage){
        return productPage.map(this::toModel);
    }
}
