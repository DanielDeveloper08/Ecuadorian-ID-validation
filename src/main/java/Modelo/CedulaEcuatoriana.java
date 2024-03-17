/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Modelo;

import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class CedulaEcuatoriana {
    private HashMap<String, String> provincias;

    public CedulaEcuatoriana() {
        provincias = new HashMap<>();
        provincias.put("01", "Azuay");
        provincias.put("02", "Bolivar");
        provincias.put("03", "Cañar");
        provincias.put("04", "Carchi");
        provincias.put("05", "Cotopaxi");
        provincias.put("06", "Chimborazo");
        provincias.put("07", "El Oro");
        provincias.put("08", "Esmeraldas");
        provincias.put("09", "Guayas");
        provincias.put("10", "Imbabura");
        provincias.put("11", "Loja");
        provincias.put("12", "Los Rios");
        provincias.put("13", "Manabi");
        provincias.put("14", "Morona Santiago");
        provincias.put("15", "Napo");
        provincias.put("16", "Pastaza");
        provincias.put("17", "Pichincha");
        provincias.put("18", "Tungurahua");
        provincias.put("19", "Zamora Chinchipe");
        provincias.put("20", "Galapagos");
        provincias.put("21", "Sucumbios");
        provincias.put("22", "Orellana");
        provincias.put("23", "Santo Domingo de los Tsachilas");
        provincias.put("24", "Santa Elena");
        provincias.put("30", "Ecuatorianos residentes en el exterior");
    }

    public void validarCedula(String cedula){
        if(cedula.length() != 10) return;
        
        
    }
    
    public boolean validarProvincia(String cedula){
        // Obtener los primeros dos dígitos de la cédula
        String digitosProvincia = cedula.substring(0, 2);

        // Verificar si el número de provincia está en el mapa
        if (provincias.containsKey(digitosProvincia)) {
            String nombreProvincia = provincias.get(digitosProvincia);
            System.out.println("La cédula pertenece a la provincia de " + nombreProvincia);
            return true;
        } else {
            System.out.println("Número de provincia inválido");
            return false;
        }
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
