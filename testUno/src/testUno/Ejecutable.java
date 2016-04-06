package testUno;

import java.util.Arrays;

import processing.core.PApplet;
import processing.serial.*;
//la retroalimentacion visual influye en la manera de servirse?
public class Ejecutable extends PApplet {
	private Serial puerto;
	private int pesas[];
	private int lineFeed = 4;
	private Food arroz, ensalada, carne;
	
	public void setup() {
		size(800, 600);
		pesas = new int[lineFeed];
		String nombrePuerto = Serial.list()[1];
		puerto = new Serial(this, nombrePuerto, 9600);
		arroz = new Food("arroz");
		ensalada = new Food("ensalada");
		carne = new Food("carne");
	}

	public void draw() {
		background(255);
		//bolita(200, 200);
		alimentos();
		if (puerto.available() > 0) {
			String mensaje = puerto.readStringUntil('\n');
			if (mensaje != null) {
				mensaje = mensaje.trim();
				String[] valores = split(mensaje, " ");
				for (int i = 0; i < valores.length; i++) {
					pesas[i] = Integer.parseInt(valores[i]);
				}
				System.out.println("Pesas:" + Arrays.toString(pesas));
			}
		}
	}
	private void alimentos(){
		arroz.Ejecutar(pesas[0]);
	}
	private void bolita(int x, int y) {
		fill(0);
		ellipseMode(CENTER);
		ellipse(x, y, pesas[0]/2, pesas[0]/2);
		ellipse(x+200, y, pesas[1]/2, pesas[1]/2);
	}
	public void mousePressed(){
		/*puerto.clear();
		puerto.stop();
		String nombrePuerto = Serial.list()[1];
		puerto = new Serial(this, nombrePuerto, 9600);	
		*/	
	}
	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "Ejecutable" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
