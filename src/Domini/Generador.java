/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author Daniel Albarral
 */
class Generador {
    
    private Quadricula  q;

    public Generador() {
        this.q = null;
    }
    
    private ArrayList<Clausula> inicialitzarClausules(CjtAules aulesT, CjtAules 
            aulesL, CjtAssignatures ass, RestriccioTemps dis) {
        ArrayList<Clausula> clausules = new ArrayList();
        ArrayList<Assignatura> as = ass.getCjtAssignatures();
        //for(Assignatura a : as){
        for (int i = 0; i < as.size(); ++i) {
            Clausula c = new Clausula();
            Assignatura a;
            a = as.get(i);
            c.setAssignatura(a.getNom());
            ArrayList<Integer>gup = a.getGrups();
            //for (Integer g : gup) {
            for (int k = 0; k < gup.size(); ++k) {
            Integer g = gup.get(k);
                c.setGrup(g);
                String nomAul;
                String dia;
                Integer hora;
                //Inicialitzacio clausules amb grups de laboratori         
                ArrayList<Integer> interval = new ArrayList<Integer>();
                CjtAules aulesPos = new CjtAules();
                if(g%10 != 0){  //GupsLab
                     aulesPos = aulesL.cjtCapacitatMajorDe(a.getCapacitatLab());
                     interval = a.getIntervalsP();
                }
                else{ //GrupsTeo
                    aulesPos = aulesT.cjtCapacitatMajorDe(a.getCapacitatTeo());
                    interval = a.getIntervalsT();
                }
                for (Integer h : interval) {
                    c.setDuracio(h);
                    //Inicialitzacio del domini
                    for (Aula au : aulesPos.getCjtAules()){
                        nomAul = au.getNom();
                        
                        boolean doo = true;//false;       
                        if (au.getClass().equals(AulaLab.class)) {
                            AulaLab aal = (AulaLab)au;/*
                            if (aal.getMaterial() && a.necesitaMaterial())
                                doo = true;*/
                        }
                        if (au.getClass().equals(AulaTeo.class)) {
                            AulaTeo aat = (AulaTeo)au;/*
                            if (aat.getProjector()&& a.necesitaProjector())
                                doo = true;*/
                        }
                        if (doo) {
                            for (int j = 0; j < 7; ++j) {
                                if (j == 0) {
                                     dia = "dilluns";
                                   for (Integer d : dis.getDilluns()){
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }
                                if (j == 1) {
                                    dia = "dimarts";
                                   for (Integer d : dis.getDimarts()){                                     
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }
                                if (j == 2) {
                                    dia = "dimecres";
                                   for (Integer d : dis.getDimecres()){
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }
                                if (j == 3) {
                                    dia = "dijous";
                                    for (Integer d : dis.getDijous()){
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }
                                if (j == 4) {
                                    dia = "divendres";
                                    for (Integer d : dis.getDivendres()){
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }
                                if (j == 5) {
                                    dia = "dissabte";
                                    for (Integer d : dis.getDissabte()){
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }
                                if (j == 6) {
                                    dia = "diumenge";
                                    for (Integer d : dis.getDiumenge()){     
                                        hora = d;
                                        c.afegirElem(nomAul, dia, hora);
                                   }
                                }  
                            }
                            clausules.add(c);
                        }
                    }
                }  
            }
        }          
        return clausules;
    }
            
    public boolean generar(CjtAules aulesT, CjtAules aulesL, CjtAssignatures ass,
        RestriccioTemps dis, Quadricula q) {
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT,aulesL,ass,dis);
        return true;
    }
    
}
