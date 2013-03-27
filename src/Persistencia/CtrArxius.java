
package Persistencia;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miquel.masriera
 */
public class CtrArxius {
    
   
    public CtrArxius() {
    }
    
    
    /*
     * a aquesta funció li passes un nom i retorna :
     * TRUE si en el directori hi ha un arxiu amb aquell nom
     * FALSE si no n'hi ha cap
     */
    public boolean existeix( String nomArxiu ) {
        return new File( "./Data/"+nomArxiu+".txt").canRead();
    }
    
    
    /*
     * retorna el numero d'arxius del directori
     */
    public int numArxius( ) {
        return (int) new File(".").length(); 
    }
    
    /*
     * retorna un ArrayList amb tots el noms d'arxius d aquell directori
     * que contenen la paraula
     * 
     */
    public ArrayList llistaDirectori( String paraula ) {
        File f = new File(".");
        int numArxius = f.list().length;
        String llistaArxius[] = f.list(); // llista amb els noms de tots els arxius
        ArrayList llista = new ArrayList(); 
        
        for( int i = 0; i < numArxius; ++i)
            if(llistaArxius[i].contains(paraula)) llista.add( llistaArxius[i] );
        
        return llista;
    }
    
    /*
     a aquesta funcio li passes un nom i una llista amb la informacio
     * et crea un arxiu txt buit amb aquell nom i si ja existeix, el sobreescriu.
     * 
     * cada element de l array estara en una linia de l arxiu
     * 
     * si no voleu sobreescriure, feu servir abans la de existeix
     */
    public void creaArxiu( String nomArxiu, ArrayList llista) {           
                               
        FileWriter fitxer = null;
        PrintWriter pw = null;
        try
        {
            fitxer = new FileWriter("./Data/"+nomArxiu+".txt"); // crea l arxiu (sobrescriu)
            pw = new PrintWriter(fitxer);
            
            for(int i = 0; i < llista.size(); ++i) //posa l array al fitxer
                pw.println( llista.get(i) ); 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try 
           {
           if (null != fitxer) // tanco el fitxer d escriptura
              fitxer.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }     
    }
    
    /*
     * La funcio reb el nom d un arxiu
     * i et retorna una lllista que te a cada posicio el que hi ha en cada 
     * linia del fitxer 
     */
    public ArrayList llegir( String nomArxiu ) {
        ArrayList llista= new ArrayList();
        try {
            
            FileReader fr = null;
            BufferedReader br = null;
            String linia;
            
                fr = new FileReader("./Data/"+nomArxiu+".txt"); //crea el fitxer i el buffer
                br = new BufferedReader(fr);
                         
                while( (linia = br.readLine())!=null )  // posa cada linia a la llista 
                    llista.add( linia );
                    
                   fr.close();          //tanca el fitxer   
   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CtrArxius.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CtrArxius.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llista;
    }
    
    /*
     * esborra l' arxiu amb aquell nom
     */
    void esborra( String nomArxiu ) {
        if ( existeix( nomArxiu ) ) 
            new File( "./Data/"+nomArxiu+".txt").delete();
        
        else System.out.println(" no s'ha pogut esborrar");
    }
        
    
}
