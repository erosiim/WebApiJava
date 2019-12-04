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
public class daoNina implements IDAO<nina>{
    
    private nina  nina = new nina();
    private Conection con =Conection.getInstance();
    private String sql="";
    
    
    @Override
    public ResultSet buscarTodos() {
        sql = "SELECT * FROM niña;";
        return con.executeQuery(sql);
    }

    @Override
    public boolean insertar(nina t) {
       sql = "INSERT INTO niña (id, nombre, apellido, edad, telefono) VALUES ('" + t.getId() + "','"+t.getNombre()+"','"+t.getApellido()+"','"+t.getEdad()+"','" + t.getTelefono()+"');";
        return con.execute(sql);
    }

    @Override
    public boolean modificar(nina t) {
        sql = "UPDATE niña SET nombre = '" +t.getNombre()+"' ,apellido = '" +t.getApellido() +"', edad = '" + t.getEdad() +"', telefono = '" + t.getTelefono() +"' WHERE (id = '" + t.getId()+"');"; 
        return con.execute(sql);
    }

    @Override
    public boolean eliminar(nina id) {
        sql = "DELETE FROM niña WHERE (id = '" + id.getId() + "');";
        return con.execute(sql);
    }

    @Override
    public ResultSet buscarById(nina id) {
        sql = "SELECT * FROM niña WHERE(id = '"+ id.getId()+"')";
        return con.executeQuery(sql);
    }
    
}
