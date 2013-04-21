/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.CtrPersistencia;
import java.util.ArrayList;

/**
 *
 * @author miquel
 */
public class CtrGeneracio {
    
    private RestriccioTemps resT;
    private CjtAules cjtAulLab;
    private CjtAules cjtAulTeo;
    private CjtAssignatures cjtAs;
    private String nomUnitat;
    private CtrPersistencia cper;
    
    public CtrGeneracio( String nomU ){
        nomUnitat = nomU;
        resT = new RestriccioTemps();
        cjtAulLab = new CjtAules();
        cjtAulTeo = new CjtAules();
        cjtAs= new CjtAssignatures();
        cper = new CtrPersistencia();
    }
    
    //TODO: Hay que depurar solo inicializar las seleccionads por user
    
    private void inicialitzarCjtAulesLab() {
        ArrayList<String> llistAules = cper.llistaAulesLab(nomUnitat);
        for(String nom : llistAules){
           nom = nom.replace("aula-lab-", "");
           nom = nom.replace(".txt", "");
           ArrayList<String> atributs = cper.llegirAulaLab(nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaLab a = new AulaLab(nom,Integer.parseInt (atributs.get(2)),b);
           cjtAulLab.afegirAula(a);
        }
    }
    
    private void inicialitzarCjtAulesTeo() {
        
        ArrayList llistAules = cper.llistaAulesTeo(nomUnitat);
        for (int i = 0; i < llistAules.size(); ++i) {
           Object nomO = llistAules.get(i);
           String nom = nomO.toString();
           nom = nom.replace("aula-teo-", "");
           nom = nom.replace(".txt", "");
           ArrayList<String> atributs = cper.llegirAulaTeo(nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaTeo a = new AulaTeo(nom,Integer.parseInt (atributs.get(2)),b);
           cjtAulTeo.afegirAula(a);
        }
    }
    
    
    private void inicialitzarCjtAssignatures() { //TODO Acabar esto cuando assignatura este escrito en disco
      /*  ArrayList<String> llistAssignatures = cper.llistaAssigantures(nomUnitat);
        for(String nom : llistAssignatures){
            ArrayList<String> atributs = cper.llegirAssignatura(nom);
            //Assignatura a = new Assignatura(nom, int ht, int hp, int nv,int capTeo, int capLab,ArrayList<Grupo> grupos)
            //assignatures.afegirAssignatura(a);
        }*/
    }
    
    private void inicialitazRestT(String a) {
        //a = a.replace(".txt", "");
        ArrayList<String> hd;
        hd = cper.llegirDisponibilitatHor(a);
        int z = 0;
        for (int i =0; i < 5; ++i){
            ArrayList<Integer> ar = new ArrayList();
            for (int j = 0; j < 13; ++j, ++z)
                 ar.add(Integer.parseInt(hd.get(z)));
            if (i == 0) resT.setDilluns(ar);
            if (i == 1) resT.setDimarts(ar);
            if (i == 2) resT.setDimecres(ar);
            if (i == 3) resT.setDijous(ar);
            if (i == 4) resT.setDivendres(ar);
        }
    }
    
    public Horari generarHorari(String a) {
        Generador g = new Generador();
        inicialitzarCjtAulesTeo();
        inicialitzarCjtAulesLab();
        inicialitzarCjtAssignatures();
        inicialitazRestT(a);
        return g.generar(cjtAulTeo,cjtAulLab,cjtAs, resT);
    }
    
    
    
    
    
    
    
    
}
