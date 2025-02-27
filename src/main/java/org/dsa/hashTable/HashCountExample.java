package org.dsa.hashTable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashCountExample {
    public static void main(String[] args) {
        String path = "src/main/resources/colourdata.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            HashMap<String, Integer> map = new HashMap<>();
            String lines;
            while ((lines=br.readLine())!=null){
                String []words = lines.split("\\s+");
                for(String word : words){
                    map.put(word, map.getOrDefault(word,0)+1);
                }
            }
            map.forEach((word, count)-> System.out.println(word+" = "+count));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
