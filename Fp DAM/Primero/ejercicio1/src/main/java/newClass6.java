import java.util.Scanner;
public class newClass6 {
public static void main(String[]args){

Scanner tcl=new Scanner (System.in);
float cuota=500;float dinero, edad;boolean socio;
    System.out.println("Escriba su edad por favor: ");edad=tcl.nextFloat();
    System.out.println("Es usted soci@:(true/false)");socio=tcl.nextBoolean();
if(edad>=65){
    cuota=cuota/2;
    System.out.println("La cuota será de: "+cuota);
}
else if(edad<18 && !socio){
    cuota=375;
    System.out.println("La cuota será de :"+cuota);
}   
else if(edad<18 && socio){
    cuota=325;
    System.out.println("La cuota será de :"+cuota);
}
else{
    System.out.println("La cuota será de :"+cuota);
}
}
}
