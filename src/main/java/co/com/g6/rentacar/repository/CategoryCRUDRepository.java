/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Caramu
 */
public interface CategoryCRUDRepository extends CrudRepository<Category, Integer> {
    
}
