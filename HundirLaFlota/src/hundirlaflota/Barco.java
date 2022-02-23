package hundirlaflota;

import java.awt.Point;

public class Barco {
	
	private int longitud;
	private Point[] coordenadas;
        private boolean[] partesDanadas;
	
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
	
        public void parteDanada(int x, int y){
            for(int i = 0; i < this.coordenadas.length; i++){
                if(this.coordenadas[i].x == x && this.coordenadas[i].y == y){
                    this.partesDanadas[i] = true;
                }
            }
            
        }
        
	public boolean hundido() {
            for(int i = 0; i<this.partesDanadas.length; i++){
                if(!this.partesDanadas[i]){
                    return false;
                }
            }
            return true;
	}
}
