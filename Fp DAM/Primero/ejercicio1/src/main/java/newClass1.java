import java.util.Scanner;
public class newClass1 {
    public static void main(String args[]){
    Scanner tcl=new Scanner(System.in);
    int edad;
    System.out.println("Escriba su edad: ");edad=tcl.nextInt();
    if(edad>25){
    System.out.println("Eres mayor de 25");
    }else if(edad<25){
    System.out.println("Eres menor de 25");
    }else if(edad==25){
    System.out.println("Tienes 25");
    }
    }
}