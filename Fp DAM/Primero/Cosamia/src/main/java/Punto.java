    public class Punto {
    
        
            private int x, y;
            
            public void setCoordenadas(int a, int b){
                x = a;
                y = b;
            }
            public void setCoordenadaX(int a){
                x = a;
            }
            public void setCoordenadaY(int b){
                y = b;
            }
            public int getCoordenadaX(){
                return x;
            }
            public int getCoordenadaY(){
                return y;
            }
            public void imprimirCuadrante(){
                System.out.print("Hablamos del punto ("+
            x+","+y+")");
            }
    }
       
