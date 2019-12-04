/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author exkapp
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    
    private IDAO daoNiNo = daoFactory.create(daoFactory.Type.NINO);
    private IDAO daoNiNa = daoFactory.create(daoFactory.Type.NINO);
    
    private Nino nino = new Nino();
    private nina nina = new nina();
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    

    /**
     * Retrieves representation of an instance of org.uv.dao.GenericResource
     * @return an instance of java.lang.String
     */
    @Path("catalogos/ninos")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Nino> readAll() throws SQLException {
        ResultSet res = daoNiNo.buscarTodos();
        List <Nino> ninos = new ArrayList();
        
        while(res.next()){
            nino.setId(res.getString(1));
            nino.setNombre(res.getString(2));
            nino.setApellido(res.getString(3));
            nino.setEdad(res.getString(4));
            nino.setTelefono(res.getString(5));
            ninos.add(nino);
        }
        System.out.println("Holi");
        return ninos;
    }
    
    @GET
    @Path("catalogos/ninos/{idNino}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Nino> readOne(@PathParam("idNino") String idNino) throws SQLException {
        nino.setId(idNino);
        
        ResultSet res = daoNiNo.buscarById(nino);
        
        List <Nino> ninos = new ArrayList();
        
        while(res.next()){
            nino.setId(res.getString(1));
            nino.setNombre(res.getString(2));
            nino.setApellido(res.getString(3));
            nino.setEdad(res.getString(4));
            nino.setTelefono(res.getString(5));
            ninos.add(nino);
        }
        System.out.println("Holi");
        return ninos;
    }
    
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @Path("catalogos/ninos")
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String insertNino(Nino n) {
        if (daoNiNo.insertar(n)){
            return "OK";
        }
        return "OK";
    }
    
    
    
    /*---------------ABAJO ESTÁN LOS MÉTODOS DE NINAS-------*/
    
    
    @Path("catalogos/ninas")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<nina> readAllNina() throws SQLException {
        ResultSet res = daoNiNa.buscarTodos();
        List <nina> ninas = new ArrayList();
        
        while(res.next()){
            nina.setId(res.getString(1));
            nina.setNombre(res.getString(2));
            nina.setApellido(res.getString(3));
            nina.setEdad(res.getString(4));
            nina.setTelefono(res.getString(5));
            ninas.add(nina);
        }
        System.out.println("Holi ninas");
        return ninas;
    }
    
    @GET
    @Path("catalogos/ninas/{idNina}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<nina> readOneNina(@PathParam("idNina") String idNina) throws SQLException {
        nina.setId(idNina);
        
        ResultSet res = daoNiNa.buscarById(nina);
        
        List <nina> ninas = new ArrayList();
        
        while(res.next()){
            nina.setId(res.getString(1));
            nina.setNombre(res.getString(2));
            nina.setApellido(res.getString(3));
            nina.setEdad(res.getString(4));
            nina.setTelefono(res.getString(5));
            ninas.add(nina);
        }
        System.out.println("Holi");
        return ninas;
    }
    
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @Path("ninas")
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String insertNina(nina n) {
        if (daoNiNa.insertar(n)){
            return "OK";
        }
        return "OK";
    }
    
}
