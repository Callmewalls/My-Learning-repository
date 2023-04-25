import java.util.Scanner;
public class newClass4 {
    public static void main(String[]args){
    Scanner tcl=new Scanner(System.in);
    float cal;
    cal=tcl.nextFloat();
    if(cal<=3){
        System.out.print("M.D.");}
    else
       if(cal>3 & cal<5){
    System.out.println("INS");}
    else
       if(cal>5 & cal<6){
    System.out.println("SUF");}
    else
       if(cal>6 & cal<7){
    System.out.println("BIEN");}
    else
       if(cal>7 & cal<9){
    System.out.println("NOT");}
    else   
       if(cal>9){
    System.out.println("SOB");}
}
}

