/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author informatica
 */
public class FiltroNuevo {
    private String urlImage;
    public FiltroNuevo(String urlImage){
        this.urlImage = urlImage;
    }
    
    public BufferedImage getImagenNuevoFiltro(){
        try {
            //System.err.println(": " + urlImage);
            File entrada = new File(urlImage);
            BufferedImage image = ImageIO.read(entrada);           
            BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(), image.getHeight(), 
                    BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    Color c = new Color(image.getRGB(j, i));

                    int r = 255 - c.getRed();
                    int g = 255 - c.getGreen();
                    int b = 255 - c.getBlue(); 
                    
                    bufferedImage.setRGB(j, i, new Color(r, g, b).getRGB());                    

                }
            }
            return bufferedImage;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}
