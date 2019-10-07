/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contwordstxt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author Daniel
 */
public class ContWordsTxt {

    HashMap<String, Integer> hashWords = new HashMap<String, Integer>();
    
    
    public String readBook() throws FileNotFoundException, IOException{// The name of the file to open
      String book = "";
       try {
      FileReader arq = new FileReader("gameofthrones.txt");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      while (linha != null) {
        //System.out.printf("%s\n", linha);
        book += linha +"\n";
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
  return book;
}
                 
    public void numberCont(String txt){
      
        for(String aux:txt.toLowerCase().replaceAll("(?m)^[ \t]*\r?\n", "").replaceAll("[^a-zA-Z ]", " ").split(" ")){
            if(aux.isEmpty()){
                continue;
            }if(hashWords.containsKey(aux)){
                hashWords.put(aux,hashWords.get(aux)+1);
            }else{
                hashWords.put(aux, 1);
            }
        }
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(hashWords);
        
        for(Map.Entry<String, Integer> aux : sortedMap.entrySet()){
            System.out.println(aux.getKey() + "[" + aux.getValue()+"]");
            
        }
        
    
    
    
    }
    
   
    public static void main(String[] args) throws IOException {
            
            ContWordsTxt c = new ContWordsTxt();
            String texto = c.readBook();
            c.numberCont(texto);
          //  System.out.println(c.readBook());
    }

   
    
}
