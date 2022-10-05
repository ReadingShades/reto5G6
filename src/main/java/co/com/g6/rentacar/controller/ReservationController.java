/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.controller;

import co.com.g6.rentacar.model.Reservation;
import co.com.g6.rentacar.service.ReservationServiceImpl;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
@CrossOrigin
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

    @GetMapping("/report-dates/{date1}/{date2}")
    public List<Reservation> getReservationsInPeriod(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {        
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate date1F = LocalDate.parse(date1);
        LocalDate date2F = LocalDate.parse(date2);
        Date date1FD = Date.from(date1F.atStartOfDay(defaultZoneId).toInstant());
        Date date2FD = Date.from(date2F.atStartOfDay(defaultZoneId).toInstant());        
        return reservationService.getReservationsBetweenDates(date1FD, date2FD);
    }
}
