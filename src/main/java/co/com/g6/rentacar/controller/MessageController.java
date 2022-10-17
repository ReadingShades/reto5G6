/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.controller;

import co.com.g6.rentacar.model.Message;
import co.com.g6.rentacar.service.MessageServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Caramu
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;
    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") Integer Id) {
        return messageService.getMessage(Id);
    }

    @PostMapping({"/save","all"})
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }
    
    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Message message) {
        messageService.delete(message);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer Id) {
        messageService.deleteById(Id);
    }
    
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        messageService.deleteAll();
    }
}
