package archivo;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Pixel {

    BufferedImage image;
    int width;
    int height;
    private JPanel panel;
    public int punto[]=new int[545920];

    public Pixel() {
        try {
            File input = new File("src/archivo/shakira.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            String ruta = "src/archivo/data.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            int count = 0;

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < width; j++) {

                    /*count++;*/
                    Color c = new Color(image.getRGB(j, i));
                    /*bw.write(c + ", " + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue() + "\n");
                    //System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());*/
                    punto[count++]=(255<<24)|(c.getRed()<<16)|(c.getGreen()<<8)|c.getBlue();
                }
            }
            bw.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        
    }

    static public void main(String args[]) throws Exception {
        Pixel obj = new Pixel();
    }
}
