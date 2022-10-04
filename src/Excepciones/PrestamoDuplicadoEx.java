/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author cardo
 */
public class PrestamoDuplicadoEx extends RuntimeException {

    public PrestamoDuplicadoEx() {
        super("Ya existe un préstamo registrado con el código ingresado");
    }
}
