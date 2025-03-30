import java.util.*;
public class Euler58{
    public static void main(String[] args){
	int primes=3;
	int side=2;
	int c=9;
	
	while( ((double)primes)/(2*side+1) > 0.10){
	    side += 2;
	    for(int i = 0; i < 3; i++){
		c += side;
		if(isPrime(c)) primes++;
	    }
	    c+= side;
	}
	System.out.println(side);
	
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
