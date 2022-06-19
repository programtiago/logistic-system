package com.devtiago.logisticsystem.service;

import com.devtiago.logisticsystem.domain.Product;
import com.devtiago.logisticsystem.domain.exception.DomainException;
import com.devtiago.logisticsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product get(Long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new DomainException("Product not found"));
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
}
