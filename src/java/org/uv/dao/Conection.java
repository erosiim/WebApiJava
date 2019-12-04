package org.uv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conection {
    //Variable de instancia única
    private static Conection c;
    //Variable para hacer la conexión
    private Connection cx = null;
    private Conection() {        try {
            Class.forName("org.postgresql.Driver");
            cx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/daniel",
                    "postgres", "12334");
            System.out.println("-Conectado-");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public static Conection getInstance(){
        if(c == null)
            c = new Conection();
        return c;
    }
    
    //Statement(Sentencias SQL):  Insert, Delete, Update => De actualización
    public boolean execute(String sql){
        boolean res = false;
        try {
            Statement st = cx.createStatement();
            st.execute(sql);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return res;
    }
    //Statement(Sentencia SQL): Select => De consulta
    //ResultSet: almacena de forma temporal el resultado de la consulta Select y permite recorrer la información obtenida.
    public ResultSet executeQuery(String sql){
        ResultSet res= null;        
        try {
            Statement st = cx.createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return res;
    }
        public List executeThisQuery(String sql) throws SQLException{
        ResultSet res= null;
        Statement st = cx.createStatement();
//        List<> lst = new ArrayList();
//        res = st.executeQuery(sql);
//        while(res.next()){
//            Auto p = new Auto();
//            p.setId(res.getString(1));
//            p.setModelo(res.getString(2));
//            p.setMarca(res.getString(3));
//            p.setLlantas(res.getString(4));
//            lst.add(p);
//        }
        return null;
    }  

}

