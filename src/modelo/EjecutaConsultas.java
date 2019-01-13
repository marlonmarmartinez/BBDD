
package modelo;
import java.sql.*;

public class EjecutaConsultas {

    public EjecutaConsultas() {
        micon=new Conexion();
    }
    
    public ResultSet filtraBD(String seccion,String nombre){
       Connection conecta=micon.getConexion();
       rs=null;
       try{
        if(!seccion.equals("Todos") && nombre.equals("Todos")){
           enviaconsultaseccion=conecta.prepareStatement(consultaseccion);
           enviaconsultaseccion.setString(1, seccion);
           rs=enviaconsultaseccion.executeQuery();
            
        }else if(seccion.equals("Todos") && !nombre.equals("Todos")){
           enviaconsultanombre=conecta.prepareStatement(consultanombre);
           enviaconsultanombre.setString(1, nombre);
           rs=enviaconsultanombre.executeQuery();
        }else {
           enviaconsultatodos=conecta.prepareStatement(consultatodos);
           enviaconsultatodos.setString(1, seccion);
           enviaconsultatodos.setString(2, nombre);
           rs=enviaconsultatodos.executeQuery();
           
        }
       }catch(Exception e){
           System.out.println("error"+e.getMessage());
       }
        return rs;
    }
   private Conexion micon;
   private ResultSet rs;
   private PreparedStatement enviaconsultaseccion,enviaconsultanombre,enviaconsultatodos;
   private final String consultaseccion="SELECT codigopro,seccion,nombrepro FROM producto WHERE seccion=?";
   private final String consultanombre="SELECT codigopro,seccion,nombrepro FROM producto WHERE nombrepro=?";
   private final String consultatodos="SELECT codigopro,seccion,nombrepro FROM producto WHERE seccion=? AND nombrepro=?";
   
}

