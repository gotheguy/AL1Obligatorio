/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Signature
 */
public class Crucero {
    
    private String nombre;
    private int cantidadHabitaciones;
    private int categoria;
    
    private Set<Cliente> pasajeros;
    private Set<Servicio> servicios;
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Set<Cliente> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Set<Cliente> pasajeros) {
        this.pasajeros = pasajeros;
    }
    
     public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    
     public Crucero(String nombre, int cantidadHabitaciones,int categoria) {

        this.setNombre(nombre);
        this.setCantidadHabitaciones(cantidadHabitaciones);
        this.setCategoria(categoria);
        
        this.setPasajeros(new HashSet<Cliente>());
        this.setServicios(new HashSet<Servicio>());
    }
    
}
