package com.mycompany.hundirlaflota.hundirlaflota;

import java.awt.Point;
import java.util.Date;



public class Tablero {

    private Barco[][] tablero;
    private int[][] tablerMostrar;
    private Date tiempoInicio;

    private final int CRUCERO = 0;
    private final int DESTRUCTOR = 1;
    private final int FRAGATA = 2;
    private final int PORTAAVION = 3;

    private final int ARRIBA = 0;
    private final int DER = 1;
    private final int ABAJO = 2;
    private final int IZQ = 3;

    private final int NO_EXPLORADO = 1;
    private final int BARCO = 2;
    private final int AGUA = 3;

    private int[] numeroBacos;
    private String nombre;
    private int tamanio;
    
    /**
     * Nombre del jugador
     * @param nombre 
     * @param tamanio 
     */
    
    public Tablero(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        crearTablero();
       // generarNumBarcos();
       generarBarcos();
        this.tiempoInicio = new Date();
        
        
    }
    
    /**
     * Crear el Tablero
     */
    private void crearTablero() {
        /*MetodosSueltos.generarNumerosAleatorios(10, 20);*/
        this.tablero = new Barco[this.tamanio][this.tamanio];
        this.tablerMostrar = new int[this.tamanio][this.tamanio];
    }
    
    /**
     * Crear el numeros de barcos
     */
    private void generarNumBarcos() {
        this.numeroBacos = new int[4];
        int num;
        for (int i = 0; i < this.numeroBacos.length; i++) {
            num = MetodosSueltos.generarNumerosAleatorios(1, 3);
            numeroBacos[i] = num;
        }
    }
    
    /**
     * En este mÃ©todo genera los barcos en la posicion x e y aleatorios, y direccion
     */
   
    private void generarBarcos() {
        //int a=0;
        Barco b = null;
        int x, y, direccion, direccionX = 0, direccionY = 0, posXFinal = 0, posYFinal = 0, longitud;
        boolean posCorrecta;

        for (int i = 0; i < this.numeroBacos.length; i++) {
            for(int j = 0; j < this.numeroBacos[i]; j++){
                switch (i) {
                    case CRUCERO:
                        b = new Crucero();
                        break;
                    case DESTRUCTOR:
                        b = new Destructor();
                        break;
                    case FRAGATA:
                        b = new Fragata();
                        break;
                    case PORTAAVION:
                        b = new Portaavion();
                        break;
                }
                longitud = b.getLongitud();

                do {
                    //System.out.println(" numero : "+ (a++));
                  
                    posCorrecta = true;
                    
                    x = MetodosSueltos.generarNumerosAleatorios(0, this.tamanio - 1);
                    y = MetodosSueltos.generarNumerosAleatorios(0, this.tamanio - 1);
                    direccion = MetodosSueltos.generarNumerosAleatorios(0, 3);
                   if(posCorrecta==true)
                   {
                       break;
                   }
                    switch (direccion) {
                        case ARRIBA:
                            direccionX = -1;
                            direccionY = 0;
                            break;
                        case DER:
                            direccionX = 0;
                            direccionY = 1;
                            break;
                        case ABAJO:
                            direccionX = 1;
                            direccionY = 0;
                            break;
                        case IZQ:
                            direccionX = 0;
                            direccionY = -1;
                            break;
                    }
                    posXFinal = x + (longitud * direccionX);
                    posYFinal = y + (longitud * direccionY);

                    if (posXFinal > 0 && posXFinal < this.tamanio- 1 && posYFinal > 0 && posYFinal < this.tamanio) {
                        //k es x 
                        //m es y
                        for (int k = x, m = y; (k != posXFinal || m != posYFinal) && posCorrecta; k += direccionX, m += direccionY) {
                            if (this.tablero[k][m] != null) {
                                posCorrecta = false;
                                
                            }
                        }
                    } else {
                        posCorrecta = false;
                    }

                } while (!posCorrecta);
                Point[] coordenadas = new Point[b.getLongitud()];
                for (int k = x, m = y, ind = 0;
                        (k != posXFinal || m != posYFinal) && posCorrecta;
                        k += direccionX, m += direccionY, ind++) {
                    this.tablero[k][m] = b;
                    coordenadas[ind] = new Point(k, m);
                }
                b.setCoordenadas(coordenadas);

                System.out.println("El barco se ha generado entre [" + x + "," + y + "] y [" + posXFinal + "," + posYFinal + "]");
            }
        }
    }
    
    /**
     * En este mÃ©todo se enseÃ±a el tiempo jugado
     */
    public void mostrarTiempo(){
        Date despues = new Date();
        long segundos = (despues.getTime() - this.tiempoInicio.getTime()) / 1000;
        int minutos =(int) segundos / 60;
        int segRestantes =(int) segundos % 60;
        System.out.print("Tiempo de juego: ");
        
        if(minutos < 10){
            System.out.print("0"+minutos);
        }else{
            System.out.print(minutos);
        }
        System.out.print(":");
        if(segRestantes < 10){
           System.out.println("0"+segRestantes);
        }else{
            System.out.println(segRestantes);
        }
    }
    
    /**
     * En este mÃ©todo se comprueba si el disparo toca el agua o al barco
     * @param x columna
     * @param y fila
     */
    public void disparar(int x, int y) {
        if (x >= 0 && x < this.tablero.length && y >= 0 && y < this.tablerMostrar.length) {
            if (this.tablero[x][y] != null) {
                this.tablerMostrar[x][y] = this.BARCO;
                this.tablero[x][y].parteDanada(x,y);
                if (this.tablero[x][y].hundido()) {
                    System.out.println("Hundido");
                    
                    Barco b = this.tablero[x][y];
                    
                    if(b instanceof Crucero){
                        this.numeroBacos[this.CRUCERO]--;
                    }else if(b instanceof Destructor){
                        this.numeroBacos[this.DESTRUCTOR]--;
                    }else if(b instanceof Fragata){
                        this.numeroBacos[this.FRAGATA]--;
                    }else{
                        this.numeroBacos[this.PORTAAVION]--;
                    }
                    
                }else{
                    System.out.println("Tocado");
                }
                
            } else {
                this.tablerMostrar[x][y] = this.AGUA;
                System.out.println("No hay barcos en la casilla, !HAY AGUA");
                this.indicarBarco(x, y);
            }
        }else{
            System.out.println("Te has salido del lÃ­mite");
        }
    }
    
    /**
     * En este mÃ©todo mira si no hay barcos hundidos, si todos los barcos estan 
     * hundidos devuelve true pero si hay algun barco no hundido devuelve false
     * @return boolean 
     */
    public boolean finJuego(){
        for(int i = 0; i < this.numeroBacos.length; i++){
            if(this.numeroBacos[i] > 0){
                return false;
            }
        }
        return true;
    }
    
    /**
     * En este mÃ©todo muestra el numero de barcos que no estan hundidos
     */
    public void mostrarNumBarcos() {
        System.out.println("Quedan: " + this.numeroBacos[this.PORTAAVION] + " Portaaviones, " 
                + this.numeroBacos[this.CRUCERO] + " Cruceros, "
                + this.numeroBacos[this.DESTRUCTOR] + " Destructores y "
                + this.numeroBacos[this.FRAGATA] + " Frogatas.");
    }
    
    /**
     * Cada vez que disparamos y damos al agua, se mira si hay un barco cerca del 
     * disparo
     * @param x columna
     * @param y fila
     */
    public void indicarBarco(int x, int y){
        boolean barcoEncontrado = false;
        for(int i = x-1; i <= (x+1); i++){
            for(int j = y-1; j <= (y+1); j++){
                if(i>0 && i<this.tablero.length && j>0 && j<this.tablero.length 
                        && i!=x && j!=y && this.tablero[i][j]!=null){
                    System.out.println("Hay un barco cerca");
                    barcoEncontrado = true;
                }
            }
        }
        if(!barcoEncontrado){
            System.out.println("NingÃºn barco cerca");
        }
    }
    
    /**
     * En este mÃ©todo muestra el tablero y la ubicacion del agua y los barcos
     */
    public void mostrarTableroTest(){
        for (int i = 0; i < this.tablerMostrar.length; i++) {
            for (int j = 0; j < this.tablerMostrar[0].length; j++) {
                if(this.tablero[i][j] != null){
                    System.out.print("B ");
                }else{
                    System.out.print("N ");
                } 
            }
            System.out.println(" ");
        }
    }
    
    /**
     * En este mÃ©todo se muestra el tablero sin enseÃ±ar la ubicacion de los barcos
     */
    
    public void mostrarTablero() {
        
        //cabecera
        System.out.printf("%4s"," ");
        for (int i = 0; i < (tamanio); i++) {
     
            System.out.printf("%d ",i);
            if(i==(tamanio)-1){
            
           System.out.printf("\n %3s"," ");
            }
            
        }
         for (int i = 0; i < (tamanio); i++) {
         System.out.printf("%s ","-");
          if(i==(tamanio)-1){
            
           System.out.printf("\n");
            }
         
         }

        //cuerpo
        for (int i = 0; i <tamanio; i++) {
            System.out.printf( "%d %s ",i,"|");
            for (int j = 0; j < tamanio; j++) {
                switch (this.tablerMostrar[i][j]) {
                    case AGUA:
                        System.out.print("* ");
                        break;
                    case BARCO:
                        System.out.print("B ");
                        break;
                    default:
                        System.out.print("  ");
                        break;
                }
            }
            System.out.printf( "%s%d","|",i);
            System.out.println(" ");
        }
        //cierre
        System.out.printf("%4s", " ");
      
         for (int i = 0; i < (tamanio); i++) {
         System.out.printf("%s ","-");
          if(i==(tamanio)-1){
            
           System.out.printf("\n");
            }
         
         }
         System.out.printf(" %3s"," ");
           for (int i = 0; i < (tamanio); i++) {
     
            System.out.printf("%d ",i);
           
        }
         
          System.out.println("");
        
        
        System.out.println("Jugador/a: "+nombre);
        this.mostrarTiempo();
        this.mostrarNumBarcos();
    }

}
