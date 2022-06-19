package com.devtiago.logisticsystem.controller;


import com.devtiago.logisticsystem.domain.Category;
import com.devtiago.logisticsystem.repository.CategoryRepository;
import com.devtiago.logisticsystem.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/categories")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id){
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category add(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Category> update(@PathVariable Long categoryId, @Valid @RequestBody Category category){
        if (!categoryRepository.existsById(categoryId)){
            return ResponseEntity.notFound().build();
        }

        category.setId(categoryId);
        category = categoryService.save(category);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> delete(@PathVariable Long categoryId){
        if (!categoryRepository.existsById(categoryId)){
            return ResponseEntity.notFound().build();
        }

        categoryService.delete(categoryId);

        return ResponseEntity.noContent().build();
    }


}
