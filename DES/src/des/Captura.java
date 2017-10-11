/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

import generico.ConverHex;
import java.util.Scanner;

/**
 *
 * @author Carlos G. Anguiano
 */
public class Captura {
    
    private String clave;
    private String dato;
    private String pi;
    private String[] llaves = new String[16];
    private Permutar p = new Permutar();
    private ConverHex b = new ConverHex();
    private XOR x = new XOR();
    private SCaja s = new SCaja();
    
    public void capturar(){
        Scanner read = new Scanner(System.in);
        
        System.out.print("Ingrese un dato: ");
        this.dato = read.next();
        System.out.print("Ingrese una clave: ");
        this.clave = read.next();
        
        System.out.println("SUBCLAVES");
        generarLlaves(clave);
        System.out.println("\n\n");
        
        System.out.println("C'S");
        pi = b.hexadecimalABinario(dato);
        this.dato = p.initialPermutation(pi);
        for(int i = 0; i<16; i++){
            rondaDES(i);
        }
        System.out.println("\n\n");
        
        this.dato = this.dato.substring(this.dato.length()/2) + this.dato.substring(0, this.dato.length()/2);
        this.dato = p.finalPermutation(this.dato);
        String res = "";
        int index = 0;
        for(int i = 0; i<16; i++){
            res += b.binarioAHexadecimal(this.dato.substring(index, index+4));
            index += 4;
        }
        
        System.out.println("Cifrado: " + res);
        
    }
    
    public void generarLlaves(String clave){
        //Obteniendo clave en binario
        String bin = b.hexadecimalABinario(clave);
        
        Llaves l = new Llaves();
        //System.out.println(bin);

        String pc1 = p.permutedChoiceI(bin);
        //System.out.println(pc1);
        String recorri, subclave;
        
        for(int i = 0; i<16; i++){
            recorri = l.recorrimiento(pc1, l.recorrimiento[i]);
            //System.out.println(recorri);
        
            subclave = p.permutedChoiceII(recorri);
            
            pc1 = recorri;
            this.llaves[i] = subclave;
            System.out.println("Subclave " + i + ": " + subclave);
        }
        
    }
    
    public void rondaDES(int ronda){
        String left = this.dato.substring(0, this.dato.length()/2);
        String right = this.dato.substring(this.dato.length()/2);
        String e = p.expantion(right);
        e = x.aplicarXOR(e, this.llaves[ronda]);
        e = s.sCaja(e);
        e = p.permutationP(e);
        e = x.aplicarXOR(e, left);
        this.dato = right + e;
        System.out.println("C" + (ronda) + ": = " + this.dato);
    }
    
    
}

/*
    public String generarLlaves(String clave){
        String llaves = "";
        //Obteniendo clave en binario
        ConverHex b = new ConverHex();
        String bin = b.hexadecimalABinario(clave);
        //System.out.println(bin);
        
        String pc1 = permutedChoiceI(bin);
        //System.out.println(pc1);
        String recorri, subclave;
        
        for(int i = 0; i<16; i++){
            recorri = recorrimiento(pc1, recorrimiento[i]);
        //System.out.println(recorri);
        
            subclave = permutedChoiceII(recorri);
            System.out.println("Subclave [" + (i+1) + "]" + subclave);
            
            pc1 = recorri;
        }
        
        return llaves;
    }
*/
