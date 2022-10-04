/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author cardo
 */
public class DeudaDuplicadaEx extends RuntimeException{
    
    public DeudaDuplicadaEx(){
        super("Ya existe una deuda registrada con el código ingresado");
    }
    
}
