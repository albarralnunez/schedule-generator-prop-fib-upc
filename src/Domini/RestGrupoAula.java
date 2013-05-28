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
    
    /**
     *
     * @param assignatura
     * @param grup
     * @param aula
     * @return
     */
     public boolean compleixRes1(Aula au) {
        
                return au.getNom().equals(this.aula);
     }
     public boolean compleixRes2(Aula au) {
        
                if(au.getNom().equals(this.aula)) return false;
                else return true;
     }
     
    /**
     *
     * @param assignatura
     * @param grup
     * @param aula
     * @return
     */
     /*public boolean compleixRes(CjtElements el) {
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
    }*/
    
    
    
}
