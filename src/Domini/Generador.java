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
    private Quadricula design;  

    public Generador() {
        this.horari = null;
        this.design = null;
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
                        //nomAul = au.getNom();
                        ClausulaNom cn = new ClausulaNom();
                        cn.setAula(au.getNom());
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
                                   cn.setDia("dilluns");
                                   for (Integer d : dis.getDilluns()){
                                        cn.setHora(d);
                                        c.afegirElem(cn);
                                   }
                                }
                                if (j == 1) {
                                   cn.setDia("dimarts");
                                   for (Integer d : dis.getDimarts()){                                     
                                        cn.setHora(d);
                                        c.afegirElem(cn);
                                   }
                                }
                                if (j == 2) {
                                    cn.setDia("dimecres");
                                   for (Integer d : dis.getDimecres()){
                                        cn.setHora(d);
                                        c.afegirElem(cn);
                                   }
                                }
                                if (j == 3) {
                                    cn.setDia("dijous");
                                    for (Integer d : dis.getDijous()){
                                        cn.setHora(d);
                                        c.afegirElem(cn);
                                   }
                                }
                                if (j == 4) {
                                    cn.setDia("divendres");
                                    for (Integer d : dis.getDivendres()){
                                        cn.setHora(d);
                                        c.afegirElem(cn);
                                   }
                                }
                                if (j == 5) {
                                    cn.setDia("disabte");
                                    for (Integer d : dis.getDissabte()){
                                        cn.setHora(d);
                                        c.afegirElem(cn);
                                   }
                                }
                                if (j == 6) {
                                    cn.setDia("diumenge");
                                    for (Integer d : dis.getDiumenge()){     
                                        cn.setHora(d);
                                        c.afegirElem(cn);
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
        Quadricula qu = backtracking(clau, q);
        return true;
    }

    private Quadricula backtracking(ArrayList<Clausula> clau,Quadricula qu) {
        if (clau.isEmpty()) { // Tenim una solucio
            return qu;
        }
        else {
            Clausula c = clau.get(0);
            clau.remove(0);
            for(ClausulaNom cn : c.getClausula()){
                Element e = new Element();
                e.setAssignatura(c.getAssignatura());
                e.setAula(cn.getAula());
                e.setGrupo(c.getGrup());
                qu.afegirElement(cn.getDia(), cn.getHora(), e);
            }
            
        }
        return qu;
    }
    
}
