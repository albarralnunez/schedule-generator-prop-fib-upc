/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;


/**
 *
 * @author albertomarin
 */

//Esta Restriccion marca que una assignatura obj1 debe impartirse antes que otra obj2.
public class RestriccioAnterioritat extends Restriccio {

    private String obj1;
    private String obj2;
    private Integer objeto1;
    private Integer objeto2;



    //Aqui se crea la restriccion y se indican que asignacion debe ir antes (obj1) y cual despues (obj2)
    public RestriccioAnterioritat(String antes, String despues){
        super(6); //PROVISIONAL: ID = 1000
        obj1 = antes;
        obj2 = despues;
    }
    

    //obj1 y obj2 son asignaciones Strings, si encontramos en el horario obj2 antes que obj1 return false,
    @Override
    public boolean CompleixRes() {
        return false;
    }

    }
