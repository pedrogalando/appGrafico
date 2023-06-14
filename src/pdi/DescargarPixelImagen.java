/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.imageio.ImageIO;

/**
 *
 * @author informatica
 */
public class DescargarPixelImagen {
    public void getPixel(BufferedImage image, String nombreArchivoSalida) {
        try {
            String ruta = "src/pdi/"+nombreArchivoSalida;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < image.getHeight(); i++) {                
                for (int j = 0; j < image.getWidth(); j++) {
                    Color c = new Color(image.getRGB(j, i));
                    bw.write("("+ c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + "), ");
                    //punto[count++] = (255 << 24) | (c.getRed() << 16) | (c.getGreen() << 8) | c.getBlue();
                }
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
