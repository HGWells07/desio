/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import des.DES;
import generico.Binario;

/**
 *
 * @author OSVALDO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DES d = new DES();
        d.generarLlaves("133457799bbcdff1");
    }
    
}
