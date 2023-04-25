import java.util.Scanner;
public class newClass2 {
    public static void main(String args[]) {
    Scanner tcl= new Scanner(System.in) ;
    int num;
    int resto;
    int coc;
    System.out.println("Escriba un número entero: ");num=tcl.nextInt();
    coc=num/2;
    resto=num-2*coc;
    if(resto==0){
    System.out.println("El número es par");
    }else{
    System.out.println("El numero es impar");
    }
    }
}
