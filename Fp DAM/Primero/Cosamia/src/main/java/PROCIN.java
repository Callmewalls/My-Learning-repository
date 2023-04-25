
public class PROCIN { 
    
    private String EstadoSemaforo = "Rojo";

  public void PonColor (String Color){
      EstadoSemaforo = Color;
     
  }
  
  
  public String DimeColor(){
      return EstadoSemaforo;
  }
}