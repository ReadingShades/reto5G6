/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.controller;

import co.com.g6.rentacar.model.Reservation;
import co.com.g6.rentacar.service.ReservationCountByClientDTO;
import co.com.g6.rentacar.service.ReservationServiceImpl;
import java.util.HashMap;
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
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Integer Id) {
        return reservationService.getReservation(Id);
    }

    @PostMapping({"/save", "all"})
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Reservation reservation) {
        reservationService.delete(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer Id) {
        reservationService.deleteById(Id);
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        reservationService.deleteAll();
    }

    @GetMapping("/report-status")
    public HashMap<String, Integer> getReportStatus() {
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-dates/{startDate}/{endDate}")
    public List<Reservation> getReservationsInPeriod(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {                
        return reservationService.getReservationsBetweenDates(startDate, endDate);
    }
    
    @GetMapping("/report-clients")
    public List<ReservationCountByClientDTO> getReservationsInPeriod(){
        return reservationService.getClientReport();
    }
}
