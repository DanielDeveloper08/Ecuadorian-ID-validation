package Modelo;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class CedulaEcuatoriana {

    // HashMap para almacenar los códigos de provincia y sus nombres
    private HashMap<String, String> provincias;
    // Instancia de InformacionCedula para almacenar datos relacionados con la cédula
    private InformacionCedula dataFrm;

    // Constructor de la clase
    public CedulaEcuatoriana() {
        // Inicialización del HashMap de provincias y la instancia de InformacionCedula
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
        dataFrm = new InformacionCedula();
    }

    // Método para validar una cédula ecuatoriana
    public boolean validarCedula(String cedula) {
        // Verificar condiciones de validez de la cédula
        if (cedula.length() != 10 || !validarProvincia(cedula) || !validarNumerosRegistro(cedula) || !validarDigitoVerificacion(cedula)) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una cédula válida", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // La cédula no es válida
        }
        return true; // La cédula es válida
    }

    // Método para validar el código de provincia de la cédula
    private boolean validarProvincia(String cedula) {
        try {
            String digitosProvincia = cedula.substring(0, 2); // Obtener los primeros dos dígitos
            if (provincias.containsKey(digitosProvincia)) { // Verificar si está en el HashMap
                String nombreProvincia = provincias.get(digitosProvincia);
                dataFrm.setProvincia(digitosProvincia + " - " + nombreProvincia); // Establecer la provincia
                return true; // El código de provincia es válido
            } else {
                JOptionPane.showMessageDialog(null, "Número de provincia inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return false; // El código de provincia no es válido
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener provincia: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Error al obtener los dígitos de provincia
        }
    }

    // Método para validar los números de registro de la cédula
    private boolean validarNumerosRegistro(String cedula) {
        try {
            String siguientesDigitos = cedula.substring(2, 8); // Obtener los siguientes 6 dígitos
            for (int i = 0; i < siguientesDigitos.length(); i++) {
                if (siguientesDigitos.charAt(i) != '0') {
                    dataFrm.setNumerosRegistro(siguientesDigitos); // Establecer los números de registro
                    return true; // Al menos un dígito es diferente de 0
                }
            }
            return false; // Todos los dígitos son 0
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error al validar números de registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Error al obtener los dígitos de registro
        }
    }

    // Método para validar el dígito verificador de la cédula
    private boolean validarDigitoVerificacion(String cedula) {
        try {
            char[] numerosCedula = cedula.substring(0, 9).toCharArray(); // Obtener los primeros 9 dígitos
            int digitoFinal = Character.getNumericValue(cedula.charAt(9)); // Obtener el dígito verificador
            dataFrm.setDigitoVerificador(digitoFinal); // Establecer el dígito verificador

            int sumaPares = 0;
            int sumaImpares = 0;

            for (int i = 1; i <= numerosCedula.length; i++) {
                char digito = numerosCedula[i - 1];
                if (Character.isDigit(digito)) {
                    int num = Character.getNumericValue(digito); //Se convierte caracter a entero.
                    if (i % 2 == 0) {//validamos si es par
                        sumaPares += num; // Sumar dígito par
                    } else {
                        int resultadoMultiplicacion = num * 2;//Numeros impares se los multiplica por 2.
                        resultadoMultiplicacion = resultadoMultiplicacion >= 10 ? resultadoMultiplicacion - 9 : resultadoMultiplicacion;// se valida si el resultado es mayor o igual a 10 , de ser asi se resta 9.
                        sumaImpares += resultadoMultiplicacion; // Sumar dígito impar multiplicado
                    }
                }
            }

            int sumaTotal = sumaPares + sumaImpares; // Suma total de pares e impares

            char primerDigito = String.valueOf(sumaTotal).charAt(0);// Obtenemos el primer digito de la suma total.
            int decena = (Character.getNumericValue(primerDigito) + 1) * 10; // Se calcula la decena superior.
            int digitoValidador = decena - sumaTotal;//restamos la decena superior y la suma total.

            if (digitoValidador == 10) { // Validamos si es 10, entonces se transforma en 0.
                digitoValidador = 0;
            }

            if (digitoFinal != digitoValidador) {
                return false; // El dígito verificador no coincide
            }
            return true; // La cédula es válida

        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al validar dígito verificador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Error al validar el dígito verificador
        }
    }

    // Método para obtener la información de la cédula validada
    public InformacionCedula mostrarDetallesCedula() {
        return dataFrm; // Retorna la información almacenada en dataFrm
    }

}
