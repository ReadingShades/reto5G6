/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Category;
import co.com.g6.rentacar.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caramu
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepositorio;

    @Override
    public List<Category> getAll() {
        return categoryRepositorio.getAll();
    }

    @Override
    public Optional<Category> getCategory(Integer categoryId) {
        return categoryRepositorio.getCategory(categoryId);
    }

    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepositorio.save(category);
        } else {
            Optional<Category> category1 = categoryRepositorio.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepositorio.save(category);
            } else {
                return category;
            }
        }
    }

    @Override
    public Category update(Category dataCarrier) {        
        if (dataCarrier.getId() != null) {
            // Optional allows us to check for nullability/existance of an entry
            Optional<Category> currentEntry = categoryRepositorio.getCategory(dataCarrier.getId());            
            if (currentEntry.isEmpty()) {
                // If no matching Id/Entry is found then create a new dataCarrier/entry
                return categoryRepositorio.save(dataCarrier);
            } else {
                // If a matching Id/Entry is found then retrieve current entry 
                // to and update fields but preserve relations
                Category updatedEntry = currentEntry.get();                
                updatedEntry.setName(dataCarrier.getName());
                updatedEntry.setDescription(dataCarrier.getDescription());
                return categoryRepositorio.save(updatedEntry);
            }
        } else {
            // If Id is missing from dataCarrier then return it as response
            return dataCarrier;
        }       
    }

    @Override
    public void delete(Category category) {
        categoryRepositorio.delete(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepositorio.deleteById(id);
    }

    @Override
    public void deleteAll() {
        categoryRepositorio.deleteAll();
    }
}
