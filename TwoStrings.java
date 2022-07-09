package org.adhyan.hackerrank.DictionariesAndHashMaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
    	
    	Set<Character> data1 = new HashSet<>();
    	Set<Character> data2 = new HashSet<>();
    	IntStream.range(0, s1.length()).forEach(i->data1.add(s1.charAt(i)));
    	IntStream.range(0, s2.length()).forEach(i->data2.add(s2.charAt(i)));
    	
    	data1.retainAll(data2);
    	
    	System.out.println(data1);
      
       return data1.size()>0?"YES":"NO";
    }

}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();
                
                String result = Result.twoStrings(s1, s2);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

