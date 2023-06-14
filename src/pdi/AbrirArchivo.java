/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdi;

import java.awt.HeadlessException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author informatica
 */
public class AbrirArchivo {
    public String getURLImage() {
        try {
            FileNameExtensionFilter filtro = 
                    new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
            JFileChooser file = new JFileChooser();
            file.setFileFilter(filtro);
            int resultado = file.showOpenDialog(null);

            if (JFileChooser.APPROVE_OPTION == resultado) {
                return file.getSelectedFile().getPath();
            }
        }catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex + ""
                        + "\nNo se ha encontrado el archivo",
                        "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
           }
           return "";
    }
}
