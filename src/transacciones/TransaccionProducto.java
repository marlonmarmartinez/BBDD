
package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class TransaccionProducto {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Connection miConexion=null;
		
		try{					
				
	            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");				
		    miConexion.setAutoCommit(false);
                        
		    Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="DELETE FROM producto WHERE nombrepro='pantalon'";
			    
		    String instruccionSql_2="DELETE FROM producto WHERE seccion='ropa'";
                    
                    String instruccionSql_3="UPDATE producto SET nombrepro=nombrepro";
                     
                     boolean ejecutar=ejecutarTransaccion();
                     if(ejecutar){
                        miStatement.executeUpdate(instruccionSql_1);
                        miStatement.executeUpdate(instruccionSql_2);
                        miStatement.executeUpdate(instruccionSql_3);
                        miConexion.commit();		    				    
		        System.out.println("Datos INSERTADOS correctamente");
                     }   else{
                         System.out.println("no se realizo cambios");
                     }                                  
				
		}catch(Exception e){
				
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
                    try {
                        miConexion.rollback();
                    } catch (SQLException ex) {
                       ex.printStackTrace();
                    }		
			e.printStackTrace();					
				
			}

		}

    private static boolean ejecutarTransaccion() {
       
        String ejecucion=JOptionPane.showInputDialog("ejecutamos transaccion");
        if(ejecucion.equals("si")){
            return true;
        }else {
            return false;
        }
    }
}
