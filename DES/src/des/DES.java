
package des;

import generico.ConverHex;

/**
 *
 * @author Carlos G. Anguiano
 */
public class DES {
    
    private final int P1[] ={57,49,41,33,25,17,9,1,
                             58,50,42,34,26,18,10,2,
                             59,51,43,35,27,19,11,3,
                             60,52,44,36,63,55,47,39,
                             31,23,15,7,62,54,46,38,
                             30,22,14,6,61,53,45,37,
                             29,21,13,5,28,20,12,4};
    
    private final int P2[]={14, 17, 11, 24, 1, 5, 3, 28,
                            15, 6, 21, 10, 23, 19, 12, 4,
                            26, 8, 16, 7, 27, 20, 13, 2,
                            41, 52, 31, 37, 47, 55, 30, 40,
                            51, 45, 33, 48, 44, 49, 39, 56,
                            34, 53, 46, 42, 50, 36, 29, 32};
    
    private final int recorrimiento[]=
    {
      1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1  
    };
    
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
    
    public String permutedChoiceI(String binClave){
        String pc1 = "";
        for(int i =0; i<P1.length; i++){
            pc1 += binClave.charAt(P1[i]-1);
        }
        return pc1;
    }
    
    public String recorrimiento(String pc1, int lugares){
        String r1, r2, res = "";
        r1 = pc1.substring(0, pc1.length()/2);
        r2 = pc1.substring(pc1.length()/2);
        
        String rs1, rs2 = "";
        rs1 = r1.substring(0, lugares);
        r1 = r1.substring(lugares) + rs1;
        rs2 = r2.substring(0, lugares);
        r2 = r2.substring(lugares) + rs2;
        
        res = r1 + r2;
        return res;
        
    }
    
    private String permutedChoiceII(String recorri){
        String subclave = "";
        
        String r1 = recorri.substring(0, recorri.length()/2);
        String r2 = recorri.substring(recorri.length()/2);
        
        String izq = "", der = "";
        
        for(int i=0; i<P2.length; i++){
            subclave += recorri.charAt(P2[i]-1);
        }
        
        return subclave;
    }
}
