import java.util.ArrayList;
import java.util.stream.*;
import java.util.Arrays;



public class main{  
  

  public static boolean isPrime(int num){
    return num > 1 
      && IntStream.rangeClosed(2, (int) Math.sqrt(num))
      .noneMatch(n -> (num % n == 0));
  }


  public static int sum(int[] a, int from, int to){

    try {
      return IntStream.of(Arrays.copyOfRange(a, from, to)).sum();
    } 
    catch (Exception e) { return 0; }

  }


  public static int sum(int[] a, int from){
    return sum(a, from, a.length);
  }
  

  public static void main(String[] args){
    

    
    ArrayList combinations = new ArrayList<int[]> () {
      {
        add(new int[] { 0 } );  //0 is not a prime
        add(new int[] { 0 } );  //1 is not a prime
        add(new int[] { 1 } );  //2 is a prime
        add(new int[] { 1 } );  //3 is a prime
      }
    };







    int numCombo = 0;

    for(int n = 4; numCombo < 5000; n++){
      
      int[] log = new int[(int) n/2];
      log[0] = (isPrime(n) ? 1 : 0);

      for(int a = 2; a <= (int) n/2; a++){

        if(isPrime(a)){

          int[] rem = (int[]) combinations.get(n-a);
          log[a-1] = rem[0] + sum(rem,a-1);
        
        }
      }

      combinations.add(log);
      numCombo = sum(log, 0);
      System.out.println(n + " : # Prime Combinations =  " + numCombo);

    }

  }
  
}
