package archivo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

public class MiPanel extends javax.swing.JPanel{
    Image img;
    public MiPanel() {
        initComponents();
        this.setBounds(0, 700, 0, 800);
        this.setBackground(Color.GREEN);
       
        this.setFocusable(true);
        this.setLayout(null);
        Pixel obj = new Pixel();
        img=createImage(new MemoryImageSource(300,300,obj.punto,0,300));
         //System.err.println("dibujando");
        //this.setVisible(true);
        //repaint();
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
        super.paintComponent(g);
        System.out.println("dibujando");
        g.drawImage(img,0,0,this);
        //super.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
