package com.project.shopapp.services.impl;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.models.Category;
import com.project.shopapp.repositories.CategoryRepository;
import com.project.shopapp.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryReposity;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categoryReposity.save(newCategory);
    }

    @Override
    public Category getCategoryById(long id) {
        // return categoryReposity.findById(id).orElse(null); // Tim ra category co id dc nhap va ko thay tra ve null
        return categoryReposity.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found")); // Tra ve exception va ben trong la bieu thuc lambda
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryReposity.findAll();
    }

    @Override
    public Category updateCategory(long categoryId, CategoryDTO categoryDTO) {
        Category existingCategory = getCategoryById(categoryId);
        existingCategory.setName(categoryDTO.getName());
        return categoryReposity.saveAndFlush(existingCategory);
    }

    @Override
    public void deleteCategory(long id) {
        categoryReposity.deleteById(id);
    }
}
