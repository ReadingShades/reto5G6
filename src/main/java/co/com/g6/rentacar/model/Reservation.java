/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "RESERVATION")
public class Reservation implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column
    private Date startDate;
    @Column
    private Date devolutionDate;
    @Column
    private String status = "created";    
    // Relationship mapping
    // Unidirectional Many-to-One relationship to MACHINE table
    @ManyToOne
    @JoinColumn(name = "MACHINE_ID")
    @JsonIgnoreProperties("reservations")
    private Machine machine;
    // Bidirectional Many-to-One relationship to CLIENT table
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    @Column(name = "score")
    private Integer score;

    public Reservation() {
    }

    public Reservation(Date startDate, Date devolutionDate) {
        this.idReservation = null;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = "created";
    }

    public Reservation(Integer id, Date startDate, Date devolutionDate) {
        this.idReservation = id;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = "created";
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
