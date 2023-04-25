package PACK1;
public class Coche0 {
    
        private String modelo, color, matricula, tipo, modalidadSeguro;
        private int año;
        private boolean esmetal;
                     
        public Coche0(){       
        modelo="x";
        color="Verde";
        tipo="DEPORTIVO";
        modalidadSeguro="Terceros";
        matricula="V-1111-AA";
        esmetal=false;
        año=9999;
         }
        
        public void setmodelo(String a){
            modelo=a;
        }
         public void setcolor(String a){
           color=a;
        }
          public void settipo(String a){
            tipo=a;
        }
           public void setmododalidadSeguro(String a){
            modalidadSeguro=a;
        }
            public void setmatricula(String a){
            matricula=a;
        }
             public void setesmetal(Boolean a){
            esmetal=a;
        }
             public void setesmetal(int a){
            año=a;
        }
             public void setCoche(String mod, String col,String tip,String seg,String mat, 
                                    int ano, boolean esm){
    
                modelo= mod;
                color= col;
                tipo= tip;
                matricula= mat;
                modalidadSeguro= mod;
                año= ano;
                esmetal= esm;
            }
              public void imprimeCoche() {
        System.out.println("********************************************");
        System.out.println("** Modelo: " + modelo);
        System.out.println("********************************************");
        System.out.println("** Color: " + color);
        System.out.println("** Tipo Coche: " + tipo);
        System.out.println("** Modalidad Seguro: " + modalidadSeguro);
        System.out.println("** Matricula: " + matricula);
        if (esmetal) {
            System.out.println("** Metalizado: SI");
        } else {
            System.out.println("** Metalizado: NO");
        }
        System.out.println("** Año Fabricación: " + año);
        System.out.println("********************************************\n");
    }
                                    
    
}
