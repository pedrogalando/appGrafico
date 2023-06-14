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
public class FiltroEscalaGris {
    private String urlImage;
    public FiltroEscalaGris(String urlImage){
        this.urlImage = urlImage;
    }
    
    public BufferedImage getImagenEscalaGris(){
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
                    
                    int gray = (c.getRed() + c.getGreen() + c.getBlue()) / 3;

                    bufferedImage.setRGB(j, i, new Color(gray, gray, gray).getRGB());
                }
            }
            return bufferedImage;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}
