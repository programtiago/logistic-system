package com.devtiago.logisticsystem.controller;

import com.devtiago.logisticsystem.domain.Product;
import com.devtiago.logisticsystem.repository.ProductRepository;
import com.devtiago.logisticsystem.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService  productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable Long id){
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@Valid @RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId, @Valid @RequestBody Product product){
        if (!productRepository.existsById(productId)){
            return ResponseEntity.notFound().build();
        }

        product.setId(productId);
        product = productService.save(product);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Long productId){
        if (!productRepository.existsById(productId)){
            return ResponseEntity.notFound().build();
        }

        productService.delete(productId);

        return ResponseEntity.noContent().build();
    }
}
