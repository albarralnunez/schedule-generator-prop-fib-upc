/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.Serializable;

/**
 *
 * @author miquel
 */
public class Quadricula implements Serializable {
    
    private CjtElements quadricula[][];

    public CjtElements[][] getQuadricula() {
        return quadricula;
    }
    
    public void afegirElement(String dia, int hora, Element e) {
        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        quadricula[i][hora].afegirElement(e);
    }
  
    
      public CjtElements getElementsPosicio(String dia, int hora){
        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        return quadricula[i][hora];
      }
      
    public void borrarElement(String dia, int hora, Element e) {

        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        quadricula[i][hora].borrarElement(e);

    }
    
    public Quadricula(){
        quadricula = new CjtElements[7][24];
        for(int i=0; i < 7; ++i) {
            for (int j=0; j < 24; ++j) {  
                quadricula[i][j] = new CjtElements(); 
            }
        }
    }
    
    public void validar( int fila, int columna){
        quadricula[fila][columna].setValid(true);
        
    }
    public int ultimaHoraValida(String dia){
        int hora = -1;
        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        for(int j = 0; j < 24;++i){
            if(quadricula[i][j].isValid()) hora = j;
        }
        return hora;
   }
   public String ultimDiaValid(){
       int dia = -1;
       boolean valid;
       for(int i = 0; i < 7;++i){
           valid = false;
           for(int j = 0; j < 24 && !valid; ++j){
               valid = quadricula[i][j].isValid();
           }
           if(valid) dia = i;
       }
       String ret = null;
       switch(dia){
           case 0:
                    ret = "dilluns";
                    break;
           case 1:
                    ret = "dimarts";
                    break;
           case 2:
                    ret = "dimecres";
                    break;
           case 3:
                    ret = "dijous";
                    break;
           case 4:
                    ret = "divendres";
                    break;
           case 5:
                    ret = "dissabte";
                    break;
           case 6:
                    ret = "diumenge";
                    break;
               
       }
       return ret;
   }
    
    
}
