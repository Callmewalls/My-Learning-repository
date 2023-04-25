package PACK1;
public class LoadCoche {
    public static void main(String[]args){
        Coche deportivo=new Coche();
        Coche mini=new Coche();
        Coche utilitarrio=new Coche();
        Coche familiar=new Coche();
        
        deportivo.setCoche("Ferrari", "negro", "Focus"," A todo riesgo", "A-5498-jm", true, 1998);
        deportivo.imprimeCoche();
    }
}
