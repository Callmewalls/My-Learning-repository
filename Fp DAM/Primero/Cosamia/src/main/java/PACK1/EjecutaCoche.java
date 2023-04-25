package PACK1;

public class EjecutaCoche {

    public static void main(String[] args) {
        Coche deportivo = new Coche();
        Coche todoterreno = new Coche();
        Coche crossover = new Coche();
        Coche beetle = new Coche();//Sin valores para ver como actua el constructor

        deportivo.setModelo("Citroen Xsara");
        deportivo.setColor("Azul");
        deportivo.setTipoCoche("FAMILIAR");
        deportivo.setModalidadSeguro("Terceros");
        deportivo.setMatricula("V-7548 GV");
        deportivo.setAnoFabricacion(1995);
        deportivo.setEsMetalizado(true);

        todoterreno.setCoche("Renault Megane", "Gris", "FAMILIAR", "A todo riesgo", "1548-GVZ", false, 2010);
        crossover.setCoche("BMW X7", "Negro", "DEPORTIVO", "A todo riesgo", "4875-HJM", true, 2012);
        //Mostrar  color deportivo
        //System.out.println("Color deportivo: " + deportivo.getColor());
        //Mostrar tipo coche
        //System.out.println("Tipo coche todoterreno: " + todoterreno.getTipoCoche());
        deportivo.imprimeCoche();
        todoterreno.imprimeCoche();
        crossover.imprimeCoche();
        beetle.imprimeCoche();

    }
}
