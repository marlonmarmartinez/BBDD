
package modelo;

import java.sql.*;

public class CargaMenu {

    public CargaMenu() {
        miconex=new Conexion();
        
    }
    
    public String ejecutaConsulta(){
        Productos mipro=null;
        Connection accesodb=miconex.getConexion();
        try {
             Statement secciones=accesodb.createStatement();
             Statement nombre=accesodb.createStatement();
               rs=secciones.executeQuery("SELECT DISTINCTROW seccion FROM producto");
               rs2=nombre.executeQuery("SELECT DISTINCTROW nombrepro FROM producto");
               mipro=new Productos();
               mipro.setSeccion(rs.getString(1));
               mipro.setNnombre(rs2.getString(1));
               
               rs.close();
               rs2.close();
               accesodb.close();
        } catch (Exception e) {
              System.out.println("error"+e.getMessage());
              e.printStackTrace();
        }
        return  mipro.getSeccion();
    }
    public ResultSet rs;
     public ResultSet rs2;
   public  Conexion miconex;
}
