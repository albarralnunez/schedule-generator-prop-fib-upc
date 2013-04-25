/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;
//import domini.Restriccio;
import java.lang.String;

/**
 *
 * @author albertomarin
 */

//Esta Restriccion marca que una assignatura obj1 debe impartirse antes que otra obj2.
public class RestriccioAnterioritat extends Restriccio {
    String obj1;
    String obj2;


    //Aqui se crea la restriccion y se indican que asignacion debe ir antes (obj1) y cual despues (obj2)
    public RestriccioAnterioritat(String antes, String despues){
        super(1000); //PROVISIONAL: ID = 1000
        obj1 = antes;
        obj2 = despues;

    }


    //obj1 y obj2 son asignaciones, de momento los tratamos como enteros que tienen una hora asignada en un dia si obj1 va antes que obj2 todo ok.
    //El @Override 
    //@Override
    public boolean CompleixRes() {
        Integer objeto1;
        Integer objeto2;
        objeto1 = Integer.parseInt(obj1);
        objeto2 = Integer.parseInt(obj2);
        if (objeto1 < objeto2) return true;
        return false;

    }









}
