/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author carlos david
 */
public class clsLogin {
    public boolean validarLogin(Models.ClsLogin obclsLogin){
        try{
            return obclsLogin.getStEmail().equals("charlieflow69@gmail.com") &&
                    obclsLogin.getStPassword().equals("c2r1021b3");
                    
        
        }catch(Exception ex ){
            throw ex; 
        }
        
    }
}
