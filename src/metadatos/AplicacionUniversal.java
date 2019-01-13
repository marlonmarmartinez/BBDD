package metadatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AplicacionUniversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoBBDD mimarco = new MarcoBBDD();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class MarcoBBDD extends JFrame {

    public MarcoBBDD() {

        setBounds(300, 300, 700, 700);

        LaminaBBDD milamina = new LaminaBBDD();

        add(milamina);

    }

}

class LaminaBBDD extends JPanel {

    public LaminaBBDD() {

        setLayout(new BorderLayout());

        comboTablas = new JComboBox();

        areaInformacion = new JTextArea();

        add(areaInformacion, BorderLayout.CENTER);
        conectarBD();
        obtenerTablas();

        comboTablas.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                String nomtabla = (String) comboTablas.getSelectedItem();
                mostrarInfoTabla(nomtabla);
            }
        });

        add(comboTablas, BorderLayout.NORTH);

    }

    public void conectarBD() {
        conexion = null;
        String[] datos = new String[3];

        try {
            entrada = new FileReader("C://Users//Lnv//Desktop/conexion.txt");
        } catch (IOException e) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "archivos de textos", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }

        try {
            BufferedReader mibu = new BufferedReader(entrada);
            for (int i = 0; i < 2; i++) {
                datos[i] = mibu.readLine();

            }
            conexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
            entrada.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void obtenerTablas() {
        ResultSet rs = null;
        try {
            DatabaseMetaData datos = conexion.getMetaData();
            rs = datos.getTables(null, null, null, null);
            while (rs.next()) {
                comboTablas.addItem(rs.getString("TABLE_NAME"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarInfoTabla(String tabla) {
        ArrayList<String> campos = new ArrayList<>();
        String consulta = "SELECT * FROM " + tabla;
        try {
            areaInformacion.setText("");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsbd = rs.getMetaData();
            for (int i = 0; i < rsbd.getColumnCount(); i++) {
                campos.add(rsbd.getColumnLabel(i));

            }
            while (rs.next()) {
                for (String campo : campos) {
                    areaInformacion.append(rs.getString(campo) + " ");
                }
                areaInformacion.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JComboBox comboTablas;
    private FileReader entrada;
    private JTextArea areaInformacion;
    private Connection conexion;

}
