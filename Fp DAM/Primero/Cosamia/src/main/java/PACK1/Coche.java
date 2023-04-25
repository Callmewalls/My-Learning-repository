/*
*1. Clase COCHE
a) Definir una clase que represente a un coche. En la definición se debe incluir:
 el modelo
 el color
 si la pintura es metalizada o no
 la matrícula
 El tipo de coche que puede ser MINI, UTILITARIO, FAMILIAR o DEPORTIVO
 El año de fabricación
 la modalidad del seguro, que puede ser a terceros o a todo riesgo
b) Añadir a la clase Coche del ejercicio 1 un método de nombre imprimeCoche que imprima el modelo y el color del coche.
*/
package PACK1;

public class Coche {

    private String modelo, color, tipoCoche, modalidadSeguro, matricula;
    private boolean esMetalizado;
    private int anoFabricacion;

    public Coche(){//CONSTRUCTOR
    modelo="x";
    color="Verde";
    tipoCoche="DEPORTIVO";
    modalidadSeguro="Terceros";
    matricula="V-1111-AA";
    esMetalizado=false;
    anoFabricacion=9999;
}
    
    public void setModelo(String a) {
        modelo = a;
    }

    public void setColor(String a) {
        color = a;
    }

    public void setTipoCoche(String a) {
        tipoCoche = a;
    }

    public void setModalidadSeguro(String a) {
        modalidadSeguro = a;
    }

    public void setMatricula(String a) {
        matricula = a;
    }

    public void setEsMetalizado(boolean a) {
        esMetalizado = a;
    }

    public void setAnoFabricacion(int a) {
        anoFabricacion = a;
    }

    public void setCoche(String mod, String col, String tipoC, 
            String modalSegu, String matri, boolean esMetal, int anoFabri) {
        modelo = mod;
        color = col;
        tipoCoche = tipoC;
        modalidadSeguro = modalSegu;
        matricula = matri;
        esMetalizado = esMetal;
        anoFabricacion = anoFabri;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getTipoCoche() {
        return tipoCoche;
    }

    public String getModalidadSeguro() {
        return modalidadSeguro;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean getEsMetalizado() {
        return esMetalizado;
    }

    public int getanoFabricacion() {
        return anoFabricacion;
    }

    public void imprimeCoche() {
        System.out.println("********************************************");
        System.out.println("** Modelo: " + modelo);
        System.out.println("********************************************");
        System.out.println("** Color: " + color);
        System.out.println("** Tipo Coche: " + tipoCoche);
        System.out.println("** Modalidad Seguro: " + modalidadSeguro);
        System.out.println("** Matricula: " + matricula);
        if (esMetalizado) {
            System.out.println("** Metalizado: SI");
        } else {
            System.out.println("** Metalizado: NO");
        }
        System.out.println("** Año Fabricación: " + anoFabricacion);
        System.out.println("********************************************\n");
    }
}
