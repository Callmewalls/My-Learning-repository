import java.util.Scanner; 
public class area {
    public static double area (double r){
        Scanner tcl= new Scanner(System.in);
        final double PI=3.1416;
        double A;
        A=PI*r*r;
        return A;
        
    }
    public static double longitud (double r){
        final double PI=3.1416;
        double L;
        L=2*PI*r;
        return L;
    }
    public static double mayorque(){
        Scanner tcl= new Scanner(System.in);
        System.out.println("Escriba el 1er número: ");double A=tcl.nextDouble();
        System.out.println("Escriba el 2º número: ");double B=tcl.nextDouble();
        if(A>B){
            return A;
        }else{
            return B;
        }
    }
      public static double mayorque3(){
        Scanner tcl= new Scanner(System.in);
        System.out.println("Escriba el 1er número: ");double A=tcl.nextDouble();
        System.out.println("Escriba el 2º número: ");double B=tcl.nextDouble();
        System.out.println("Escriba el 3er número: ");double C=tcl.nextDouble();
        if(A>B &&A>C){
            return A;
        }else if(B>A && B>C){
            return B;
        }else if(C>A && C>B){
            return C;
        }
        return 0;
      }

      public static double mayorque4(double A,double B,double C,double D){
           if(A>B &&A>C && A>D){
            return A;
        }else if(B>A && B>C && B>D){
            return B;
        }else if(C>A && C>B && C>D){
            return C;
        }else if(D>A && D>B && D>C)
            return D;
        return 0;
          
      }
}

