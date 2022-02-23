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
public class HundirFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sn = new Scanner(System.in);
        
        
        System.out.println("Introduce el tamaño del tablero: ");
        int tamanio = Integer.parseInt(sn.next());
        
        System.out.println("Introduce tu nombre: ");
        String nombre = sn.next();
        
        

        
        Tablero t = new Tablero(nombre, tamanio)
    }
    
}
