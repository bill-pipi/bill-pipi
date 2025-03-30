public class Euler50{
    public static void main(String[] args){
	int sum=0;
	int largest=0;
	for(int i=1; i<1000000000000000000l; i+=3){
	    if(isPrime(i)) sum+=i;
	    if(isPrime(sum)) System.out.println(sum);
	    if(sum>1000000) break;
	}
	//System.out.println(sum);
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
