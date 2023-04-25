/*
 * 4.	Desarrollar una clase llamada Practica_1 que en su método main:

•	Cree e inicialice dos objetos de la clase Punto y muestre la distancia entre ambos.
•	Cree un objeto de la clase Circulo y muestre su área, perímetro y distancia a uno de los dos puntos creados al comienzo.
•	Cree un objeto de la clase Triangulo y muestre su área, perímetro y distancia a un nuevo punto.

Nota 1: No seremos rigurosos con las matemáticas y supondremos que los triángulos siempre son rectángulos.

 */
package Practica1;

// clase principal
public class Practica1{
	public static void main(String[] args){
		// Punto
		Punto a = new Punto();
		Punto b = new Punto(1.1,42.3);
		double distancia = a.calcularDistanciaDesde(b);
		System.out.println("La distancia es: " + distancia);

		// Círculo
		Circulo c = new Circulo(a,5.0);
		System.out.println("El área es: " + c.calcularArea());
		System.out.println("El perímetro es:" + c.calcularPerimetro());
		System.out.println("La distancia es:" + b.calcularDistanciaDesde(c.getCentro()));

		// Triángulo
		Triangulo t = new Triangulo(a,b,new Punto(7.3,1.9));
		System.out.println("El área es: " + t.calcularArea());
		System.out.println("El perímetro es:" + t.calcularPerimetro());
		System.out.println("La distancia es:" + t.calcularDistanciaDesde(new 			Punto(8.0,9.0)));
	}
}
