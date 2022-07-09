package org.adhyan.hackerrank.DictionariesAndHashMaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

      //  List<List<Integer>> queries = new ArrayList<>();
        Map<Integer,Integer> query = new HashMap<Integer,Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[q+1];
        IntStream.range(0, q).forEach(i -> {
            try {
                String[] dataSplitter = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                
                int data1 = Integer.parseInt(dataSplitter[0]);
                int data2 = Integer.parseInt(dataSplitter[1]);
                
               
                if(data1 == 1) {
                  int frequency = query.getOrDefault(data2, 0);	
                  query.put(data2, frequency+1);
                  count[frequency]--;
                  count[frequency+1]++;
                }
                
                if(data1 == 2 && query.get(data2) !=null) {
                	int frequency = query.get(data2);
                	
                	  if(frequency > 1) {
                	   query.put(data2, query.get(data2)-1);
                	  } else {
                		  query.remove(data2);
                	  }
                	  count[frequency-1]++;
                	  count[frequency]--;
                }
                
                if(data1 == 3) {
                	
                	ans.add(count.length<data2?0:count[data2]>0?1:0);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
       System.out.println(ans);

        bufferedReader.close();
    }
}
