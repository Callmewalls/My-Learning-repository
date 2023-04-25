import java.util.Scanner;
public class newClass7 {
public static void main(String[]args){
Scanner tcl=new Scanner (System.in);
int edad,dn,mn,an,dh,mh,ah;
    System.out.println("Escriba su día de nacimiento: ");dn=tcl.nextInt();
    System.out.println("Escriba su mes de nacimiento");mn=tcl.nextInt();
    System.out.println("Escriba el año en que nació");an=tcl.nextInt();
    System.out.println("Escriba el día de hoy");dh=tcl.nextInt();
    System.out.println("El mes");mh=tcl.nextInt();
    System.out.println("Y el año");ah=tcl.nextInt();
edad=ah-an;
if(mh>mn && dh>dn){
edad++;
}
System.out.println(edad);
    }
}
