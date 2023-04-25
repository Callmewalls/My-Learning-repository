import java.util.Scanner;
public class newClass5 {
public static void main(String[]args){
Scanner tcl=new Scanner (System.in);
double valor;
int m200=0;
int m100=0;
int m50=0;
int m20=0;
int m10=0;
int m5=0;
int m2=0;
int m1=0;

    System.out.println("Escriba una cifra en euros: ");valor=tcl.nextFloat();
 do{
    m200=m200+1;
    valor=valor-2;
}while (valor>2);

 if(valor>1){
    valor=valor-1; m100++;
} 
   if(valor>0.50){
    valor=valor-0.5; m50++;
}

   if(valor>0.40){
    valor=valor-0.40; m20=m20+2;
}
  
   if(valor<0.40 && valor>0.20){
valor=valor-0.20; m20++;
}
 
   if(valor>0.10){
valor=valor-0.10; m10++;
}
 
   if(valor>0.05){
 valor=valor-0.05; m5++;
}
 
   if(valor>=0.04){
m2=m2+2;
}
 
   if(valor>=0.03){
    m2++; m1++;
}
 
   if(valor>=0.02){
    m2++;
}
 
   if(valor>=0.01){
    m1++;
}
System.out.println(m200+" 2euros,"+m100+" 1euro,"+m50+" 50cents,"+m20+" 20cents,"+m10+" 10cents,"+m5+" 5cents,"+m2+" 2cents,"+m1+" 1cent.");

}
}
