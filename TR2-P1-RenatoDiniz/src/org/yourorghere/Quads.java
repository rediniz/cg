package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.FloatBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Renato Diniz - 1220735
 */
/**
 * SimpleJOGL2.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Quads extends GLCanvas implements GLEventListener, KeyListener {

    final float L = 1.5f;
    final float C = 1.0f;
    final float H = 0.5f;
    int teste;

    private GLU glu = new GLU();

    public Quads() {
        teste = 1;
        addKeyListener(this);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Trabalho NP2 Parte 1 - Quads");

        Quads canvas = new Quads();

        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        canvas.addGLEventListener(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        //drawable.addKeyListener(this);

    }

    public void reshape(GLAutoDrawable drawable,
            int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        if (height <= 0) // no divide by zero
        {
            height = 1;
        }
        // keep ratio
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60.0f, h, 1.0f, 10.0f);

    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);     // To operate on model-view matrix

        gl.glLoadIdentity();		// Reset The Current Modelview Matrix
        //gl.glTranslatef(0.0f, 0.0f, -9.0f);// Move Right 1.5 Units And Into The Screen 7.0
        //gl.glRotatef(1.0f, 1.0f, 1.0f, 1.0f);// Rotate The Quad On The X axis ( NEW )

        switch (teste) {

            case 1:  //Frente
                glu.gluLookAt(0, 0, 5, 0, 0, 0, 0, 1, 0);
                break;
            case 2: //Trás
                glu.gluLookAt(0, 0, -5, 0, 0, 0, 0, 1, 0);
                break;
            case 3:
                //Cima
                glu.gluLookAt(0, 5, 0, 0, 0, 0, 1, 0, 0);
                break;
            case 4:   
                //Baixo
                glu.gluLookAt(0, -5, 0, 0, 0, 0, 1, 0, 0);
                break;
            case 5:  
                //Direita
                glu.gluLookAt(5, 0, 0, 0, 0, 0, 0, 1, 0);
                break;
            case 6: 
                //Esquerda
                glu.gluLookAt(-5, 0, 0, 0, 0, 0, 0, 1, 0);
                break;
        }

        gl.glBegin(GL.GL_QUADS);
        // Draw A Quad

        // Topo 
        //Cor ciano
        gl.glColor3f(0.0f, 1.0f, 1.0f);

        gl.glVertex3f(L, C, -H);
        gl.glVertex3f(-L, C, -H);
        gl.glVertex3f(-L, C, H);
        gl.glVertex3f(L, C, H);

        //Base
        //Cor verde
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(L, -C, H);
        gl.glVertex3f(-L, -C, H);
        gl.glVertex3f(-L, -C, -H);
        gl.glVertex3f(L, -C, -H);

        //Frente
        //Cor vermelha
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(L, C, H);
        gl.glVertex3f(-L, C, H);
        gl.glVertex3f(-L, -C, H);
        gl.glVertex3f(L, -C, H);

        //Trás
        //Cor amarela
        gl.glColor3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(L, -C, -H);
        gl.glVertex3f(-L, -C, -H);
        gl.glVertex3f(-L, C, -H);
        gl.glVertex3f(L, C, -H);

        //Esquerda
        //Cor magenta
        gl.glColor3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(-L, C, H);
        gl.glVertex3f(-L, C, -H);
        gl.glVertex3f(-L, -C, -H);
        gl.glVertex3f(-L, -C, H);

        //Direita
        //Cor azul
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(L, C, -H);
        gl.glVertex3f(L, C, H);
        gl.glVertex3f(L, -C, H);
        gl.glVertex3f(L, -C, -H);

        gl.glEnd();

//        gl.glTranslatef(3.0f, 0.0f, 0.0f);
//        gl.glBegin(GL.GL_LINES);
//        gl.glColor3f(1, 0, 0); // X axis is red.
//        gl.glVertex3f(-2, 0, 0);
//        gl.glVertex3f(2, 0, 0);
//        gl.glColor3f(0, 1, 0); // Y axis is green.
//        gl.glVertex3f(0, -2, 0);
//        gl.glVertex3f(0, 2, 0);
//        gl.glColor3f(0, 0, 1); // z axis is blue.
//        gl.glVertex3f(0, 0, -2);
//        gl.glVertex3f(0, 0, 2);
//        gl.glEnd();
        gl.glFlush();

    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent e) {

  
          switch (e.getKeyCode()) {

            case KeyEvent.VK_1:  //Frente
                teste = 1;
                break;
            case KeyEvent.VK_2: //Trás
                teste = 2;
                break;
            case KeyEvent.VK_3:
                //Cima
                teste = 3;
                break;
            case KeyEvent.VK_4:   
                //Baixo
                teste = 4;
                break;
            case KeyEvent.VK_5:  
                //Direita
                teste = 5;
                break;
            case KeyEvent.VK_6: 
                //Esquerda
                teste = 6;
                break;
        }

    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
