/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacao;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author alunom35
 */
public class Primitive {

    static int sw = 500;
    static int sh = 500;
    static double xc = 0;
    static double yc = 0;
    static double xscale = 500;
    static double yscale = 500;
    static int lm = 0;
    static int tm = 0;

    static int espaco = 1;//Escala dos pontos
    static int X0 = 250;//Novo centro x zero
    static int Y0 = 250;//Novo centro y zero

    public static void drawPixel(Graphics2D g, int x, int y) {

        g.drawLine(x, y, x, y);

    }

    public static void tracaLinhaBresenham(Graphics2D g, int x1, int y1, int x2, int y2) {
        //Coordenadas originais
        int dx = Math.abs(x2 - x1);
        //Coordenadas corrigidas
        //int x = (X0 + (x1 * espaco));
        //int y = (Y0 - (y1 * espaco));
        
        int x = lm + sw/2 + (int)((x1-xc)*(sw/xscale));
        int y = sh/2-(int)((y1-yc)*(sh/yscale))+tm;
        
        //int xfi = (X0 + (x2 * espaco));
        //int yfi = (Y0 - (y2 * espaco));
        
        int xfi = lm + sw/2 + (int)((x2-xc)*(sw/xscale));
        int yfi = sh/2-(int)((y2-yc)*(sh/yscale))+tm;
        
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
            //x = x + dx;
            ei = ei + 2 * dyi;
        }
    }


}
