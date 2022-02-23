package com.mycompany.hundirlaflota.hundirlaflota;

import java.awt.Point;
import java.util.Arrays;

public class Barco {
	
	private int longitud;
	private Point[] coordenadas;
        private boolean[] partesDanadas;
	
        /**
         * En el contructor pasas el tamaÃ±o del barco
         * En el constructor se inicializa el array coordenadas y partesDanadas con el tamaÃ±o posado 
         * como pramitro
         * @param longitud 
         */
	public Barco(int longitud) {
            this.longitud = longitud;
            this.coordenadas = new Point[longitud];
            this.partesDanadas = new boolean[longitud];
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public Point[] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Point[] coordenadas) {
		this.coordenadas = coordenadas;
	}
        
	/**
         * En este metodo se comprueba si la columna y fila tecladas concuerda con 
         * las coordenadas x e y del tablero y si es asÃ­ esa parteDanadas esta daÃ±ado o no
         * @param x column 
         * @param y fila
         */
        public void parteDanada(int x, int y){
            for(int i = 0; i < this.coordenadas.length; i++){
                if(this.coordenadas[i].x == x && this.coordenadas[i].y == y){
                    this.partesDanadas[i] = true;
                }
            }
            
        }
        
        /**
         * En este metodo comprueba si todas las partesDanadas estan en true y si es asi
         * significa que esta hundido 
         * @return boolean
         */
	public boolean hundido() {
            for(int i = 0; i<this.partesDanadas.length; i++){
                if(!this.partesDanadas[i]){
                    return false;
                }
            }
            return true;
	}
     
}
