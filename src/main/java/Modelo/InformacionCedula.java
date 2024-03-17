
package Modelo;

//Clase utilizada para almacenar la informacion que se muestra en el Frm.
public class InformacionCedula {
    private String provincia;
    private String numerosRegistro;
    private int digitoVerificador;
    
    public InformacionCedula(){}

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNumerosRegistro() {
        return numerosRegistro;
    }

    public void setNumerosRegistro(String numerosRegistro) {
        this.numerosRegistro = numerosRegistro;
    }

    public int getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(int digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public InformacionCedula(String provincia, String numerosRegistro, int digitoVerificador) {
        this.provincia = provincia;
        this.numerosRegistro = numerosRegistro;
        this.digitoVerificador = digitoVerificador;
    }
}
