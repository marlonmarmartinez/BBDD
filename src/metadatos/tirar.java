
package metadatos;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class tirar {
    
    public static void main(String[] args) {
        Marco mi=new Marco();
        mi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "archivos de textos", "txt");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(mi);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getAbsolutePath());
    }
    }
}
class Marco extends JFrame{

    public Marco() {
        setBounds(300,300,300,300);
        setVisible(true);
        
    }
    
}