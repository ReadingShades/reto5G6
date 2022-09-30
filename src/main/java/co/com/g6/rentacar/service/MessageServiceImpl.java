/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Message;
import co.com.g6.rentacar.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caramu
 */
@Service
public class MessageServiceImpl implements MessageService {
    
    @Autowired
    private MessageRepository messageRepositorio;

    @Override
    public List<Message> getAll() {
        return messageRepositorio.getAll();
    }

    @Override
    public Optional<Message> getMessage(Integer messageId) {
        return messageRepositorio.getMessage(messageId);
    }

    @Override
    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepositorio.save(message);
        } else {
            Optional<Message> message1 = messageRepositorio.getMessage(message.getIdMessage());
            if (message1.isEmpty()) {
                return messageRepositorio.save(message);
            } else {
                return message;
            }
        }
    }

    @Override
    public Message update(Message dataCarrier) {
        if (dataCarrier.getIdMessage()!= null) {
            // Optional allows us to check for nullability/existance of an entry
            Optional<Message> currentEntry = messageRepositorio.getMessage(dataCarrier.getIdMessage());
            if (currentEntry.isEmpty()) {
                // If no matching Id/Entry is found then create a new dataCarrier/entry
                return messageRepositorio.save(dataCarrier);
            } else {
                // If a matching Id/Entry is found then retrieve current entry 
                // to and update fields but preserve relations
                Message updatedEntry = currentEntry.get();
                updatedEntry.setMessageText(dataCarrier.getMessageText());                
                return messageRepositorio.save(updatedEntry);
            }
        } else {
            // If Id is missing from dataCarrier then return it as response
            return dataCarrier;            
        }
    }

    @Override
    public void delete(Message message) {
        messageRepositorio.delete(message);
    }

    @Override
    public void deleteById(Integer id) {
        messageRepositorio.deleteById(id);
    }

    @Override
    public void deleteAll() {
        messageRepositorio.deleteAll();
    }
}
