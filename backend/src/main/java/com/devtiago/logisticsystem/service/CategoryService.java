package com.devtiago.logisticsystem.service;

import com.devtiago.logisticsystem.domain.Category;
import com.devtiago.logisticsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {

        return categoryRepository.save(category);
    }

    @Transactional
    public void delete(Long categoryId) {

        categoryRepository.deleteById(categoryId);
    }
}
