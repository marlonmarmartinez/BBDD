
package procedimientosalmacenados;
import java.sql.*;
import javax.swing.JOptionPane;

public class ActualizarPro {
    
    public static void main(String[] args) {
        String nombre=JOptionPane.showInputDialog("introduce nombre");
        String seccion=JOptionPane.showInputDialog("introduce seccion");
         try {
           Connection  micon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            CallableStatement misentencia=micon.prepareCall("{call actualizapro(?,?)}");
            misentencia.setString(1, nombre);
            misentencia.setString(2, seccion);
            
            misentencia.execute();
             System.out.println("actualizacion ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
