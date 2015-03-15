/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos.recorte;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Recorte {

    public enum aresta {

        LEFT(0), RIGHT(1), BOTTOM(2), TOP(3);

        public int posicao;

        aresta(int direcao) {
            this.posicao = direcao;
        }

        public int direcao() {
            return posicao;
        }
    }

    public enum booleano {

        TRUE, FALSE;
    }

    boolean outcode;

}
