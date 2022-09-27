/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Caramu
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;
    
    public List<Message> getAll() { return (List<Message>) messageCRUDRepository.findAll(); }
    
    public Optional<Message> getMessage(Integer id) { return messageCRUDRepository.findById(id); }
    
    public Message save(Message message) { return messageCRUDRepository.save(message); }
    
    public void delete(Message message) { messageCRUDRepository.delete(message); }
    
    public void deleteById(Integer messageId) { messageCRUDRepository.deleteById(messageId); }
    
    public void deleteAll() { messageCRUDRepository.deleteAll(); }
}
