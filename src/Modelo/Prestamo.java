/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author cardo
 */
public class Prestamo {
    
    private int codigo;
    private String quienMeDebe;
    private String fechaDeuda;
    private float cantidad;

    public Prestamo(int codigo, String quienMeDebe, String fechaDeuda, float cantidad) {
        this.codigo = codigo;
        this.quienMeDebe = quienMeDebe;
        this.fechaDeuda = fechaDeuda;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getQuienMeDebe() {
        return quienMeDebe;
    }

    public void setQuienMeDebe(String quienMeDebe) {
        this.quienMeDebe = quienMeDebe;
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
