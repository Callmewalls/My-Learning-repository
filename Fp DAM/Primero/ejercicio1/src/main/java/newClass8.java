import java.util.Scanner;
public class newClass8 {
public static void main(String[]args){
Scanner tcl=new Scanner (System.in);
int edad,dia,mes,ano,maximo = -1;
    System.out.println("Escriba el día: ");dia=tcl.nextInt();
    System.out.println("Escriba el mes: ");mes=tcl.nextInt();
    System.out.println("Escriba el año: ");ano=tcl.nextInt();
switch(mes){
case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
    maximo = 31;
break;
case 4: case 6: case 9: case 11:
maximo=30;
case 2: 
if(ano % 4 == 0 && ((ano % 100 != 0)   || (ano % 400 == 0))){
maximo = 29;
}
else{
maximo=28;
}
}
if(dia>0 && dia<=maximo && ano>0 && ano<2021){
System.out.println("Es fecha válida.");
    }
else{
System.out.println("La fecha no es válida.");}
    }
}
