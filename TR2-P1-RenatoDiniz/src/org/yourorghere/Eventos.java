/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Eventos implements KeyListener {

    GLCanvas canvas;

    public Eventos(GLCanvas canvas) {
        this.canvas = canvas;
    }

    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
				GLU glu = new GLU();
                                glu.gluLookAt(0, 0, -5, 0, 0, 0, 0, 1, 0);
                                canvas.display();
			}
    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
