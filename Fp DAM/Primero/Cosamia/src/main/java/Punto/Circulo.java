/*
 *
2.	Desarrollar una clase llamada Circulo que:

•	Tenga dos atributos prívate de tipo Punto y double.
•	Tenga un constructor con dos parámetros de tipo Punto y double que inicialice los dos atributos.
•	Tenga un constructor por defecto (sin parámetros) que inicialice los dos atributos al valor que se quiera.
•	Tenga un constructor con tres parámetros de tipo double que inicialice los dos atributos.
•	Tenga un getvalor para cada uno de los atributos.
•	Tenga un método calcularDistanciaDesde que recibe un parámetro de tipo Punto y que devuelve un double.
•	Tenga un método calcularArea que no recibe ningún parámetro y devuelve un double.
•	Tenga un método calcularPeímetro que no recibe ningún parámetro y devuelve un double.

 */
package Practica1;

//Círculo
public class Circulo{
	//Atributos
	private Punto centro ;
	private double radio ;

	//Constructores
	public Circulo(){
		centro = new Punto();
		radio = 3.1;
	}

	public Circulo(Punto param1, double param2){
		centro = param1;
		radio = param2;
	}
	public Circulo(double param1, double param2, double param3){
		centro = new Punto(param1, param2);
		radio = param3;
	}

	//Getvalores
	public Punto getCentro(){
		return centro;
	}
	public double getRadio(){
		return radio;
	}

	//Resto de Métodos
	public double calcularArea(){
		return Math.PI * radio * radio;
	}
	public double calcularPerimetro(){
		return 2 * Math.PI * radio;
	}
	public double calcularDistanciaDesde(Punto param){
		return centro.calcularDistanciaDesde(param);
	}
}

