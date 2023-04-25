public class NewClass {
    public static void main (String []args){
        PROCIN MiSemaforo = new PROCIN();
        PROCIN SemaforoDeMiCalle= new PROCIN();
        PROCIN OtroSemaforo=new PROCIN();
        
        MiSemaforo.PonColor("Rojo");
        OtroSemaforo.PonColor("Verde");
        
        System.out.println(OtroSemaforo.DimeColor());
        System.out.println(SemaforoDeMiCalle.DimeColor());
        
        if(MiSemaforo.DimeColor().equals("Rojo"))
            System.out.println("No Pasar");
        
    }
}

    

   