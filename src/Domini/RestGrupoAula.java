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
    
    /**
     *
     * @param assignatura
     * @param grupo
     * @param aula
     */
    public RestGrupoAula(String assignatura, Integer grupo, String aula) {
        super (1);
        this.assignatura = assignatura;
        this.grup = grupo;
        this.aula = aula;
    }
    
    /**
     *
     * @return
     */
    public String getAssignatura() {
        return assignatura;
    }

    /**
     *
     * @param assignatura
     */
    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    /**
     *
     * @return
     */
    public Integer getGrup() {
        return grup;
    }

    /**
     *
     * @param grupo
     */
    public void setGrup(Integer grupo) {
        this.grup = grupo;
    }

    /**
     *
     * @return
     */
    public String getAula() {
        return aula;
    }

    /**
     *
     * @param aula
     */
    public void setAula(String aula) {
        this.aula = aula;
    }
    
    @Override
    public boolean CompleixRes(){return false;}
    
    
    /**
     *
     * @param cjtRga
     * @param cjtResAul
     * @param cjtResAssig
     * @return
     */
    public boolean esPotAfegir(CjtRestriccions cjtRga,CjtRestriccions cjtResAul,
            CjtRestriccions cjtResAssig) {
        boolean comp = true;
        for (Restriccio  res: cjtRga.getCjtRes()) {
            RestGrupoAula resdw = (RestGrupoAula) res; //Downcast
            if (resdw.getAssignatura().equals(this.assignatura) &&
                    resdw.getGrup() == this.grup) comp = false;
        } //Si ya hay una restriccion del mismo grupo obligado a estar en una aula no podria añadirse !
        for (Restriccio resa : cjtResAul.getCjtRes()) {
            RestriccioAula resAuldw = (RestriccioAula)resa; //Downcast
            if (this.aula.equals(resAuldw.getAula())) {
                for (Restriccio resb : cjtResAssig.getCjtRes()) {
                    RestAssignatura resAssdw = (RestAssignatura)resb;
                    if (this.assignatura.equals(resAssdw.getAssignatura()) &&
                            this.grup == resAssdw.getGrup()){
                        if (resAuldw.getDia() == null) {
                            if (resAssdw.getHora() == resAuldw.getHora())
                                comp = false;
                        }
                        else if (resAuldw.getHora() == -1) { //DANI ESTE -1 HABRIA QUE CAMBIARLO A "NULL" PK HE USADO Integer en vez de int!!
                            if (resAssdw.getDia().equals(resAuldw.getDia()))
                                comp = false;
                        }
                        else {
                            if (resAssdw.getHora() == resAuldw.getHora() && 
                                    resAssdw.getDia().equals(resAuldw.getDia())) {
                                comp = false;
                            }
                        }
                    }
                }
            }
        }
        return comp;
    }
    
    /**
     *
     * @param assignatura
     * @param grup
     * @param aula
     * @return
     */
     public boolean compleixRes(String assignatura, int grup, String aula) {
        boolean comp = true;
        if (this.assignatura.equals(assignatura)  && this.grup == grup) {
            if (!this.aula.equals(aula)) comp = false;
        }
        return comp;
    }
    
    
    
}
