/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author exkapp
 */
public class daoNino implements IDAO<Nino>{
    
    private nina  nina = new nina();
    private Conection con =Conection.getInstance();
    private String sql="";
    
    @Override
    public boolean insertar(Nino t) {
        sql = "INSERT INTO niño (id, nombre, apellido, edad, telefono) VALUES ('" + t.getId() + "','"+t.getNombre()+"','"+t.getApellido()+"','"+t.getEdad()+"','" + t.getTelefono()+"');";
        return con.execute(sql);
    }

    @Override
    public boolean modificar(Nino t) {
        sql = "UPDATE niño SET nombre = '" +t.getNombre()+"' ,apellido = '" +t.getApellido() +"', edad = '" + t.getEdad() +"', telefono = '" + t.getTelefono() +"' WHERE (id = '" + t.getId()+"');"; 
        return con.execute(sql);
    }

    @Override
    public boolean eliminar(Nino id) {
        sql = "DELETE FROM niño WHERE (id = '" + id.getId() + "');";
        return con.execute(sql);
    }

    @Override
    public ResultSet buscarById(Nino id) {
        sql = "SELECT * FROM niño WHERE(id = '"+ id.getId()+"');";
        return con.executeQuery(sql);
    }

    @Override
    public ResultSet buscarTodos() {
        sql = "SELECT * FROM niño;";
        return con.executeQuery(sql);
        
    }
    
}
