/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacoes;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import objetos.Poligono;
import objetos.Ponto;
import objetos.Reta;
import visualizacao.Primitive;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Transformacoes {
    
 

    int espaco = 1;//Escala dos pontos
    int X0 = 250;//Novo centro x zero
    int Y0 = 250;//Novo centro y zero
    int w = 1;

    public static void drawPixel(Graphics2D g, int x, int y) {

        g.drawLine(x, y, x, y);

    }

    public double[][] multiplicarMatrizes(double a[][], double b[][]) {
        int aNColunas = a[0].length; // número de colunas de a
        int bNLinhas = b.length;    // número de linhas de b

        if (aNColunas != bNLinhas) {
            return null; // multiplicação não é possível
        }

        int cNLinhas = a.length;    // número de linhas de c (matriz resultante)
        int cNColunas = b[0].length; // número de colunas de c

        double[][] c = new double[cNLinhas][cNColunas]; // matriz resultante

        for (int i = 0; i < cNLinhas; i++) {         // linhas de a
            for (int j = 0; j < cNColunas; j++) {     // colunas de b
                for (int k = 0; k < aNColunas; k++) { // colunas de a
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public Reta transladarReta(Reta r, double dx, double dy) {

        double[][] translacao = new double[3][3];
        translacao[0][0] = 1;
        translacao[0][1] = 0;
        translacao[0][2] = dx;
        translacao[1][0] = 0;
        translacao[1][1] = 1;
        translacao[1][2] = dy;
        translacao[2][0] = 0;
        translacao[2][1] = 0;
        translacao[2][2] = 1;

        String result = "";
        for (int i = 0; i < translacao[0].length; i++) {
            for (int j = 0; j < translacao[i].length; j++) {
                result += String.format("%11.2f", translacao[i][j]);
            }
            result += "\n";
        }
        System.out.println(result);

        int x1 = ((Reta) r).getP1().getX();
        int y1 = ((Reta) r).getP1().getY();
        int x2 = ((Reta) r).getP2().getX();
        int y2 = ((Reta) r).getP2().getY();

        double[][] p1 = new double[3][1];
        double[][] p2 = new double[3][1];

        p1[0][0] = x1;
        p1[1][0] = y1;
        p1[2][0] = w;

        p2[0][0] = x2;
        p2[1][0] = y2;
        p2[2][0] = w;

        double[][] p1Linha = multiplicarMatrizes(translacao, p1);
        double[][] p2Linha = multiplicarMatrizes(translacao, p2);

        ((Reta) r).setP1(new Ponto((int) (p1Linha[0][0]), (int) p1Linha[1][0]));
        ((Reta) r).setP2(new Ponto((int) (p2Linha[0][0]), (int) p2Linha[1][0]));

        System.out.println((Reta) r);

        return r;
    }

    public Poligono transladarPoligono(Poligono p, double dx, double dy) {

        double[][] translacao = new double[3][3];
        translacao[0][0] = 1;
        translacao[0][1] = 0;
        translacao[0][2] = dx;
        translacao[1][0] = 0;
        translacao[1][1] = 1;
        translacao[1][2] = dy;
        translacao[2][0] = 0;
        translacao[2][1] = 0;
        translacao[2][2] = 1;

        String result = "";
        for (int i = 0; i < translacao[0].length; i++) {
            for (int j = 0; j < translacao[i].length; j++) {
                result += String.format("%11.2f", translacao[i][j]);
            }
            result += "\n";
        }
        System.out.println(result);

        ArrayList novosPontos = new ArrayList();
        for (Ponto ponto : p.getPontos()) {
            double[][] pt = new double[3][1];

            pt[0][0] = ponto.getX();
            pt[1][0] = ponto.getY();
            pt[2][0] = w;

            double[][] pLinha = multiplicarMatrizes(translacao, pt);

            novosPontos.add(new Ponto((int) pLinha[0][0], (int) pLinha[1][0]));
        }

        p.setPontos(novosPontos);

        return p;
    }

    public Poligono rotacionarPoligono(Poligono p, double angulo, double[] pivo) {

        double[][] rotacao = new double[3][3];
        rotacao[0][0] = Math.cos(angulo);
        rotacao[0][1] = -Math.sin(angulo);
        rotacao[0][2] = 0;
        rotacao[1][0] = Math.sin(angulo);
        rotacao[1][1] = Math.cos(angulo);
        rotacao[1][2] = 0;
        rotacao[2][0] = 0;
        rotacao[2][1] = 0;
        rotacao[2][2] = 1;

        String result = "";
        for (int i = 0; i < rotacao[0].length; i++) {
            for (int j = 0; j < rotacao[i].length; j++) {
                result += String.format("%11.2f", rotacao[i][j]);
            }
            result += "\n";
        }
        System.out.println(result);

        ArrayList novosPontos = new ArrayList();
        for (Ponto ponto : p.getPontos()) {

            //Translação 1============================================
            double[][] translacao = new double[3][3];
            translacao[0][0] = 1;
            translacao[0][1] = 0;
            translacao[0][2] = -pivo[0];
            translacao[1][0] = 0;
            translacao[1][1] = 1;
            translacao[1][2] = -pivo[1];
            translacao[2][0] = 0;
            translacao[2][1] = 0;
            translacao[2][2] = 1;

            double[][] pt = new double[3][1];
            pt[0][0] = ponto.getX();
            pt[1][0] = ponto.getY();
            pt[2][0] = w;

            double[][] pLinha = multiplicarMatrizes(translacao, pt);

            //========================================================
            //Rotação        
            pt = new double[3][1];
            pt[0][0] = pLinha[0][0];
            pt[1][0] = pLinha[1][0];
            pt[2][0] = w;

            pLinha = multiplicarMatrizes(rotacao, pt);

            //=========================================================
            //Translação 2
            translacao = new double[3][3];
            translacao[0][0] = 1;
            translacao[0][1] = 0;
            translacao[0][2] = pivo[0];
            translacao[1][0] = 0;
            translacao[1][1] = 1;
            translacao[1][2] = pivo[1];
            translacao[2][0] = 0;
            translacao[2][1] = 0;
            translacao[2][2] = 1;

            pt = new double[3][1];
            pt[0][0] = pLinha[0][0];
            pt[1][0] = pLinha[1][0];
            pt[2][0] = w;

            pLinha = multiplicarMatrizes(translacao, pt);

            novosPontos.add(new Ponto((int) pLinha[0][0], (int) pLinha[1][0]));
        }

        p.setPontos(novosPontos);

        return p;
    }

    public Poligono escalonarPoligono(Poligono p, double sx, double sy, double[] pivo) {

        double[][] escala = new double[3][3];
        escala[0][0] = sx;
        escala[0][1] = 0;
        escala[0][2] = 0;
        escala[1][0] = 0;
        escala[1][1] = sy;
        escala[1][2] = 0;
        escala[2][0] = 0;
        escala[2][1] = 0;
        escala[2][2] = 1;

        String result = "";
        for (int i = 0; i < escala[0].length; i++) {
            for (int j = 0; j < escala[i].length; j++) {
                result += String.format("%11.2f", escala[i][j]);
            }
            result += "\n";
        }
        System.out.println(result);

        ArrayList novosPontos = new ArrayList();
        for (Ponto ponto : p.getPontos()) {

            //Translação 1============================================
            double[][] translacao = new double[3][3];

            translacao[0][0] = 1;
            translacao[0][1] = 0;
            translacao[0][2] = -pivo[0];
            translacao[1][0] = 0;
            translacao[1][1] = 1;
            translacao[1][2] = -pivo[1];
            translacao[2][0] = 0;
            translacao[2][1] = 0;
            translacao[2][2] = 1;

            double[][] pt = new double[3][1];
            pt[0][0] = ponto.getX();
            pt[1][0] = ponto.getY();
            pt[2][0] = w;

            double[][] pLinha = multiplicarMatrizes(translacao, pt);

            //========================================================
            //Rotação
            pt = new double[3][1];
            pt[0][0] = pLinha[0][0];
            pt[1][0] = pLinha[1][0];
            pt[2][0] = w;

            pLinha = multiplicarMatrizes(escala, pt);

            //=========================================================
            //Translação 2
            translacao = new double[3][3];
            translacao[0][0] = 1;
            translacao[0][1] = 0;
            translacao[0][2] = pivo[0];
            translacao[1][0] = 0;
            translacao[1][1] = 1;
            translacao[1][2] = pivo[1];
            translacao[2][0] = 0;
            translacao[2][1] = 0;
            translacao[2][2] = 1;

            pt = new double[3][1];
            pt[0][0] = pLinha[0][0];
            pt[1][0] = pLinha[1][0];
            pt[2][0] = w;

            pLinha = multiplicarMatrizes(translacao, pt);

            novosPontos.add(new Ponto((int) pLinha[0][0], (int) pLinha[1][0]));
        }

        p.setPontos(novosPontos);

        return p;
    }

    public void tracaLinhaBresenham(Graphics2D g, int x1, int y1, int x2, int y2) {
        //Coordenadas originais
        int dx = Math.abs(x2 - x1);
        //Coordenadas corrigidas
        int x = (X0 + (x1 * espaco));
        int y = (Y0 - (y1 * espaco));
        int xfi = (X0 + (x2 * espaco));
        int yfi = (Y0 - (y2 * espaco));
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

    public void cohenSutherland(Graphics2D g, HashMap objetos) {
        
        

        
}
}
