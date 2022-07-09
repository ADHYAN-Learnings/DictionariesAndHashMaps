package org.adhyan.hackerrank.DictionariesAndHashMaps;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

class Result3 {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    	int length = s.length();
    	
    	
         long count =  IntStream.range(1, length).map(i->{
    	 List<String> subStringData = new ArrayList<String>();
    	   IntStream.range(0, length).filter(j->(i+j)<=length).forEach(j->subStringData.add(s.substring(j, i+j)));
    	   int size = subStringData.size();
    	  long total = IntStream.range(0, size).flatMap(k->IntStream.range(k+1, size).filter(l->{
    	  char[] check1 = subStringData.get(k).toCharArray();
   		  char[] check2 = subStringData.get(l).toCharArray();
   		    Arrays.sort(check1);
   		    Arrays.sort(check2);
    		   return Arrays.equals(check1, check2);
    	  })).count();
    	   
    	   return (int)total;
    	  }).sum();
    	 return (int)count;
    }
}

public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result3.sherlockAndAnagrams(s);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

