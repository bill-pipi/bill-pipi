import java.math.*;
public class Euler53{

    public static void main(String[] args){
	int count=0;
	for(int n=1; n<=100; n++){
	    for(int r=1; r<n; r++){
		if(factorial(BigInteger.valueOf(n)).divide(factorial(BigInteger.valueOf(r)).multiply(BigInteger.valueOf(n-r))).compareTo(BigInteger.valueOf(1000000))==1) count++;
	    }
	}
	System.out.println(count);
    }
    public static BigInteger factorial(BigInteger n){    
	if (n.compareTo(BigInteger.valueOf(0))==0) return BigInteger.valueOf(1);    
	return(n.multiply(factorial(n.subtract(BigInteger.valueOf(1)))));    
    }    
}

