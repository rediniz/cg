/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import java.util.ArrayList;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Poligono {
    
    private ArrayList<Ponto> pontos;
    private String id;
    
    public Poligono(ArrayList<Ponto> pontos, String id){
        this.pontos = pontos;
        this.id = id;
    }

    /**
     * @return the pontos
     */
    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(ArrayList pontos) {
        this.pontos = pontos;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return id+pontos.toString();
    }
    
}
