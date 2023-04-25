import java.util.Scanner;
public class newClass3 {
public static void main(String[]args){
    Scanner tcl = new Scanner(System.in);
    float num1;float num2;
    System.out.print("Escriba un número real: ");num1=tcl.nextFloat();
    System.out.print("Escriba otro: ");num2=tcl.nextFloat();
    if(num1<num2){
    System.out.println(num1+"<"+num2);
    }else{
    System.out.println(num2+"<"+num1);
    }
}
}
