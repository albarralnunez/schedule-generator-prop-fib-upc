package Domini;

import java.util.*;
import java.lang.Object;
/**
 *
 *
 @author albert
 */
public class Espai {
  
  public class Pos{
   int x;
   int y;
  }
  public class Dades{
    int id;
    Object elem;
  }
 
  private Object matriuElements[][];
  private Hashtable<Integer,Pos> referencies;
  
     /**
        * Crea una instancia de la clase sense inicialitzar 
 */  
  Espai(){}
  /** 
        * Crea una instancia de la classe Espai.
        * @param a,b Son les mides de la matriu d'espai. 
  */
  public Espai(int a, int b){
    matriuElements = new Object[a][b];
    referencies = new Hashtable<Integer,Pos>();
  }
  /**
        * Inserta un element a la posició indicada
        * @param elem és l'element que es vol insertar
        * @param id és l'identificador del element
        * @param a,b son la posició a on s'insertaran
  */
  public void InsertarElement(Object elem,int id ,int a,int b) {
  
	Dades NovaDada= new Dades();
	NovaDada.id = id;
	NovaDada.elem=elem;
	matriuElements[a][b] =(Object) NovaDada;
	Pos aux = new Pos();
	aux.x = a;
	aux.y = b;
	referencies.put(id,aux);
  }
 /**
        * Elimina l'element amb l'identificador indicat 
        * @param id és l'identificador del objecte a eliminar
 */ 
  public void EliminarElement(int id) {
      referencies.remove(id);
  }
   /**
        * Elimina l'element de la posició indicada 
        * @param a,b son la posició del objecte a eliminar 
 */ 
  public void EliminarElementxy(int a,int b) {
      Dades aux =(Dades) matriuElements[a][b];
      referencies.remove(aux.id);
  }
   /**
        * Comprova si l'element amb l'identificador indicat existex
        * @param id és l'identificador de l'element que volem comprovar si existeix
	*@return <code>true</code> L'element existeix;
		 <code>false</code> L'element no existeix;
 */  
  public Boolean ExisteixElement(int id) {
      Pos aux = referencies.get(id);
      if (aux == null ) return false;
      else return true;
  }   
/**
        * Comprova si l'element amb la posició donada existex
        * @param a,b son la posició de l'element que volem comprovar si existeix
	*@return <code>true</code> L'element existeix;
		 <code>false</code> L'element no existeix;
 */  


  public Boolean ExisteixElementxy(int a,int b) {
      Dades aux =(Dades) matriuElements[a][b];
      if (referencies.get(aux.id)==null) return false;
      else return true;
	
  }
   /**
        * Retorna la coordenada X de l'element amb l'identificador donat 
        * @param id és el identificador de l'element que volem consultar 
	* @return cooerdenada X de l'element
 */  
  public int ConsultarPosx (int id) {
      Pos aux = referencies.get(id);
      return aux.x;
  }
     /**
        * Retorna la coordenada Y de l'element amb l'identificador donat 
        * @param id és el identificador de l'element que volem consultar 
	* @return cooerdenada Y de l'element

 */  
  public int ConsultarPosy (int id) {
      Pos aux = referencies.get(id);
      return aux.y;
  }
     /**
        * Retorna l'element amb l'identificador donat 
        * @param id és el identificador de l'element que volem consultar 
	* @return element amb id donada
 */  
  public Object ConsultarElement(int id) {
      Pos aux = referencies.get(id);
      Dades aux2 =(Dades) matriuElements[aux.x][aux.y];
      return aux2.elem;
  }
     /**
        * Retorna l'element situat a la posició donada 
        * @param a,b son la posició de l'element que volem consultar 
	* @return element amb posició donada
 */  
  public Object ConsultarElementxy (int a,int b) {
      Dades aux =(Dades) matriuElements[a][b];
      return aux.elem;
  }

}
