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
    
    
    private ArrayList<Clausula> inicialitzarClausules(CjtAules aulesT, CjtAules 
            aulesL, CjtAssignatures ass, RestriccioTemps dis) {
        ArrayList<Clausula> clausules = new ArrayList();
        Clausula c = new Clausula();
        for(Assignatura a : ass.getCjtAssignatures()){
            c.setAssignatura(a.getNom());
            for (Grup g : a.getGrups()) {
                c.setGrup(g.getId());
                String nomAul;
                String dia;
                Integer hora;
                CjtAules aulesPos = new CjtAules();
                //Inicialitzacio clausules amb grups de laboratori
                if(g instanceof GrupLab) {
                    aulesPos = aulesL.cjtCapacitatMajorDe(g.getCapacidad());
                    int i = 0;
                    /////////////////////////////////////////////
                    //for (Integer h : a.getHoresP()) {
                    // EL FOR DE ABAJO ES PARA QUE COMPILE
                    for( int h = 0; h < 1; ++h) {
                    /////////////////////////////////////////////
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
                    aulesPos = aulesT.cjtCapacitatMajorDe(g.getCapacidad());
                    int i = 0;
                    /////////////////////////////////////////////
                    for( int h = 0; h < 1; ++h) {
                    // EL FOR DE ABAJO ES EL BUENO
                    //for (Integer h : a.getHoresT()) {
                    ////////////////////////////////////////////////////////////////
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
        Horari horari = new Horari();
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT,aulesL,ass,dis);

        return horari;
    }
    
}
