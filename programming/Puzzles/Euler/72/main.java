import java.util.HashMap;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.lang.Number;

public class main {


    public static boolean isPrime(int num){
        return num > 1 
          && IntStream.rangeClosed(2, (int) Math.sqrt(num))
          .noneMatch(n -> (num % n == 0));
      }


    public static void compileFactors(int[] num, int f, Set<Integer> factors, int threshold) {

        switch (num[0] % f) {

            case 0:
                
                factors.add(f);
                num[0] = num[0] / f;
                compileFactors(num, f, factors, threshold);
                return;
        
            default:

                if(num[0] < threshold) break;
                
                else compileFactors(num, f+1, factors, threshold);  

        }
        return;
    }


    public static ArrayList<Set<Integer>> listFactors(int limit){

        ArrayList<Set<Integer>> list = new ArrayList() {{ add(new HashSet()); add(new HashSet()); }};

        for(int i = 2; i <= limit; i++){
            
            Set<Integer> factors = new HashSet<Integer>(); 
            int[] n = new int[] {i};

            if( !isPrime(n[0]) ){

                compileFactors(n , 2 , factors, n[0]-1);
                if(n[0] != 1) factors.addAll(list.get((n[0])));
                
            }
            else factors.add(n[0]);

            list.add(factors);

        
        }

        return list;

    }



    public static void main(String[] args){
      
        int limit = 1000000;
        Long count = 0L;
        ArrayList<Set<Integer>> list = listFactors(limit);
        
        for(int i = 2; i < list.size(); i++){

            Long n = Long.valueOf(i);
            
            for(int f : list.get(i)) n = n * Long.valueOf(f - 1) / Long.valueOf(f);
            
            count += n;





        System.out.println("Final Answer : " + count);


    }

}