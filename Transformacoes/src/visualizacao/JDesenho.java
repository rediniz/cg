
package visualizacao;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class JDesenho extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;       
        this.setOpaque(true);
        this.setBackground(Color.gray);
        
        g2.setColor(Color.LIGHT_GRAY);
        
        g2.drawLine(250, 0, 250, 500);
        g2.drawLine(0, 250, 500, 250);
          
        g2.setStroke(new BasicStroke(2));
        g2.setFont(new Font("Arial Bold", Font.PLAIN, 20));
        
        //Traça Reta 1
        g2.setColor(Color.red);
        //Primitive.drawLineBresenham(g2, 0, 0, 125, 125);  
        Primitive.tracaLinhaBresenham(g2, 8, 8, 125, 125);        
        
        //Traça Reta 2
        g2.setColor(Color.green);
        //Primitive.drawLineBresenham(g2, 0, 0, 125, -125);
        Primitive.tracaLinhaBresenham(g2, 8, -8, 125, -125);  
       
        //Traça Reta 3
        g2.setColor(Color.blue);        
        //Primitive.drawLineBresenham(g2, 0,0, -125, 125);
        Primitive.tracaLinhaBresenham(g2, -8, 8, -125, 125);  
      
        //Traça Reta 4
        g2.setColor(Color.yellow);
        //Primitive.drawLineBresenham(g2, 0, 0, -125, -125);
        Primitive.tracaLinhaBresenham(g2, -8, -8, -125, -125);  
   
    }  
}
