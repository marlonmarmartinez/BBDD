
package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.CargaMenu;
import vista.MarcoAplicacion;


public class ControladorCargaMenu extends WindowAdapter{

    public ControladorCargaMenu(MarcoAplicacion marco) {
        this.marco=marco;
    }
    
    
    public void windowOpened(WindowEvent we) {
       obj.ejecutaConsulta();
        try {
            while(obj.rs.next()){
                marco.secciones.addItem(obj.rs.getString(1));
            }
            while(obj.rs2.next()){
                marco.nompro.addItem(obj.rs2.getString(1));
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }

   CargaMenu obj=new CargaMenu();
   private MarcoAplicacion marco;
    
}
