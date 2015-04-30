package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Canvas extends GLCanvas implements GLEventListener, KeyListener {

    //Declaração de constantes
    //Largura, altura e profundidade
    final float L = 1.5f;
    final float C = 1.0f;
    final float H = 0.5f;

    //Teclas
    final int FRENTE = 1;
    final int TRAS = 2;
    final int CIMA = 3;
    final int BAIXO = 4;
    final int ESQUERDA = 5;
    final int DIREITA = 6;
    //Setas
    final int SETA_DIREITA = 1;
    final int SETA_ESQUERDA = 2;
    final int SETA_CIMA = 3;
    final int SETA_BAIXO = 4;
    final int ABRE_COLCHETE = 5;
    final int FECHA_COLCHETE = 6;

    //Declaração de variaveis
    int face;
    int seta;

    //EYE
    double eyeX = 0, eyeY = 0, eyeZ = 0;
    //COI
    double centerX = (-L + L) / 2, centerY = (-C + C) / 2, centerZ = (-H + H) / 2;
    //UP
    double upX = 0, upY = 1, upZ = 0;

    //Distância D do EYE
    double d = 5;
    //Quantidade de pontos movidos pelas setas
    double pontos = 1;

    boolean trocaFace = false;
    boolean mover = false;

    private GLU glu = new GLU();

    public Canvas() {
        //Inicia com a câmera apontada para a face frontal
        face = FRENTE;
        eyeZ = d;
        seta = 0;
        //Adiciona o evento de captura de teclado
        addKeyListener(this);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Trabalho NP2 Parte 1 - Quads");
        Canvas canvas = new Canvas();
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
        glu.gluPerspective(60.0f, h, 1.0f, 50.0f);

    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);     // To operate on model-view matrix
        gl.glLoadIdentity();		// Reset The Current Modelview Matrix

        if (trocaFace) {
            switch (face) {

                case FRENTE:  //Frente
                    eyeX = 0;
                    eyeY = 0;
                    eyeZ = d;
                    upX = 0;
                    upY = 1;
                    upZ = 0;
                    centerX = (-L + L) / 2;
                    centerY = (-C + C) / 2;
                    centerZ = (-H + H) / 2;
                    break;
                case TRAS: //Trás
                    eyeX = 0;
                    eyeY = 0;
                    eyeZ = -d;
                    upX = 0;
                    upY = 1;
                    upZ = 0;
                    centerX = (-L + L) / 2;
                    centerY = (-C + C) / 2;
                    centerZ = (-H + H) / 2;
                    break;
                case CIMA:
                    //Cima
                    eyeX = 0;
                    eyeY = d;
                    eyeZ = 0;
                    upX = 1;
                    upY = 0;
                    upZ = 0;
                    centerX = (-L + L) / 2;
                    centerY = (-C + C) / 2;
                    centerZ = (-H + H) / 2;
                    break;
                case BAIXO:
                    //Baixo
                    eyeX = 0;
                    eyeY = -d;
                    eyeZ = 0;
                    upX = 1;
                    upY = 0;
                    upZ = 0;
                    centerX = (-L + L) / 2;
                    centerY = (-C + C) / 2;
                    centerZ = (-H + H) / 2;
                    break;
                case DIREITA:
                    //Direita
                    eyeX = d;
                    eyeY = 0;
                    eyeZ = 0;
                    upX = 0;
                    upY = 1;
                    upZ = 0;
                    centerX = (-L + L) / 2;
                    centerY = (-C + C) / 2;
                    centerZ = (-H + H) / 2;
                    break;
                case ESQUERDA:
                    //Esquerda
                    eyeX = -d;
                    eyeY = 0;
                    eyeZ = 0;
                    upX = 0;
                    upY = 1;
                    upZ = 0;
                    centerX = (-L + L) / 2;
                    centerY = (-C + C) / 2;
                    centerZ = (-H + H) / 2;
                    break;
            }
            trocaFace = false;
        }
        if (mover) {
            switch (seta) {

                case SETA_DIREITA:  //Frente
                    eyeX += pontos;
                    centerX += pontos;
                    break;
                case SETA_ESQUERDA: //Trás
                    eyeX -= pontos;
                    centerX -= pontos;
                    break;
                case SETA_CIMA:
                    //Cima
                    eyeY += pontos;
                    centerY += pontos;
                    break;
                case SETA_BAIXO:
                    //Baixo
                    eyeY -= pontos;
                    centerY -= pontos;
                    break;
                case ABRE_COLCHETE:
                    //Direita
                    eyeZ += pontos;
                    centerZ += pontos;
                    break;
                case FECHA_COLCHETE:
                    //Esquerda
                    eyeZ -= pontos;
                    centerZ -= pontos;
                    break;
            }
            mover = false;
        }
        glu.gluLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        System.out.println(eyeX + "," + eyeY + "," + eyeZ + "," + centerX + "," + centerY + "," + centerZ + "," + upX + "," + upY + "," + upZ);

        gl.glBegin(GL.GL_QUADS);
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
                face = FRENTE;
                trocaFace = true;
                break;
            case KeyEvent.VK_2: //Trás
                face = TRAS;
                trocaFace = true;
                break;
            case KeyEvent.VK_3:
                //Cima
                face = CIMA;
                trocaFace = true;
                break;
            case KeyEvent.VK_4:
                //Baixo
                face = BAIXO;
                trocaFace = true;
                break;
            case KeyEvent.VK_5:
                //Direita
                face = DIREITA;
                trocaFace = true;
                break;
            case KeyEvent.VK_6:
                //Esquerda
                face = ESQUERDA;
                trocaFace = true;
                break;
            case KeyEvent.VK_RIGHT:
                //Direita
                seta = SETA_DIREITA;
                mover = true;
                break;
            case KeyEvent.VK_LEFT:
                //Esquerda
                seta = SETA_ESQUERDA;
                mover = true;
                break;
            case KeyEvent.VK_UP:
                //Cima
                seta = SETA_CIMA;
                mover = true;
                break;
            case KeyEvent.VK_DOWN:
                //Baixo
                seta = SETA_BAIXO;
                mover = true;
                break;
            case KeyEvent.VK_OPEN_BRACKET:
                //Abre Colchete
                seta = ABRE_COLCHETE;
                mover = true;
                break;
            case KeyEvent.VK_CLOSE_BRACKET:
                //Fecha Colchete
                seta = FECHA_COLCHETE;
                mover = true;
                break;
        }

    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
