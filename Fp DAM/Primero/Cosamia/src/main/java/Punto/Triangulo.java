/*
 *3.	Desarrollar una clase llamada Triangulo que:

•	Tenga tres atributos prívate de tipo Punto.
•	Tenga un constructor con tres parámetros de tipo Punto que inicialice los dos atributos.
•	Tenga un constructos por defecto (sin parámetros) que inicialice los tres atributos al valor que se quiera.
•	Tenga un constructor con seis parámetros de tipo double que inicialice los tres atributos.
•	Tenga un getvalor para cada uno de los atributos.
•	Tenga un método calcularDistanciaDesde que recibe un parámetro de tipo Punto y que devuelve un doublé.
* •	Tenga un método calcularArea que no recibe ningún parámetro y devuelve un double.
•	Tenga un método calcularPerimetro que no recibe ningún parámetro y devuelve un double.


 */
package Practica1;


//Triángulo
public class Triangulo{
	//Atributos
	private Punto p1, p2, p3;

	//Constructores
	public Triangulo(){
		p1 = new Punto();
		p2 = new Punto(1.2,10.7);
		p3 = new Punto(5.5,5.5);
	}

	public Triangulo(Punto param1, Punto param2, Punto param3){
		p1 = param1;
		p2 = param2;
		p3 = param3;
	}
	public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3){
		p1 = new Punto(x1,y1);
		p2 = new Punto(x2,y2);
		p3 = new Punto(x3,y3);
	}


	//Getvalores
	public Punto getP1(){
		return p1;
	}
	public Punto getP2(){
		return p2;
	}
	public Punto getP3(){
		return p3;
	}

	//Resto de Métodos
	public double calcularArea(){
		double base = p1.calcularDistanciaDesde(p2);
		double altura = p1.calcularDistanciaDesde(p3);//aproximación: aquí estoy 			suponiendo triangulo rectángulo
		return base * altura / 2;
	}
	public double calcularPerimetro(){
		double lado1 = p1.calcularDistanciaDesde(p2);
		double lado2 = p2.calcularDistanciaDesde(p3);
		double lado3 = p3.calcularDistanciaDesde(p1);
		return lado1 + lado2 + lado3;
	}
	public double calcularDistanciaDesde(Punto param){
		return p1.calcularDistanciaDesde(param);
	}
}
