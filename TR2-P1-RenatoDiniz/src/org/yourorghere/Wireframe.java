package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Wireframe implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Trabalho NP2 Parte 1 - Wireframe");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Wireframe());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
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
        gl.glShadeModel(GL.GL_SMOOTH);                            //Enables Smooth Color Shading
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);               //This Will Clear The Background Color To Black
        gl.glClearDepth(1.0);                                  //Enables Clearing Of The Depth Buffer
        gl.glEnable(GL.GL_DEPTH_TEST);                            //Enables Depth Testing
        gl.glDepthFunc(GL.GL_LEQUAL);                             //The Type Of Depth Test To Do
        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

    }

    public void reshape(GLAutoDrawable drawable,
            int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) // no divide by zero
        {
            height = 1;
        }
        // keep ratio
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 0.1f, 20.0f);
        glu.gluLookAt(3.5, -2.0, 4.0, -2.0, 1.0, -1.0, 1.5, 5.0, 3.0);

    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);     // To operate on model-view matrix

        gl.glLoadIdentity();		// Reset The Current Modelview Matrix
        //gl.glTranslatef(0.0f, 0.0f, -9.0f);// Move Right 1.5 Units And Into The Screen 7.0
        //gl.glRotatef(1.0f, 1.0f, 1.0f, 1.0f);// Rotate The Quad On The X axis ( NEW )

        gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_LINE);
        gl.glBegin(GL.GL_QUADS);
        // Draw A Quad

        final float L = 1.5f;
        final float C = 1.0f;
        final float H = 0.5f;

            //Topo
            gl.glColor3f(0.6f, 0.7f, 0.4f); 
            
            gl.glVertex3f(L, C, -H);
            gl.glVertex3f(-L, C, -H);
            gl.glVertex3f(-L, C, H);
            gl.glVertex3f(L, C, H);
            
            //Base			
            gl.glVertex3f(L, -C, H);
            gl.glVertex3f(-L, -C, H);
            gl.glVertex3f(-L, -C, -H);
            gl.glVertex3f(L, -C, -H);

            //Frente
            gl.glVertex3f(L, C, H);
            gl.glVertex3f(-L, C, H);
            gl.glVertex3f(-L, -C, H);
            gl.glVertex3f(L, -C, H);

            //Trás
            gl.glVertex3f(L, -C, -H);
            gl.glVertex3f(-L, -C, -H);
            gl.glVertex3f(-L, C, -H);
            gl.glVertex3f(L, C, -H);

            //Esquerda
            gl.glVertex3f(-L, C, H);
            gl.glVertex3f(-L, C, -H);
            gl.glVertex3f(-L, -C, -H);
            gl.glVertex3f(-L, -C, H);

            //Direita
            gl.glVertex3f(L, C, -H);
            gl.glVertex3f(L, C, H);
            gl.glVertex3f(L, -C, H);
            gl.glVertex3f(L, -C, -H);

        gl.glEnd();



        gl.glFlush();

    }

    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }

}
