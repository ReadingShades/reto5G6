/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Caramu
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCRUDRepository categoryCRUDRepository;
    
    public List<Category> getAll() { return (List<Category>) categoryCRUDRepository.findAll(); }
    
    public Optional<Category> getCategory(Integer id) { return categoryCRUDRepository.findById(id); }
    
    public Category save(Category category) { return categoryCRUDRepository.save(category); }
    
    public void delete(Category category) { categoryCRUDRepository.delete(category); }
    
    public void deleteById(Integer categoryId) { categoryCRUDRepository.deleteById(categoryId); }
}
