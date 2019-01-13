
package metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InfoMetaDatos {
    
    public static void main(String[] args) {
        //mostrarInfoBD();
        mostrarInfoTabla();
    }
    static void mostrarInfoBD(){
        Connection micon=null;
        
        try {
            micon=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            DatabaseMetaData datos=micon.getMetaData();
            System.out.println("gestor de bbdd "+datos.getDatabaseProductName());
            System.out.println("version del gestor "+datos.getDatabaseProductVersion());
            System.out.println("nombre del driver "+datos.getDriverName());
            System.out.println("la version del driver "+datos.getDriverVersion());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                micon.close();
            } catch (SQLException ex) {
                System.out.println("error");
            }
        }
    }
    static void mostrarInfoTabla(){
         Connection micon=null;
         ResultSet rs=null;
        
        try {
            micon=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            DatabaseMetaData datos=micon.getMetaData();
            System.out.println("lista de tabla");
            rs=datos.getTables(null, null, null, null);
            while(rs.next()){
                System.out.println(rs.getString("TABLE_NAME"));
            }
            System.out.println("");
            System.out.println("campos de productos");
            rs=datos.getColumns(null, null, "producto", null);
            while(rs.next()){
                System.out.println(rs.getString("COLUMN_NAME"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                micon.close();
            } catch (SQLException ex) {
                System.out.println("error");
            }
        }
    }
}
