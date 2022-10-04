/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cardo
 */
public interface IControladorService {

    public boolean guardarDeuda(int codigo, String aQuienDebo, String fechaDeuda, float cantidad);

    public boolean guardarPrestamo(int codigo, String quienMeDebe, String fechaDeuda, float cantidad);

    public DefaultTableModel listar();

    public DefaultTableModel listarPrestamo();

    public List<String> buscar(int codigo);

    public List<String> buscarPrestamo(int codigo);

    public boolean modificar(int codigo, String aQuienDebo, String fechaDeuda, float cantidad);

    public boolean modificarPrestamo(int codigo, String quienMeDebe, String fechaDeuda, float cantidad);

    public boolean eliminar(int codigo);

    public boolean eliminarPrestamo(int codigo);
}
