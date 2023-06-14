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
public class FiltroNivelRGB {
    public BufferedImage getImagenNiveles(int sRed, int sGreen, 
            int sBlue, String urlImage) {
        try {
            File entrada = new File(urlImage);
            BufferedImage image = ImageIO.read(entrada);
            BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(), image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    Color c = new Color(image.getRGB(j, i));
                    
                    int red = getColor(c.getRed(), sRed);
                    int green = getColor(c.getGreen(), sGreen);
                    int blue = getColor(c.getBlue(), sBlue);
                   
                    bufferedImage.setRGB(j, i, new Color(red, green, blue).getRGB());        
                }
            }
            return bufferedImage;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
    
    private int getColor(int xColor, int yColor){
        xColor = xColor + xColor * yColor / 100;
        if(xColor > 255)
            return 255;
        else if(xColor < 0)
            return 0;
        else
            return xColor;
    }
}
