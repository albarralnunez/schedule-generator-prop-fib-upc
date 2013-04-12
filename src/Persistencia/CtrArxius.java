package Persistencia;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miquel.masriera
 */
public class CtrArxius extends CtrDisc {
    
   /**
     *creadora per defecte, crea en el directori del projecte la carpeta Data
     * que contindrÃ  tots els fitxers
     */
    public CtrArxius() {
    }
    
    /**
     * 
     * aquesta funciÃ³ crea un fitxer de text .txt amb el nom i contingut que 
     * se li passa 
     * 
     * per evitar sobreescriptures abans de cridar aquesta funciÃ³, fer existeix
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
     * funciÃ³ que llegeix un fitxer i posa el seu contingut en una llista
     * 
     * @param nomArxiu nom de l'arxiu a llegir
     * 
     * @return retorna un ArrayList amb el contingut del fitxer, a cada posiciÃ³
     * hi ha una linia del fitxer
     */
    public ArrayList<String> llegirArxiu( String nomArxiu ) {
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
    
          
}
