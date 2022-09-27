/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Machine;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Caramu
 */
public interface MachineService {    
    
    public List<Machine> getAll();

    public Optional<Machine> getMachine(Integer machineId);

    public Machine save(Machine machine);
    
    public Machine update(Machine machine);
    
    public void delete(Machine machine);
    
    public void deleteById(Integer id);
}
