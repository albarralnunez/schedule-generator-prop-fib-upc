/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miquel.masriera
 */
public class CtrObjectes<Classe> extends CtrDisc implements Serializable {
    
    public CtrObjectes(){}
    
    
    /*
     * Clase1 c = new Clase1(34);
        co.creaObjecte( nom , c);
     */
    public boolean creaObjecte( String nom, Classe elem ){
        ObjectOutputStream sortida = null;
        try {
            if( ! existeix( nom ) ) {
            sortida = new ObjectOutputStream(new FileOutputStream("./Data/"+nom+".txt"));
            sortida.writeObject(elem);
            sortida.close();
            return true;
            }
            else { 
                System.out.println("ya existe");
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(CtrObjectes.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return false;
    }
    
    
    
    public Classe llegirObjecte(String nom)  {
        Classe aux = null;    
            try {
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("./Data/"+nom+".txt"));
                aux = (Classe) entrada.readObject();
                entrada.close();
                return aux;
            } catch (IOException ex) {
                Logger.getLogger(CtrObjectes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrObjectes.class.getName()).log(Level.SEVERE, null, ex);
            }
        return aux;
    }
    
    
}
