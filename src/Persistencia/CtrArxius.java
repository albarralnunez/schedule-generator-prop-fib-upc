
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
    
   /**
     *creadora per defecte, crea en el directori del projecte la carpeta Data
     * que contindrà tots els fitxers
     */
    public CtrArxius() {
        File carpetaData = new File("./Data");
        if( ! carpetaData.exists() ) carpetaData.mkdirs();
    }
    
    /**
     * 
     * @param nomArxiu nom de l arxiu a buscar, sense el format
     * 
     * @return retorna un boleà que es cert si hi ha un arxiu amb aquell nom
     */
    public boolean existeix( String nomArxiu ) {
        return new File( "./Data/"+nomArxiu+".txt").canRead();
    }
    
    
    /**
     * 
     * @return retorna el nombre d arxius d'aquell directori
     */
    public int numArxius( ) {
        return (int) new File("./Data/").length(); 
    }
    
    /**
     * 
     * @param paraula ha se ser part del nom (o el nom sencer) dels arxius 
     * que es volen trobar en el directori
     * 
     * @return retorna un ArrayList amb tots els fitxers d aquell 
     * directori que contenen la paraula que li passes per parametre 
     */
    public ArrayList llistaDirectori( String paraula ) {
        File f = new File("./Data/");
        int numArxius = f.list().length;
        String llistaArxius[] = f.list(); // llista amb els noms de tots els arxius
        ArrayList llista = new ArrayList(); 
        
        for( int i = 0; i < numArxius; ++i)
            if(llistaArxius[i].contains(paraula)) llista.add( llistaArxius[i] );
            
        return llista;
    }
    
    /**
     * 
     * aquesta funció crea un fitxer de text .txt amb el nom i contingut que 
     * se li passa 
     * 
     * per evitar sobreescriptures abans de cridar aquesta funció, fer existeix
     * 
     * @param nomArxiu nom de l'arxiu a crear ( sense format), si ja hi ha un 
     * arxiu amb aquest nom el sobreescriu 
     * 
     * @param llista de la qual es posara cada element en una linia del fitxer
     * de text
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
    
   /**
     * 
     * funció que llegeix un fitxer i posa el seu contingut en una llista
     * 
     * @param nomArxiu nom de l'arxiu a llegir
     * 
     * @return retorna un ArrayList amb el contingut del fitxer, a cada posició
     * hi ha una linia del fitxer
     */
    public ArrayList<String> llegir( String nomArxiu ) {
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
    
    /**
     * 
     * @param nomArxiu nom de l arxiu a esborrar
     * @return un bolea que indica que no s ha pogut esborrar l arxiu indicat
     */
    public boolean esborra( String nomArxiu ) {
        if ( existeix( nomArxiu ) ) 
            return new File( "./Data/"+nomArxiu+".txt").delete();
        else return false; 
    }
          
}
