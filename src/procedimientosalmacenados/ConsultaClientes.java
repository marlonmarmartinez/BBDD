
package procedimientosalmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class ConsultaClientes {
    
    public static void main(String[] args) {
        
        try {
           Connection  micon = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbnegro","root","");
            CallableStatement misentencia=micon.prepareCall("{call muestracliente}");
            ResultSet rs=misentencia.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
