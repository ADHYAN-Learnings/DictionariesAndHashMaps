package org.adhyan.hackerrank.DictionariesAndHashMaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        
     
    Map<Long , Long > left = new HashMap<>();
    Map<Long , Long > right = new HashMap<>();
    
    for(Long item : arr) {
	   right.put(item, right.getOrDefault(item, 0l)+1);
    }
    
    for(Map.Entry<Long, Long> data : right.entrySet() ) {
    	System.out.println(data.getKey()+"   :  "+data.getValue());
    }
    
  long count =  arr.stream().mapToLong(j->{
    	long count1 = 0;
    	long count2 = 0;
    	
    	right.put(j, right.getOrDefault(j, 0l)-1);
    	
    
    	if(left.containsKey(j/r) && j%r == 0) {
    		count1 = left.get(j/r);
    	}
    	
    
        if(right.containsKey(j*r) && j%r == 0) {
    		count2 = right.get(j*r); 
    	}
    	
    	left.put(j, left.getOrDefault(j, 0l)+1);
    	return count1*count2;
    }).sum();
    
     
     return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println("ans : "+ans);

        bufferedReader.close();
    }
}

