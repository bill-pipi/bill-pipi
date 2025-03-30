import java.util.*;
public class Euler3{
    public static void main(String[] args){
	ArrayList<Integer> possiblefactors=new ArrayList();
	Long num=600851475143L;
	int i=3;
	while(i<=(num)/i){
	    i+=2;
	    if(num%i==0 && isPrime(i)){
		//System.out.println(i);
		possiblefactors.add(i);
	    }
	}
        System.out.println(possiblefactors);
	System.out.println(isPrime(19));
    }
    public static Boolean isPrime(int num){
	if(num<2){
	    return true;
	}
	for(int i=2; i<num; i++){
	    if(num%i==0) return false;
	}
	return true;
    }
  
}
