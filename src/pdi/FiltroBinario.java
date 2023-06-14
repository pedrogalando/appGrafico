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
public class FiltroBinario {
    private String urlImage;
    public FiltroBinario(String urlImage){
        this.urlImage = urlImage;
    }
    
    public BufferedImage getImagenBinariorio(){
        try {
            //System.err.println(": " + urlImage);
            File entrada = new File(urlImage);
            BufferedImage image = ImageIO.read(entrada);           
            BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(), image.getHeight(), 
                    BufferedImage.TYPE_BYTE_BINARY);
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    Color c = new Color(image.getRGB(j, i));

                    int r = (c.getRed() > 127) ? 255 : 0;
                    int g = (c.getGreen() > 127) ? 255 : 0;
                    int b = (c.getBlue() > 127) ? 255 : 0; 
                    
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
