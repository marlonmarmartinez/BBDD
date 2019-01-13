
package modelo;


public class Productos {

    public Productos() {
        codigoarti = "";
        seccion = "";
        nnombre = "";
    }

    public String getCodigoarti() {
        return codigoarti;
    }

    public void setCodigoarti(String codigoarti) {
        this.codigoarti = codigoarti;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNnombre() {
        return nnombre;
    }

    public void setNnombre(String nnombre) {
        this.nnombre = nnombre;
    }
    
    private String codigoarti;
    private String seccion;
    private String nnombre;
}
