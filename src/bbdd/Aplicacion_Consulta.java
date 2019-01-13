package bbdd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;




public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		nompro=new JComboBox();
		
		nompro.setEditable(false);
		
		nompro.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(nompro);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
                
                botonConsulta.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent ae) {
                       ejecutaConsulta();
                    }
                });
		
		add(botonConsulta, BorderLayout.SOUTH);
                
		
            try {
                micon = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
                Statement st=micon.createStatement();
                String consulta="SELECT DISTINCTROW seccion FROM producto";
                ResultSet rs=st.executeQuery(consulta);
                while(rs.next()){
                    secciones.addItem(rs.getString(1));
                }
                rs.close();
                System.out.println("");
                consulta="SELECT DISTINCTROW nombrepro FROM producto";
                rs=st.executeQuery(consulta);
                while(rs.next()){
                    nompro.addItem(rs.getString(1));
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("error de conexion");
            }
           
		
	}	
	private void ejecutaConsulta(){
            ResultSet rs=null;
            try {
                resultado.setText("");
                String seccion=(String) secciones.getSelectedItem();
                String nombre=(String)nompro.getSelectedItem();
                if(!seccion.equals("Todos") && nombre.equals("Todos")){
                enviaconsultaseccion=micon.prepareStatement(consultaseccion);
                enviaconsultaseccion.setString(1, seccion);
                rs=enviaconsultaseccion.executeQuery();
                }else if(seccion.equals("Todos") && !nombre.equals("Todos")){
                     enviaconsultanom=micon.prepareStatement(consultanombre);
                     enviaconsultanom.setString(1, nombre);
                     rs=enviaconsultanom.executeQuery();
                }else if(!seccion.equals("Todos") && !nombre.equals("Todos")){
                    enviaconsultatodos=micon.prepareStatement(consultatodos);
                     enviaconsultatodos.setString(1, seccion);
                      enviaconsultatodos.setString(2, nombre);
                     rs=enviaconsultatodos.executeQuery();
                }
                while(rs.next()){
                    resultado.append(rs.getString(1));
                    resultado.append(" ,");
                    resultado.append(rs.getString(2));
                    resultado.append(" ,");
                    resultado.append(rs.getString(3));
                    resultado.append("\n");
                 }
            } catch (Exception e) {
                System.out.println("error"+e.getMessage());
            }
            
        }	

	private PreparedStatement enviaconsultaseccion,enviaconsultanom,enviaconsultatodos;
        private final String consultaseccion="SELECT codigopro,seccion,nombrepro FROM producto WHERE seccion=?";
        private final String consultanombre="SELECT codigopro,seccion,nombrepro FROM producto WHERE nombrepro=?";
	private final String consultatodos="SELECT codigopro,seccion,nombrepro FROM producto WHERE seccion=? AND nombrepro=?" ;
        private JComboBox secciones;
	
	private JComboBox nompro;
	
	private JTextArea resultado;	
	private Connection  micon ;

	
}



