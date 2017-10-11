
package des;

import generico.ConverHex;
import des.Permutar;

/**
 *
 * @author Carlos G. Anguiano
 */
public class Llaves {
    
    Permutar p = new Permutar();
    
    public final int recorrimiento[]=
    {
      1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1  
    };
    
    public String generarLlaves(String clave){
        String llaves = "";
        //Obteniendo clave en binario
        ConverHex b = new ConverHex();
        String bin = b.hexadecimalABinario(clave);
        //System.out.println(bin);
        
        String pc1 = p.permutedChoiceI(bin);
        //System.out.println(pc1);
        String recorri, subclave;
        
        for(int i = 0; i<16; i++){
            recorri = recorrimiento(pc1, recorrimiento[i]);
        //System.out.println(recorri);
        
            subclave = p.permutedChoiceII(recorri);
            System.out.println("Subclave [" + (i+1) + "]" + subclave);
            
            pc1 = recorri;
        }
        
        return llaves;
    }
    
    public String recorrimiento(String pc1, int lugares){
        String r1, r2, res;
        r1 = pc1.substring(0, pc1.length()/2);
        r2 = pc1.substring(pc1.length()/2);
        
        String rs1, rs2;
        rs1 = r1.substring(0, lugares);
        r1 = r1.substring(lugares) + rs1;
        rs2 = r2.substring(0, lugares);
        r2 = r2.substring(lugares) + rs2;
        
        res = r1 + r2;
        return res;
        
    }
 
}
