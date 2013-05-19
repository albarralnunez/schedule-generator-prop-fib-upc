/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel Albarral
 */
public class RestGrupoAula extends Restriccio {



    private String assignatura;
    private Integer grup;
    private String aula;

    /**
     *
     */
    public RestGrupoAula() {
        super(1);
    }
    
    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrup() {
        return grup;
    }

    public void setGrup(Integer grup) {
        this.grup = grup;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean CompleixRes(){return false;}
    
    private int traduccioDiaHora(String dia,int hora){
        int valor = 0;
        if(dia.equals("dilluns")) valor = 100;
        else if(dia.equals("dimarts")) valor = 200;
        else if(dia.equals("dimecres")) valor = 300;
        else if(dia.equals("dijous")) valor = 400;
        else if(dia.equals("divendres")) valor = 500;
        else if(dia.equals("dissabte")) valor = 600;
        else if(dia.equals("diumenge")) valor = 700;
        valor += hora;
        return valor;
    }
    private int traduccioDiaHora2(int dia,int hora){
        int valor = 0;
        if(dia == 0) valor = 100;
        else if(dia == 1) valor = 200;
        else if(dia == 2) valor = 300;
        else if(dia == 3) valor = 400;
        else if(dia == 4) valor = 500;
        else if(dia == 5) valor = 600;
        else if(dia == 6) valor = 700;
        valor += hora;
        return valor;
    }
    /**
     *
     * @param cjtRga
     * @param cjtResAul
     * @param cjtResAssig
     * @return
     */
    public boolean esPotAfegir(CjtRestGrupoAula cjtRga,CjtRestriccioAula cjtResAul,
            CjtRestGrupSessio cjtResGS, Quadricula quad) {
        
        
        return true;
        
        //NO BORRAR ESTO!!!!!!!!!!!!!!!!!!!!!!!!!!
        
       /* for (Restriccio  res: cjtRga.getCjtRes()) {
            RestGrupoAula resdw = (RestGrupoAula) res; 
            if (resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup() == this.grup) return false;
            if(this.id == 1){
                if (resdw.getId() == 2 && resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup() == this.grup && resdw.getAula().equals(this.aula)) return false;
            }
            else if(this.id == 2){
                if (resdw.getId() == 1 && resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup() == this.grup && resdw.getAula().equals(this.aula)) return false;
            }
        }
        switch(this.id){
            case 1:
                    int diahora;
                    for(Restriccio res: cjtResGS.getCjtRes()){
                        RestGrupSessio resdw = (RestGrupSessio) res;
                        if(resdw.getAssignatura().equals(this.assignatura) && resdw.getGrup().equals(this.grup)){
                            diahora = traduccioDiaHora2(resdw.getDia(),resdw.getHora());
                            if(resdw.ObtenirId() == 3) {
                                for(Restriccio res2: cjtResAul.cjtRes){
                                    RestriccioAula resdw2 = (RestriccioAula) res2;
                                    if(resdw2.getAula().getNom().equals(this.aula)){
                                        if((resdw2.ObtenirId() == 13) && (diahora == traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                        else if((resdw2.ObtenirId() == 14) && (diahora < traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                        else if((resdw2.ObtenirId() == 15) && (diahora > traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                    }
                                }
                            }
                            else if (resdw.ObtenirId() == 4){
                                for(Restriccio res2: cjtResAul.cjtRes){
                                    RestriccioAula resdw2 = (RestriccioAula) res2;
                                    if(resdw2.getAula().getNom().equals(this.aula)){
                                        if((resdw2.ObtenirId() == 13) && (diahora > traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                        else if((resdw2.ObtenirId() == 14) && (diahora < traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                        else if((resdw2.ObtenirId() == 15) && (diahora > traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                    }
                                }
                            }
                             else if (resdw.ObtenirId() == 5){
                                for(Restriccio res2: cjtResAul.cjtRes){
                                    RestriccioAula resdw2 = (RestriccioAula) res2;
                                    if(resdw2.getAula().getNom().equals(this.aula)){
                                        if((resdw2.ObtenirId() == 13) && (diahora < traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                        else if(resdw2.ObtenirId() == 14) {
                                            String dia = quad.ultimDiaValid();
                                            int hora = quad.ultimaHoraValida(dia);
                                            if(resdw2.getDia().equals(dia) && resdw2.getHora() == hora) return false;
                                        }
                                        else if((resdw2.ObtenirId() == 15) && (diahora > traduccioDiaHora(resdw2.getDia(),resdw2.getHora()))) return false;
                                    }
                                }
                            }
                        }
                        
                    }
                    break;
            case 2:
                    break;
        }
        return true;*/
    }
    
    
    /**
     *
     * @param assignatura
     * @param grup
     * @param aula
     * @return
     */
     public boolean compleixRes1(Clausula c, ClausulaNom cn) {
        /*if (c.getAssignatura().getNom().equals(this.assignatura) &&
                c.getGrup() == this.grup) {
            boolean b = this.aula.equals(cn.getAula().getNom());
            return (b ? true : false);
        }
        return true;*/
        if(c.getAssignatura().getNom().equals(this.assignatura) && c.getGrup() == this.grup){
                return cn.getAula().getNom().equals(this.aula);
        }
        return true;
     }
     public boolean compleixRes2(Clausula c, ClausulaNom cn) {
        /*if (c.getAssignatura().getNom().equals(this.assignatura) &&
                c.getGrup() == this.grup) {
            boolean b = this.aula.equals(cn.getAula().getNom());
            return (b ? true : false);
        }
        return true;*/
        if(c.getAssignatura().getNom().equals(this.assignatura) && c.getGrup() == this.grup){
                if(cn.getAula().getNom().equals(this.aula)) return false;
                else return true;
        }
        return true;
     }
     
    /**
     *
     * @param assignatura
     * @param grup
     * @param aula
     * @return
     */
     public boolean compleixRes(CjtElements el) {
         boolean b = false;
        for (Element elcjt : el.getAssignacions()) {
            if (b) break;
            if (elcjt.getAssignatura().getNom().equals(this.assignatura) &&
                    elcjt.getGrupo() == this.grup){
                b = (elcjt.getAula().getNom().equals(this.aula));
            }
            else b = true;
        }
        return b;
    }
    
    
    
}
