
package com.TiendaApu.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "tcategorias")
public class Categorias {
   
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column (name = "nombre", length = 255, nullable = false, unique = true)
    private String nombre;
    
    @Column (name = "departamento", length = 255, nullable = false, unique = true)
    private String departamento;
    
   @Column (name = "hab", columnDefinition = "TINYINT", nullable = false)
    private boolean hab;

    
    public Categorias() {
    }

    public Categorias(String nombre, String departamento, boolean hab) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.hab = hab;
    }

    public Categorias(int id, String nombre, String departamento, boolean hab) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.hab = hab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }
    
}