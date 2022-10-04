/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Interfaces.IControladorService;
import Modelo.ClsConexion;
import Modelo.Deuda;
import Modelo.Prestamo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cardo
 */
public class Controlador implements IControladorService {

    ClsConexion conexion = new ClsConexion();

    public Controlador() {

    }

//Subir proyectos a gitHub

//git init
//git status
//git add .
//git commit -m "Primer parte"
//config --global user.email cardona21507@gmail.com
//config --global user.name steven122750
//git commit -m "Primer parte"
//git branch -m main
//git remote add origin Aqui va el link del repositorio
//git push -u origin main

//Agregar cambios

//git status
//git add .
//git commit -m "Se agrega cambio"
//git push -u origin main

    @Override
    public boolean guardarDeuda(int codigo, String aQuienDebo, String fechaDeuda, float cantidad) {

        if (buscar(codigo) != null) {
        }

        Deuda deuda = new Deuda(codigo, aQuienDebo, fechaDeuda, cantidad);

        conexion.conectar();

        try {

            conexion.getSentenciaSQL().execute("insert into deuda(codigo,aQuienDebo,fechaDeuda,cantidad) "
                    + "values('" + deuda.getCodigo() + "','"
                    + deuda.getaQuienDebo() + "','"
                    + deuda.getFechaDeuda() + "',"
                    + deuda.getCantidad() + ")");
            conexion.desconectar();
            return true;

        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    @Override
    public boolean guardarPrestamo(int codigo, String quienMeDebe, String fechaDeuda, float cantidad) {

        if (buscarPrestamo(codigo) != null) {
        }

        Prestamo prestamo = new Prestamo(codigo, quienMeDebe, fechaDeuda, cantidad);

        conexion.conectar();

        try {

            conexion.getSentenciaSQL().execute("insert into prestamo(codigo,quienMeDebe,fechaDeuda,cantidad) "
                    + "values('" + prestamo.getCodigo() + "','"
                    + prestamo.getQuienMeDebe() + "','"
                    + prestamo.getFechaDeuda() + "',"
                    + prestamo.getCantidad() + ")");
            conexion.desconectar();
            return true;

        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }

    }

    @Override
    public DefaultTableModel listar() {
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Código", "A quién debo", "Fecha de deuda", "Cantidad"};
        temporal = new DefaultTableModel(
                new Object[][]{}, nombreColumnas);
        conexion.conectar();
        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select codigo,aQuienDebo,fechaDeuda,"
                            + "cantidad from deuda order by codigo"));
            while (conexion.getResultadoDB().next()) {
                temporal.addRow(new Object[]{
                    conexion.getResultadoDB().getString("codigo"),
                    conexion.getResultadoDB().getString("aQuienDebo"),
                    conexion.getResultadoDB().getString("fechaDeuda"),
                    conexion.getResultadoDB().getInt("cantidad")});
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).
                    log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }

        return temporal;
    }

    @Override
    public DefaultTableModel listarPrestamo() {
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Código", "Quén me debe", "Fecha de deuda", "Cantidad"};
        temporal = new DefaultTableModel(
                new Object[][]{}, nombreColumnas);
        conexion.conectar();
        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select codigo,quienMeDebe,fechaDeuda,"
                            + "cantidad from prestamo order by codigo"));
            while (conexion.getResultadoDB().next()) {
                temporal.addRow(new Object[]{
                    conexion.getResultadoDB().getString("codigo"),
                    conexion.getResultadoDB().getString("quienMeDebe"),
                    conexion.getResultadoDB().getString("fechaDeuda"),
                    conexion.getResultadoDB().getInt("cantidad")});
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).
                    log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }

        return temporal;

    }

    @Override
    public List<String> buscar(int codigo) {

        List<String> temp = new ArrayList<String>();

        conexion.conectar();

        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select codigo,aQuienDebo,fechaDeuda,"
                            + "cantidad from deuda where "
                            + "codigo='" + codigo + "'"));

            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("codigo"));
                temp.add(conexion.getResultadoDB().getString("aQuienDebo"));
                temp.add(conexion.getResultadoDB().getString("fechaDeuda"));
                temp.add(conexion.getResultadoDB().getInt("cantidad") + "");
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName())
                    .log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }
        return temp;
    }

    @Override
    public List<String> buscarPrestamo(int codigo) {

        List<String> temp = new ArrayList<String>();

        conexion.conectar();

        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select codigo,quienMeDebe,fechaDeuda,"
                            + "cantidad from prestamo where "
                            + "codigo='" + codigo + "'"));

            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("codigo"));
                temp.add(conexion.getResultadoDB().getString("quienMeDebe"));
                temp.add(conexion.getResultadoDB().getString("fechaDeuda"));
                temp.add(conexion.getResultadoDB().getInt("cantidad") + "");
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName())
                    .log(Level.SEVERE, null, ex);
            conexion.desconectar();
        }
        return temp;
    }

    @Override
    public boolean modificar(int codigo, String aQuienDebo, String fechaDeuda, float cantidad) {
        Deuda deuda = new Deuda(codigo, aQuienDebo, fechaDeuda, cantidad);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute("update deuda set aQuienDebo='" + deuda.getaQuienDebo()
                    + "',fechaDeuda='" + deuda.getFechaDeuda() + "',"
                    + "cantidad=" + deuda.getCantidad()
                    + " where codigo='" + deuda.getCodigo() + "'");
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    @Override
    public boolean modificarPrestamo(int codigo, String quienMeDebe, String fechaDeuda, float cantidad) {
        Prestamo prestamo = new Prestamo(codigo, quienMeDebe, fechaDeuda, cantidad);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute("update prestamo set quienMeDebe='" + prestamo.getQuienMeDebe()
                    + "',fechaDeuda='" + prestamo.getFechaDeuda() + "',"
                    + "cantidad=" + prestamo.getCantidad()
                    + " where codigo='" + prestamo.getCodigo() + "'");
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    @Override
    public boolean eliminar(int codigo) {

        conexion.conectar();

        try {
            conexion.getSentenciaSQL().execute("delete from deuda where codigo='" + codigo + "'");
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    @Override
    public boolean eliminarPrestamo(int codigo) {

        conexion.conectar();

        try {
            conexion.getSentenciaSQL().execute("delete from prestamo where codigo='" + codigo + "'");
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }
}
