
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBD {
    public static void main(String[] args) {
        
        try {
            Connection micon=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            Statement miest=micon.createStatement();
            String instruccion="INSERT INTO producto(codigopro,seccion,nombrepro) VALUES ('ar11','ropa','pantalon')";
            miest.executeUpdate(instruccion);
            System.out.println("datos insertados");
        } catch (Exception e) {
            System.out.println("no hay conexion"+e.getMessage());
        }
    }
}
