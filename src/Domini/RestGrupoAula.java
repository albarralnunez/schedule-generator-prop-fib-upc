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
     * @param grup 
     */
    public void setGrup(Integer grup) {
        this.grup = grup;
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
    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean CompleixRes(){return false;}
    
    /**
     * Comprova que la aula passada per parametre compleixi la restriccio
     * @param au Aula que es comprova
     * @return Retorna un boolean que indica si compleix o no la restriccio del tipus 1
     */
     public boolean compleixRes1(Aula au) {
        
                return au.getNom().equals(this.aula);
     }
     /**
      * Comprova que la aula passada per parametre compleixi la restriccio
      * @param au Aula que es comprova
      * @return Retorna un boolean que indica si es comleix o no la restriccio del tius 2
      */
     public boolean compleixRes2(Aula au) {
        
                if(au.getNom().equals(this.aula)) return false;
                else return true;
     }
     
    
    
}
