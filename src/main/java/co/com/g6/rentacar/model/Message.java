/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Caramu
 */
@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable {

    @Id
    @Column(name = "idMessage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "messageText", length = 4000)
    private String messageText;
    // Relationship mapping
//    // Unidirectional Many-to-One relationship to MACHINE table
    @ManyToOne
    @JoinColumn(name = "MACHINE_ID")
    @JsonIgnoreProperties({"messages","reservations"})
    private Machine machine;
    // Bidirectional Many-to-One relationship to CLIENT table    
    @ManyToOne
    @JoinColumn(name="CLIENT_ID")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Message() {
    }

    public Message(Integer id, String messageText) {
        this.id = id;
        this.messageText = messageText;        
    }
    
     public Message(String messageText) {
        this.id = null;
        this.messageText = messageText;        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }  
    
}
