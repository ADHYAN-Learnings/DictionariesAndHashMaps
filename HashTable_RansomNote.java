package org.adhyan.hackerrank.DictionariesAndHashMaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    
         magazine = magazine.stream().sorted().collect(Collectors.toList());
         note = note.stream().sorted().collect(Collectors.toList());
         
         System.out.println(magazine);
         System.out.println(note);
         
         int j=0;
         boolean valueExist = false;
         for(int i=0;i<note.size();i++) {
        	 valueExist = false;
        	 for(;j<magazine.size();j++) {
        		 if(note.get(i).equals(magazine.get(j))) {
        			 valueExist = true;
        		     break;
        		 }
        	 }
        	 j=j+1;
        	 if(!valueExist) {
        		 break;
        	 }
         }
         System.out.println(valueExist?"Yes":"No");  
    }
}

public class HashTable_RansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result1.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

