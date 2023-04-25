import java.util.Scanner;
public class newClass {
public static void main(String[]args){
Scanner tcl=new Scanner (System.in);
int edad;
    System.out.println("Escriba su edad por favor: ");edad=tcl.nextInt();
    if(edad>=18){
System.out.println("Eres mayor de edad");
}else{
System.out.println("Eres menor de edad");
}
    }
}
