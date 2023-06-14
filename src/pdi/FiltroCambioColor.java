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
public class FiltroCambioColor {
    private String urlImage;
    public FiltroCambioColor(String urlImage){
        this.urlImage = urlImage;
    }
    
    public BufferedImage getImagenCambioColor(){
        try {
            //System.err.println(": " + urlImage);
            File entrada = new File(urlImage);
            BufferedImage image = ImageIO.read(entrada);           
            BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(), image.getHeight(), 
                    BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    
                    int c = image.getRGB(j, i);
                    
                    bufferedImage.setRGB(j, i, c - 150);
                }
            }
            //System.out.println("pdi.FiltroCambioColor.getImagenCambioColor()");
            return bufferedImage;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}
