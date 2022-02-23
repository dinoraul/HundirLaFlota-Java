/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirflota;

/**
 *
 * @author Usuario 1
 */
public class Tablero {
    private String nombre;
    private int tamanio;

    public Tablero(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }
    
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
                System.out.println("*");
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
    }
}
