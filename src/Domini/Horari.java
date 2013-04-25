/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */

//TODO: PROGRAMAR TODO
public class Horari {

     private class ElementR {
        String aula;
        String assignatura;
        int grupo;
        String dia;
        int hora;
    }
     
    private ArrayList<ElementR> horari;
    
    public Horari() {
        horari = new ArrayList();
        ElementR el = new ElementR();
        el.assignatura = null;
        el.aula = null;
        el.grupo = -1;
        el.dia = null;
        el.hora = -1;
    }
}
