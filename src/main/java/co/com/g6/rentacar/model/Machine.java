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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Caramu
 */
@Entity
//@Table(name = "MACHINE")
@Table(name = "Machines")
public class Machine implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "brand", length = 45)
    private String brand;
    @Column(name = "year")
    private Integer year;
    @Column(name = "description", length = 250)
    private String description;    
    // Relationship mapping
    // Bidirectional Many-to-One relationship to CATEGORY table
    @ManyToOne
    @JsonIgnoreProperties("machines")
    @JoinColumn(name="idCategory", referencedColumnName = "id")
    private Category category;
    // Relationship mapping
    // Bidirectional One-to-One relationship to MESSAGE table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Message> messages;
    // Bidirectional One-to-One relationship to RESERVATION table
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine","messages"})
    private List<Reservation> reservations;

    public Machine() {
    }

    public Machine(Integer id, String brand, String model, String name, Integer year) {
        this.id = id;
        this.brand = brand;
        this.description = model;
        this.name = name;
        this.year = year;
    }

    public Machine(String brand, String model, String name, Integer year) {
        this.id = null;
        this.brand = brand;
        this.description = model;
        this.name = name;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    
}
