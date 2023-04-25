import java.util.Scanner;
public class PuntoApp {
    public static void main(String[]args){
        int coorX, coorY;
        Punto punto1;
        punto1= new Punto();
        Scanner tcl=new Scanner(System.in);
        System.out.print("Ingrese coordenanda x:");
        coorX=tcl.nextInt();
        System.out.print("Ingrese coordenanda y:");
        coorY=tcl.nextInt();
        punto1.setCoordenadas(coorX, coorY);
        punto1.imprimirCuadrante();
    }   
}
