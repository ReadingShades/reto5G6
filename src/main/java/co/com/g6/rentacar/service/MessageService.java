/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Message;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Caramu
 */
public interface MessageService {    
    
    public List<Message> getAll();

    public Optional<Message> getMessage(Integer messageId);

    public Message save(Message message);
    
    public Message update(Message message);
    
    public void delete(Message message);
    
    public void deleteById(Integer id);
}
