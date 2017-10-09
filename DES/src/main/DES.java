/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import des.Llaves;
import des.Permutar;
import des.XOR;
import java.util.Scanner;

/**
 *
 * @author Carlos G. Anguiano
 */
public class DES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Llaves d = new Llaves();
        
        System.out.println("Ingrese una clave: ");
        Scanner s = new Scanner(System.in);
        String clave = s.next();
        d.generarLlaves(clave);
    }
    
}
