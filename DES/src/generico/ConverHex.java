/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.math.BigInteger;
//import java.util.HashMap;
//import java.util.Map;

/**
 *
 * @author Carlos G. Anguiano
 */

public class ConverHex {
    
    public String hexadecimalABinario(String hex){
        String value = new BigInteger(hex, 16).toString(2);
        return String.format("%64s", value).replace(" ", "0");
    }
}

/*
=======================================================
VERSIONES PASADAS
=======================================================

private final Map<Character, String> hexDic = new HashMap<Character, String>()
    {{
         put('0', "0000");
         put('1', "0001");
         put('2', "0010");
         put('3', "0011");
         put('4', "0100");
         put('5', "0101");
         put('6', "0110");
         put('7', "0111");
         put('8', "1000");
         put('9', "1001");
         put('a', "1010");
         put('b', "1011");
         put('c', "1100");
         put('d', "1101");
         put('e', "1110");
         put('f', "1111");
         put('A', "1010");
         put('B', "1011");
         put('C', "1100");
         put('D', "1101");
         put('E', "1110");
         put('F', "1111");
    }};
    
    public String hexadecimalABinario(String hex){
        String res="";
        for(char c: hex.toCharArray()){
            res += hexDic.get(c);
            //hexDic.containsKey(c);
        } 
        return res;
    }
*/
