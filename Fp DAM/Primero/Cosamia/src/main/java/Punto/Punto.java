/*
 * 1.	Desarrollar una clase llamada Punto que:

•	Tenga dos atributos prívate de tipo double.
•	Tenga un constructor con dos parámetros de tipo double que inicialice los dos atributos.
•	Tenga un constructor por defecto (sin parámetros) que inicialice los dos atributos al valor que se quiera.
•	Tenga un getvalor para cada uno de los atributos.
•	Tenga un método calcularDistanciaDesde que recibe un parámetro de tipo Punto y que devuelve un double

 */
package Practica1;

//Punto
public class Punto{
	//Atributos
	private double x ;
	private double y;

	//Constructores
	public Punto(){
		x = 0.0;
		y = 0.0;
	}
	public Punto(double param1, double param2){
		x = param1;
		y = param2;
	}

	//Getvalores
	public double getX(){
		return x;
	}
	public double getY(){	
		return y;
	}

	//Resto de Métodos
	public double calcularDistanciaDesde(Punto param){
		double cateto1 = x - param.getX();
		double cateto2 = y - param.getY();
		double hipotenusa = Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
		return hipotenusa;
	}
}


