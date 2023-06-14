package appgrafico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class MiPanel extends javax.swing.JPanel implements Runnable, KeyListener, MouseMotionListener, MouseListener {

    private int x = 100;
    private int y = 20;

    private int a = 100;
    private int b = 20;
    private int c = 0;

    private int angulo = 0;

    private int posX = 100;
    private int posY = 0;

    private boolean siX = true;
    private boolean siY = true;

    private int contador = 0;

    private int arrayX[] = new int[10];
    private int arrayY[] = new int[10];
    
    private boolean arraySiX1[] = new boolean[10];
    private boolean arraySiY1[] = new boolean[10];
    
    private ImageIcon fondo;

    public MiPanel() {
        initComponents();
        this.setBounds(50, 50, 400, 400);
        this.setBackground(Color.GREEN);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        this.addKeyListener(this);
        //requestFocus();
        this.setFocusable(true);
//this.requestFocusInWindow();
        this.setLayout(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        Dimension tamanio = this.getSize();
        fondo = new ImageIcon(getClass().getResource("../img/fondo.png"));
        g.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paint(g);
        
        
        
        
        //Para poder modificar más propiedades con Graphics 2d
        Graphics2D g2d = (Graphics2D) g;

        //Óvalo (con relleno y borde)
        if (contador > 0) {
            g2d.setColor(Color.BLACK);
            g2d.fillOval(arrayX[contador-1], arrayY[contador-1], 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(arrayX[contador-1], arrayY[contador-1], 10, 10);
        }
        //Imagen
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage("src/img/img3.png");
        g2d.rotate(angulo * Math.PI / 180.0, x, y);
        g2d.drawImage(imagen, x, y, this);

        Thread h = new Thread(this);
        h.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(MiPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();

    }

    /*public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillOval(posX, posY, 10, 10);
        g.setColor(Color.yellow);
        g.drawOval(posX, posY, 10, 10);
        repaint();
    }*/
    @Override
    public void run() {
        for (int i = 0; i < contador; i++) {
            int posX1 = arrayX[i];
            int posY1 = arrayY[i];
            
            boolean siX1 = arraySiX1[i];
            boolean siY1 = arraySiY1[i];
            if (posX1 + 10 == this.getWidth()) {
                siX1 = false;
            }

            if (posX1 == 0) {
                siX1 = true;
            }

            if (posY1 + 10 == this.getHeight()) {
                siY1 = false;
            }

            if (posY1 == 0) {
                siY1 = true;
            }

            if (siX1) {
                posX1++;
            } else {
                posX1--;
            }

            if (siY1) {
                posY1++;
            } else {
                posY1--;
            }
        }

        y++;

        //repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        System.out.println("appgrafico.MiPanel.keyPressed()");

        if (code == ke.VK_DOWN) {
            System.out.println("down pressed");
            y += 10;
            repaint();
        }

        if (code == ke.VK_UP) {
            if (angulo == 360) {
                angulo = 0;
            }
            //System.out.println("down arriba.....");
            //y += 10;
            angulo += 90;
            //repaint();
        }

        System.err.println("code: " + code);
        if (code == ke.VK_CONTROL) {
            System.err.println("-");
        } else if (code == ke.VK_RIGHT) {
            x += 5;
            repaint();
        } else if (code == ke.VK_LEFT) {
            x -= 5;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("appgrafico.MiPanel.mouseDragged()");
        if ((e.getX() >= 0 && e.getY() >= 0) && (e.getX() <= this.getWidth() - 60)
                && (e.getY() <= this.getHeight() - 110)) {
            x = e.getX();
            y = e.getY();
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //System.out.println("moved");
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        /* posX = me.getX();
        posY = me.getY();*/

        arrayX[contador] = me.getX();
        arrayY[contador] = me.getY();
        System.out.println("click1: " + arrayX[contador] + "  -  " + arrayY[contador]);
        contador++;
        //repaint();
         
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //System.out.println("click2");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //System.out.println("click3");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //System.out.println("click4");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //System.out.println("click5");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
