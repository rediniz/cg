/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacoes;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Transforma {
    
    

    public double[][] multiplica(double a[][], double b[][]) {
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
}
