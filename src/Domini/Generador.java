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
    private Horari horari = new Horari();
    
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
                CjtAules aulesPos = new CjtAules();
                //Inicialitzacio clausules amb grups de laboratori
                if(g%10 != 0) {
                    aulesPos = aulesL.cjtCapacitatMajorDe(a.getCapacitatLab());
                    int i = 0;
                    for (Integer h : a.getIntervalsP()) {
                        c.setDuracio(h);
                        clausules.add(c);
                        //Inicialitzacio del domini
                        for (Aula au : aulesPos.getCjtAules()){
                            nomAul = au.getNom();
                            for (Pair d : dis.disponibilitat()){
                                dia = (String)d.getL();
                                hora = (Integer)d.getR();
                                clausules.get(i).afegirElem(nomAul, dia, hora);
                            }
                        }
                        ++i;
                    }
                }
                else {
                    aulesPos = aulesT.cjtCapacitatMajorDe(a.getCapacitatTeo());
                    int i = 0;
                    for (Integer h : a.getIntervalsT()) {
                        c.setDuracio(h);
                        clausules.add(c);
                        //Inicialitzacio del domini
                        for (Aula au : aulesPos.getCjtAules()){
                            nomAul = au.getNom();
                            for (Pair d : dis.disponibilitat()){
                                dia = (String)d.getL();
                                hora = (Integer)d.getR();
                                clausules.get(i).afegirElem(nomAul, dia, hora);
                            }
                        }
                        ++i;
                    }
                }
            }
        }
        return clausules;
    }
            
    public Horari generar(CjtAules aulesT, CjtAules aulesL, CjtAssignatures ass,
        RestriccioTemps dis) {
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT,aulesL,ass,dis);
        return horari;
    }
    
}
