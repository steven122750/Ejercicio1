/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author cardo
 */
public class Deuda {

    private int codigo;
    private String aQuienDebo;
    private String fechaDeuda;
    private float cantidad;

    public Deuda(int codigo, String aQuienDebo, String fechaDeuda, float cantidad) {
        this.codigo = codigo;
        this.aQuienDebo = aQuienDebo;
        this.fechaDeuda = fechaDeuda;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getaQuienDebo() {
        return aQuienDebo;
    }

    public void setaQuienDebo(String aQuienDebo) {
        this.aQuienDebo = aQuienDebo;
    }

    public String getFechaDeuda() {
        return fechaDeuda;
    }

    public void setFechaDeuda(String fechaDeuda) {
        this.fechaDeuda = fechaDeuda;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    
  
}
