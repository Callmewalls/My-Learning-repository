
class Ficha{
    private int casilla;
   Ficha(){
       casilla=1;
   }
   public void avanzar(int n){
       casilla+=n;
   }
   public int casillaActual(){
       return casilla;
   }
  
}
