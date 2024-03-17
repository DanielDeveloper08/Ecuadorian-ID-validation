/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Modelo;

/**
 *
 * @author Daniel
 */
public class CedulaEcuatoriana {

    public void validarCedula(String cedula){
        if(cedula.length() != 10) return;
        
        
    }
    
    public boolean validarProvincia(String cedula){
        String digitosProvincia = cedula.substring(0,2);
        
        
        return true;
    }
    
    public boolean validarNumerosRegistro (String cedula){
         //verifica que los siguientes seis dígitos no sean todos ceros.
        return true;
    }
    
    public boolean validarDigitoVerificacion (String cedula){
         //verifica que los siguientes seis dígitos no sean todos ceros.
        return true;
    }
    
    public boolean mostrarDetallesCedula (String cedula){
         //verifica que los siguientes seis dígitos no sean todos ceros.
        return true;
    }
    
}
