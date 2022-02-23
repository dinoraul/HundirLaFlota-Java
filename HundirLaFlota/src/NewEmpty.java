
package com.mycompany.hundirlaflota.hundirlaflota;

import java.util.Scanner;

public class NewEmpty {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduce el tamaño del tablero: ");
       int tamanio = Integer.parseInt(sn.next());
        
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
                System.out.print("* ");
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
        
    }
    
}