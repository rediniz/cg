/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Reta {

    private Ponto p1;
    private Ponto p2;
    private String id;

    public Reta(Ponto p1, Ponto p2, String id) {
        this.p1 = p1;
        this.p2 = p2;
        this.id = id;
    }

    /**
     * @return the p1
     */
    public Ponto getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(Ponto p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public Ponto getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(Ponto p2) {
        this.p2 = p2;
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
        return (id+" "+p1+p2);
    }

   
}
