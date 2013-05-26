/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Domini.Quadricula;
import java.util.ArrayList;

/**
 *
 * @author Miquel Masriera
 */
public class CtrPersistencia {

    CtrDisc cdisc;
    CtrArxius ca;
    CtrObjectes co;

    public CtrPersistencia() {

        cdisc = new CtrDisc();
        ca = new CtrArxius();
        co = new CtrObjectes();
    }

    public int nuemroArxius() {
        return ca.numArxius();
    }

    public ArrayList<String> llistaAssigantures(String nomUnitat) {
        return ca.llistaDirectori("assig-" + nomUnitat); // te totes les assignatures de la unitat docent 
    }

    /**
     *
     * @param nom
     * @param parametres
     */
    public void creaAssignatura(String nom, ArrayList parametres) {
        ca.creaArxiu("assig-" + nom, parametres);
    }

    public boolean existeixAssignatura(String nom) {
        return (ca.existeix("assig-" + nom)); // diu si existeix una assignatura amb aquell nom
    }

    public boolean esborraAssignatura(String nomAsg) { // nomAsg = UD-nom
        return ca.esborra("assig-" + nomAsg);
    }

    public ArrayList<String> llegirAssignatura(String nomAsg) {
        return ca.llegirArxiu("assig-" + nomAsg);
    }

    /**
     * Crea un Aula de Teoria.
     *
     * @param nom
     * @param a
     * @return Retrona si es pot crear l'aula de teoria
     */
    public void creaAulaTeo(String nom, ArrayList a) {
        if (existeixAula(nom)) {
            esborraAula(nom);
        }
        ca.creaArxiu("aula-teo-" + nom, a);
    }

    /**
     * Crea un Aula de Laboratori.
     *
     * @param nom
     * @param a
     * @return Retrona si es pot crear l'aula de laboratori
     */
    public void creaAulaLab(String nom, ArrayList a) {
        if (existeixAula(nom)) {
            esborraAula(nom);
        }
        ca.creaArxiu("aula-lab-" + nom, a);
    }

    public void creaHorari(String aula,ArrayList a){
        ca.creaArxiu("Horari-FIB-"+aula, a);
    }    
    /**
     * Comprueba si existe el Aula nomAula
     *
     * @param nomAula
     * @return Retorna si existe el aula nomAula
     */
    public boolean existeixAula(String nomAula) {
        return ca.existeix("aula-lab-" + nomAula) || ca.existeix("aula-teo-" + nomAula);
    }

    /**
     * Borra l'aula amb nom nomAula
     *
     * @param nomAula
     * @return Retorna si existeix l'aula que es vol borra.
     */
    public boolean esborraAula(String nomAula) {
        return ca.esborra("aula-teo-" + nomAula) || ca.esborra("aula-lab-" + nomAula);
    }

    /**
     *
     * @param nomUnitat
     * @return Llegeix un Aula
     */
    public ArrayList<String> llegirAula(String nomAula) {
            ArrayList<String> a = new ArrayList<String>(); 
            if( ca.existeix(nomAula) )
                a =  ca.llegirArxiu( nomAula);
            return a;
    }
    
    public ArrayList<String> llegirAulaTeo (String nomAula) {
            return ca.llegirArxiu("aula-teo-" + nomAula);
    }
    
    public ArrayList<String> llegirAulaLab(String nomAula) {
            return ca.llegirArxiu("aula-lab-" + nomAula);

    }
    

    /**
     *
     * @param nomUnitat
     * @return Retorna una lliste de totes les aules de la unitat decent
     * nomUnitat
     */
    public ArrayList  llistaAules(String nomUnitat) {
        ArrayList<String> a = new ArrayList();
        a = ca.llistaDirectori("aula-teo-" + nomUnitat);
        a.addAll(ca.llistaDirectori("aula-lab-" + nomUnitat));
        return a; // te totes les assignatures de la unitat docent 
    }

    /**
     *
     * @param nomUnitat
     * @return Retorna una lista de toadas las aulas de la unidad docente
     * nomUnitat.
     */
    public ArrayList llistaAulesTeo(String nomUnitat) {
        return ca.llistaDirectori("aula-teo-" + nomUnitat); // te totes les assignatures de la unitat docent 
    }

    /**
     *
     * @param nomUnitat
     * @return Retorna una lista de toadas las aulas de la unidad docente
     * nomUnitat.
     */
    public ArrayList  llistaAulesLab(String nomUnitat) {
        return ca.llistaDirectori("aula-lab-" + nomUnitat); // te totes les assignatures de la unitat docent 
    }

    public ArrayList<String> llegirDisponibilitatHor(String n) {
         return ca.llegirArxiu(n);
    }

    
    public ArrayList<String> llegirConfiguracioHoraria(String nomConfig ) {
        return ca.llegirArxiu(nomConfig);
    }

    public void escriuConfiguracioHoraria(ArrayList conf, String nomUnitat) {
        ca.creaArxiu( "configuracioHoraria-"+nomUnitat, conf);
    }

    public boolean existeixConfiguracioHoraria(String nomUnitat) {
        return cdisc.existeix("configuracioHoraria-"+nomUnitat);
    }

    public boolean guardaHorari(String nomh, Quadricula q) {
        if( co.existeix(nomh)) 
            return false;
        co.creaObjecte( nomh , q);
        System.out.println("creat "+nomh);
        return true;
    }
    
    public Quadricula carregaHorari( String nomHorari ){
        Quadricula q =  (Quadricula) co.llegirObjecte(nomHorari);
        return q;
    }

    public boolean existeixHorari( String nom ) {
        return co.existeix(nom);
    }
    public ArrayList<String> llegirRestriccions(String nomUnitat) {
        return ca.llegirArxiu("restriccions-" + nomUnitat);
    }
    public boolean existeixRest(String nomUnitat) {
        return ca.existeix("restriccions-"+nomUnitat); //diu si existeix el arixu restriccions-nomUnitat
    }
}
