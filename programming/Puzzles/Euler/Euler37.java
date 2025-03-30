import java.util.*;
public class Euler37{
    public static void main(String[] args){
	int[] starts={2, 3, 5, 7};
	/**

3
7
31
33
37
37
333
	**/
        int sum=0;
	System.out.println(isReversedPrime("379"));
	for(int start : starts){
	    ArrayList<Integer> results=new ArrayList();	
	    findPrimes(start, results,new Integer[]{1, 3, 5, 7, 9});
	    //System.out.println(results);
	    for(int result : results){
		if(isReversedPrime(result+"")){
		    System.out.println(result);
		    sum+=result;
		}
	    }
	}
	System.out.println(sum);
	
	
	
    }
    public static boolean isReversedPrime(String num){
	for(int i=num.length()-1; i>=0; i--){
	    if(!isPrime(Integer.parseInt(num.substring(i, num.length())))) return false;
	}
	return true;
    }
     public static Boolean isPrime(int num){
	if(num<2){
	    return false;
	}
	for(int i=2; i<num; i++){
	    if(num%i==0) return false;
	}
	return true;
    }
    
    public static void findPrimes(int prefix, ArrayList<Integer> list, Integer[] primes){
	for(int prime : primes){
	    if(list.size()==100000000) return;
	    int num=Integer.parseInt(prefix+""+prime);
	    if(isPrime(num)){
		primes=new Integer[]{1, 3, 5, 7, 9};
			
		list.add(num);
		//	System.out.println(num);
		findPrimes(num, list, primes);
		
	    }
	    continue;
	}
    }
	


    /**	for(int i=0; i<3; i++){
	    	if(prefix >7 ) return;
	    prefix=prefix++;
	    System.out.println(i + " prefix="+prefix);
	    findPrimes(prefix, new ArrayList<Integer>());
	}
	**/
	
    
    public static Boolean isPalindrome(int num){
	String reversed=new StringBuilder(num+"").reverse().toString();
	return num==Integer.parseInt(reversed);
    }
}
