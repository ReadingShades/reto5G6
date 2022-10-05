/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

/**
 *
 * @author Caramu
 */
public class ReservationTotalCountDTO {
    private final String total = "total";    
    private final Integer value;
    
    ReservationTotalCountDTO(Integer value){
        this.value = value;
    }

    public String getTotal() {
        return total;
    }

    public Integer getValue() {
        return value;
    }
    
    
}
