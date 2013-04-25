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
    
    private Horari  h;

    public Generador() {
        this.h = null;
    }
    
    private ArrayList<Clausula> inicialitzarClausules(CjtAules aulesT, CjtAules 
            aulesL, CjtAssignatures ass, RestriccioTemps dis) {
        ArrayList<Clausula> clausules = new ArrayList();
        Clausula c = new Clausula();
        for(Assignatura a : ass.getCjtAssignatures()){
            c.setAssignatura(a.getNom());
            for (Integer g : a.getGrups()) {
                c.setGrup(g);
                String nomAul;
                String dia;
                Integer hora;
                //Inicialitzacio clausules amb grups de laboratori         
                CjtAules aulesPos = new CjtAules();
                ArrayList<Integer> interval = new ArrayList<Integer>();
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
                    }
                    clausules.add(c);
                }  
            }
        }          
        return clausules;
    }
            
    public Horari generar(CjtAules aulesT, CjtAules aulesL, CjtAssignatures ass,
        RestriccioTemps dis) {
        h = new Horari();
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT,aulesL,ass,dis);
        return h;
    }
    
}
