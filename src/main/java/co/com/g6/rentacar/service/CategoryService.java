/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Category;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Caramu
 */
public interface CategoryService {    
    
    public List<Category> getAll();

    public Optional<Category> getCategory(Integer categoryId);

    public Category save(Category category);
    
    public Category update(Category category);
    
    public void delete(Category category);
    
    public void deleteById(Integer id);
    
    public void deleteAll();
}
