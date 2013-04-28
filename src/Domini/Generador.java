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

    private Quadricula horari;
    private CjtAssignatures cjtAss;

    public Generador() {
        this.horari = null;
        this.cjtAss = new CjtAssignatures();
        
    }

    private ArrayList<Clausula> inicialitzarClausules(CjtAules aulesT, 
            CjtAules aulesL, CjtAssignatures ass, RestriccioTemps dis) {
        ArrayList<Clausula> clausules = new ArrayList();
        ArrayList<Assignatura> as = ass.getCjtAssignatures();
        cjtAss = ass;
        for (int i = 0; i < as.size(); ++i) {
            Assignatura a;
            a = as.get(i);
            ArrayList<Integer> gup = a.getGrups();
            for (int k = 0; k < gup.size(); ++k) {
                Integer g = gup.get(k);
                String nomAul;
                String dia;
                Integer hora;
                //Inicialitzacio clausules amb grups de laboratori         
                ArrayList<Integer> interval = new ArrayList<Integer>();
                CjtAules aulesPos = new CjtAules();
                if (g % 10 != 0) {  //GupsLab
                    aulesPos = aulesL.cjtCapacitatMajorDe(a.getCapacitatLab());
                    interval = a.getIntervalsP();
                } else { //GrupsTeo
                    aulesPos = aulesT.cjtCapacitatMajorDe(a.getCapacitatTeo());
                    interval = a.getIntervalsT();
                }
                for (Integer h : interval) {
                    Clausula c = new Clausula();
                    c.setAssignatura(a.getNom());
                    c.setDuracio(h);
                    c.setGrup(g);
                    ArrayList<ClausulaNom> cnaux = new ArrayList<ClausulaNom>();
                    //Inicialitzacio del domini
                    for (Aula au : aulesPos.getCjtAules()) {
                        boolean doo = true;//false;       
                        if (au.getClass().equals(AulaLab.class)) {
                            AulaLab aal = (AulaLab) au;/*
                             if (aal.getMaterial() && a.necesitaMaterial())
                             doo = true;*/
                        }
                        if (au.getClass().equals(AulaTeo.class)) {
                            AulaTeo aat = (AulaTeo) au;/*
                             if (aat.getProjector()&& a.necesitaProjector())
                             doo = true;*/
                        }
                        if (doo) {
                            for (int j = 0; j < 7; ++j) {
                                if (j == 0) {
                                    for (Integer d : dis.getDilluns()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("dilluns");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                                if (j == 1) {
                                    for (Integer d : dis.getDimarts()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("dimarts");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                                if (j == 2) {
                                    for (Integer d : dis.getDimecres()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("dimecres");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                                if (j == 3) {
                                    for (Integer d : dis.getDijous()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("dijous");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                                if (j == 4) {
                                    for (Integer d : dis.getDivendres()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("divendres");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                                if (j == 5) {
                                    for (Integer d : dis.getDissabte()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("dissabte");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                                if (j == 6) {
                                    for (Integer d : dis.getDiumenge()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au.getNom());
                                        cn.setDia("diumenge");
                                        cn.setHora(d);
                                        cnaux.add(cn);
                                    }
                                }
                            }
                            c.setClausula(cnaux);
                        }
                    }
                    clausules.add(c);
                }
            }
        }
        return clausules;
    }

    public boolean assignacioValida(Quadricula q, Element e, String dia, int hora) {
        CjtElements elems = q.getElementsPosicio(dia, hora);//elements d aquella posicio

        if (!elems.isValid()) {
            return false; // en principio no deberia pasar ya de por si
        }
        // que en aquella hora nomes hi hagi un grup per aula
        if (!elems.aulaRepetida(e)) {
            return false;
        }
        //si es vol posar un grup de lab on hi ha un de teoria o al reves 
        if (elems.solapamentTeoriaPractica(e)) {
            return false;
        }
/*
        if (elems.solapamentNivell(e,cjtAss)){
            return false;
        }
*/
        return true;
    }

    public boolean generar(CjtAules aulesT, CjtAules aulesL, CjtAssignatures ass,
            RestriccioTemps dis, Quadricula q) {
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT, aulesL, ass, dis);
        boolean b = backtracking(clau, q);
        Quadricula qu = q;
        return b;
    }

    private boolean backtracking(ArrayList<Clausula> clau, Quadricula qu) {
        if (clau.isEmpty()) { // Tenim una solucio
            return true;
        } else {
            Clausula c = clau.get(0);
            clau.remove(0);
            for (ClausulaNom cn : c.getClausula()) {
                Element e = new Element();
                e.setAssignatura(c.getAssignatura());
                e.setAula(cn.getAula());
                e.setGrupo(c.getGrup());
                int duracio = c.getDuracio();
                int esVal = 0;
                boolean omfg = true; //para si asignamos y sale del horario
                if (duracio+cn.getHora() > 23) omfg = false;
                for (int i = 0; i < duracio && omfg; ++i) {
                    int hor = cn.getHora()+i;
                    String di = cn.getDia();
                    qu.afegirElement(di, hor, e);
                    if (! assignacioValida(qu, e, di, hor)) {
                        ++esVal;
                    }
                }
                if (esVal == 0) {
                    return backtracking(clau, qu);
                } 
                else {
                    for (int i = 0; i < duracio; ++i) {
                        int hor = cn.getHora() + i;
                        String di = cn.getDia();
                        qu.borrarElement(di, hor, e);
                    }
                }
            }
            return false;
        }
    }
}
