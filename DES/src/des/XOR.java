/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

/**
 *
 * @author Carlos G. Anguiano
 */
public class XOR {
    
    public String aplicarXOR(String cadena1, String cadena2){
        String xor = "";
        if(cadena1.length()!=cadena2.length()){
            System.out.println("Las cadenas en XOR no son del mismo tamaño!");
        }
        for(int i=0; i<cadena1.length(); i++){
            if(cadena1.charAt(i)=='0'
                    &&cadena2.charAt(i)=='1'
                    ||cadena1.charAt(i)=='1'
                    &&cadena2.charAt(i)=='0'){
               xor+="1";
            } else {
                xor+="0";
            }
        }
        return xor;
    }
    
}
