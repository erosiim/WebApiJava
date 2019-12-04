package org.uv.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author exkapp
 */
public interface IDAO<T> {
    public boolean insertar(T t);
    public boolean modificar(T t);
    public boolean eliminar(T id);
    public ResultSet buscarById(T id);
    public ResultSet buscarTodos();
    
}
