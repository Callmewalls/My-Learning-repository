import java.util.Scanner;
public class mainClass {
    public static void main (String []args){
        Scanner tcl= new Scanner(System.in);
        /*
int m=5, n=4, result;
result=suma.suma(m,n);
System.out.println(result);
*/
        /*
double resultado,A,L;
System.out.println("Escriba el radio: ");double r=tcl.nextDouble();
A=area.area(r);
L=area.longitud(r);
System.out.println(A);
System.out.println(L);
*/
        /*
double num=area.mayorque3();
System.out.println("El resultado es: "+num);
*/
        System.out.println("Escriba el 1er número: ");double A=tcl.nextDouble();
        System.out.println("Escriba el 2º número: ");double B=tcl.nextDouble();
        System.out.println("Escriba el 3er número: ");double C=tcl.nextDouble();
        System.out.println("Escriba el 4º número: ");double D=tcl.nextDouble();
        double num=area.mayorque4(A,B,C,D);
        System.out.println("El mayor es: "+num);
}
}
