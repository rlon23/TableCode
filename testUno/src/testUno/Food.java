package testUno;

public class Food {
	private float peso;
	private String comida;

	public Food(String tipoComida) {
		comida = tipoComida;
	}

	public void Ejecutar(float gramos) {
		peso = gramos;
		switch (comida) {
		case "arroz":
			//System.out.println(comida +": " + peso);
			break;
		case "ensalada":
			//System.out.println(comida + peso);
			break;
		case "carne":
			//System.out.println(comida + peso);
			break;
		}
	}
}
