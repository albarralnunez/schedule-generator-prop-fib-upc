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
public class Horario {
    private  ArrayList Dias;
    
    public Horario(int numDias){
        Dias = new ArrayList(numDias);
        for(int i = 0; i < numDias; i++) {
            Dias.add(i, new ArrayList(10));
            for (int j = 0; j < 10; j++) {
            }
        }
    }
    
}
