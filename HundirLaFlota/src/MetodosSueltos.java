package com.mycompany.hundirlaflota.hundirlaflota;

public class MetodosSueltos {
	
	public static int generarNumerosAleatorios(int minimo, int maximo) {
		int num = (int) Math.floor(Math.random()*(maximo - minimo+1)+(minimo));
		return num;
	}
	
}
