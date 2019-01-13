
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import modelo.*;
import vista.*;

public class ControladorBotonEjecuta implements ActionListener{

    public ControladorBotonEjecuta(MarcoAplicacion marco) {
        this.marco=marco;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       String seleccionseccion=(String)marco.secciones.getSelectedItem();
       String seleccionnombre=(String)marco.nompro.getSelectedItem();
       resultadoconsulta=obj.filtraBD(seleccionseccion, seleccionnombre);
       try{
           marco.resultado.setText("");
       while(resultadoconsulta.next()){
           marco.resultado.append(resultadoconsulta.getString(1));
           marco.resultado.append(", ");
           marco.resultado.append(resultadoconsulta.getString(2));
           marco.resultado.append(", ");
           marco.resultado.append(resultadoconsulta.getString(3));
           marco.resultado.append("\n");
       }
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    private MarcoAplicacion marco;
   private ResultSet resultadoconsulta;
EjecutaConsultas obj=new EjecutaConsultas();
}
