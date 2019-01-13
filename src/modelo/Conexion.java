
package modelo;

import controlador.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
private Connection micon=null;
    public Conexion() {
        
    }
    public Connection getConexion(){
        try {
            micon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
        } catch (SQLException ex) {
            System.out.println("error de conexion");
        }
        return micon;
    }
}
