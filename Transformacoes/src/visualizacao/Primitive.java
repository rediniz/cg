/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacao;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import objetos.Poligono;
import objetos.Ponto;
import objetos.Reta;

/**
 *
 * @author alunom35
 */
public class Primitive {

    static int sw = 500;
    static int sh = 500;
    static double xc = 0;
    static double yc = 0;
    static double xscale = 1000;
    static double yscale = 1000;
    static int lm = 0;
    static int tm = 0;

    static int espaco = 1;//Escala dos pontos
    static int X0 = 250;//Novo centro x zero
    static int Y0 = 250;//Novo centro y zero

    public static void drawPixel(Graphics2D g, int x, int y) {

        g.drawLine(x, y, x, y);

    }
     public static void drawPixelOnly(Graphics2D g, int x, int y) {
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.red);
        
        x = lm + sw / 2 + (int) ((x - xc) * (sw / xscale));
        y = sh / 2 - (int) ((y - yc) * (sh / yscale)) + tm;
        g.drawLine(x, y, x, y);
        
        g.setStroke(new BasicStroke());
        g.setColor(Color.black);

    }

    public static void tracaLinhaBresenham(Graphics2D g, int x1, int y1, int x2, int y2) {

        //Coordenadas corrigidas     
        int x = lm + sw / 2 + (int) ((x1 - xc) * (sw / xscale));
        int y = sh / 2 - (int) ((y1 - yc) * (sh / yscale)) + tm;

        int xfi = lm + sw / 2 + (int) ((x2 - xc) * (sw / xscale));
        int yfi = sh / 2 - (int) ((y2 - yc) * (sh / yscale)) + tm;

        int dxi = Math.abs(xfi - x);
        int dyi = Math.abs(yfi - y);
        int si1 = 1;
        int si2 = 1;

        boolean trocai = false;

        if ((xfi - x) < 0) {
            si1 = -1;
        }
        if ((yfi - y) < 0) {
            si2 = -1;
        }

        if (dyi > dxi) {
            int temp = dxi;
            dxi = dyi;
            dyi = temp;
            trocai = true;
        }

        int ei = 2 * dyi - dxi;

        for (int i = 0; i <= dxi; i++) {
            drawPixel(g, x, y);

            while (ei >= 0) {
                if (trocai) {
                    x = x + si1;
                } else {
                    y = y + si2;
                }
                ei = ei - 2 * dxi;
            }
            if (trocai) {
                y = y + si2;
            } else {
                x = x + si1;
            }
            ei = ei + 2 * dyi;
        }
    }

    static void desenharReta(Graphics2D g, Reta r) {

        Primitive.tracaLinhaBresenham(g, r.getP1().getX(), r.getP1().getY(), r.getP2().getX(), r.getP2().getY());

    }

    static void desenharPoligono(Graphics2D g, Poligono p) {
        ArrayList<Ponto> pontos = p.getPontos();
        Ponto anterior = null;
        Ponto primeiro = null;

        for (Ponto ponto : pontos) {
            if (anterior == null) {
                primeiro = ponto;
            } else {
                Primitive.tracaLinhaBresenham(g, anterior.getX(), anterior.getY(), ponto.getX(), ponto.getY());
            }
            anterior = ponto;
        }

        Primitive.tracaLinhaBresenham(g, anterior.getX(), anterior.getY(), primeiro.getX(), primeiro.getY());

    }
}
