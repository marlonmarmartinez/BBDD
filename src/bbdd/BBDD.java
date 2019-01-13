
package bbdd;
import java.sql.*;
import java.util.concurrent.locks.StampedLock;

public class BBDD {

    public static void main(String[] args) {
        
        try {
            Connection micon=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdcol","root","");
            Statement miest=micon.createStatement();
            ResultSet mires=miest.executeQuery("SELECT * FROM cds");
            while(mires.next()){
                System.out.println(mires.getString("titel"));
            }
        } catch (Exception e) {
            System.out.println("no hay conexion"+e.getMessage());
        }
    }
    
}
