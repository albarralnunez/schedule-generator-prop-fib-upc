/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

import java.util.ArrayList;

/**
 *
 * @author albertomarin
 */
public class Clausula {

    private class Elemento {
        Aula a;
        /* TODO:
         * Dia d;
         * Hora h;
         */
    }

    private ArrayList<Elemento> clausula;

    //Constructora
    public Clausula() {
        clausula = new ArrayList<Elemento>();
    }

    //Métodos


    /**
    * S'afegeix l'element e a la clausla.
    * @param a, d, h son l'aula el día i l'hora.
    */

    public void AfegirElem(Aula a, Dia d, Hora h) {
        Elemento e = new Elemento();
        e.a = a;
        e.d = d;
        e.h = h;
        clausula.add(e);
    }


    /**
     * S'esborra l'element e de la clausula
     * @param a, d, h son l'aula el dia i l'hora.
     */

    public boolean BorrarElem(Aula a, Dia d, Hora h) {
        Elemento e = new Elemento();
        e.a = a;
        e.d = d;
        e.h = h;
        return clausula.remove(e);
    }

    /**
     * Es busca l'element en la clau y es retorna on booleà indicant el resultat
     * @param a, d, h son l'aula, el dia i l'hora que formen l'element a buscar
     * @return true si hem trobat l'element o false en cas contrari.
     */

    public boolean BuscarElem(Aula a, Dia d, Hora h) {
        Elemento e = new Elemento();
        e.a = a;
        e.d = d;
        e.h = h;
        for(Elemento e1: clausula){
                if(e1 == e) return true;
        }
        return false;
    }

}









    }














}
