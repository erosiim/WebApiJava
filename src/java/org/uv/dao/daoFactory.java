/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.dao;

/**
 *
 * @author exkapp
 */
public class daoFactory {
    
    public enum Type{NINO, NINA}
    
    public static IDAO create(Type type){
        IDAO dao = null;
        switch(type){
            case NINO:
                dao = new daoNino();
                break;
            case NINA:
                dao = new daoNina();
                break;
        }
        return dao;
    }
    
}
