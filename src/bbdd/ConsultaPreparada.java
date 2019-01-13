
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaPreparada {
    
    public static void main(String[] args) {
         
        try {
           Connection  micon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
           PreparedStatement misentencia=micon.prepareStatement("SELECT codigopro,seccion,nombrepro FROM producto WHERE seccion=? AND nombrepro=?");
           misentencia.setString(1, "ropa");
           misentencia.setString(2, "pantalon");
           ResultSet mires=misentencia.executeQuery();
           while(mires.next()){
               System.out.println(mires.getString(1)+" "+mires.getString(2)+" "+mires.getString(3));
           }
           mires.close();
            System.out.println("");
            System.out.println("ejecucion segunda consulta");
            System.out.println("");
            misentencia.setString(1, "deportes");
           misentencia.setString(2, "raqueta");
           mires=misentencia.executeQuery();
           while(mires.next()){
               System.out.println(mires.getString(1)+" "+mires.getString(2)+" "+mires.getString(3));
           }
           mires.close();
        } catch (SQLException ex) {
            System.out.println("error de conexion");
        }
           
    }
}
