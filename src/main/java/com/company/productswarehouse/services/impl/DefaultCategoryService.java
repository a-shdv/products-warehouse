package com.company.productswarehouse.services.impl;

import com.company.productswarehouse.dtos.CategoryDto;
import com.company.productswarehouse.entities.Category;
import com.company.productswarehouse.exceptions.CategoryAlreadyExistsException;
import com.company.productswarehouse.exceptions.CategoryListIsEmptyException;
import com.company.productswarehouse.exceptions.CategoryNotFoundException;
import com.company.productswarehouse.repos.CategoryRepo;
import com.company.productswarehouse.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepo categoryRepo;


    @Override
    @Transactional
    public List<Category> findAll() throws CategoryListIsEmptyException {
        List<Category> categories = categoryRepo.findAll();
        if (categories.isEmpty()) {
            throw new CategoryListIsEmptyException("Список категорий пуст!");
        }
        return categories;
    }

    @Override
    @Transactional
    public Category findById(UUID uuid) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findById(uuid);
        if (!category.isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        return category.get();
    }

    @Override
    @Transactional
    public Category save(CategoryDto categoryDto) throws CategoryAlreadyExistsException {
        Category category = CategoryDto.toCategory(categoryDto);
        if (categoryRepo.findByTitle(category.getTitle()).isPresent()) {
            throw new CategoryAlreadyExistsException("Категория уже существует!");
        }
        return categoryRepo.save(category);
    }

    @Override
    @Transactional
    public UUID editById(UUID id, CategoryDto categoryDto) throws CategoryNotFoundException {
        Optional<Category> dbCategory = categoryRepo.findById(id);
        Category category = CategoryDto.toCategory(categoryDto);
        if (!dbCategory.isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        dbCategory.get().setTitle(category.getTitle());
        categoryRepo.save(dbCategory.get());
        return dbCategory.get().getId();
    }

    @Override
    @Transactional
    public UUID deleteById(UUID id) throws CategoryNotFoundException {
        if (!categoryRepo.findById(id).isPresent()) {
            throw new CategoryNotFoundException("Категория не найдена!");
        }
        categoryRepo.deleteById(id);
        return id;
    }
}
