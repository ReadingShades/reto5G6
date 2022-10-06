/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Caramu
 */
@Entity
//@Table(name = "CLIENT")
@Table(name = "Client")
public class Client implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(name = "email", length = 20)
    private String email;    
    @Column(name = "password", length = 45)
    private String password;
    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "age")
    private Integer age;
    // Relationship mapping
    // Bidirectional One-to-One relationship to MESSAGE table
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    // Bidirectional One-to-One relationship to RESERVATION table
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    public Client() {
    }

    public Client(Integer id, String email, String name, String password, Integer age, List<Message> messages, List<Reservation> reservations) {
        this.idClient = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Client(String email, String name, String password, Integer age, List<Message> messages, List<Reservation> reservations) {
        this.idClient = null;
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }    

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", email=" + email + ", password=" + password + ", name=" + name + ", age=" + age + ", messages=" + messages + ", reservations=" + reservations + '}';
    }
}
