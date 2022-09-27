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
        if (message.getId() == null) {
            return messageRepositorio.save(message);
        } else {
            Optional<Message> message1 = messageRepositorio.getMessage(message.getId());
            if (message1.isEmpty()) {
                return messageRepositorio.save(message);
            } else {
                return message;
            }
        }
    }

    @Override
    public Message update(Message message) {
        return messageRepositorio.save(message);
    }

    @Override
    public void delete(Message message) {
        messageRepositorio.delete(message);
    }

    @Override
    public void deleteById(Integer id) {
        messageRepositorio.deleteById(id);
    }
}
