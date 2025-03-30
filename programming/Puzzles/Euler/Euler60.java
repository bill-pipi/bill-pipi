import java.util.*; 
public class Euler60{
    public static void main(String[] args){
	new Euler60().test();
	
    }
    public void test(){
	ArrayList<Integer>primesList=new ArrayList();
        boolean isTrue=true;
	int limit=3000;
	int primes=0;
	int i=1;
	while(isTrue){
	    i++;
	    if(isPrime(i)){
		primesList.add((Integer)i);
		primes++;
	    }
	    if(primes==limit) isTrue=false;
	}
	int size = primesList.size();
	for(int i1 = 0; i1 <  size; i1++){
	    int prime1 = primesList.get(i1);
	    for(int i2 = i1+1; i2< size; i2++){
		int prime2 = primesList.get(i2);
		if(!check(prime1, prime2))continue;
		for(int i3 = i2+1; i3< size; i3++){
		    int prime3 = primesList.get(i3);
		    if(!check(prime1, prime3) || !check(prime2, prime3))continue;
		    for(int i4=i3+1; i4<size; i4++){
			int prime4=primesList.get(i4);
			if(!check(prime1, prime4) || !check(prime2, prime4) || !check(prime3, prime4))continue;
			//System.out.println(prime1 + " " + prime2 + " " +prime3 + " " + prime4);

			for(int i5=i4+1; i5<size; i5++){
			    int prime5=primesList.get(i5);
			    if(!check(prime1, prime5) || !check(prime2, prime5) || !check(prime3, prime5) || !check(prime4, prime5))continue;
			    System.out.println(prime1 + " " + prime2 + " " +prime3 + " " + prime4 + " "+ prime5);
			}

		    }
		}
	    }
	}

    }
    public class Pair{
	int pairBeginning;
	int pairPro;
	public Pair(int pairBeginning, int pairPro){
	    this.pairBeginning=pairBeginning;
	    this.pairPro=pairPro;
	}
	@Override
	public boolean equals(Object o) {
	    if(this==o){
		return true;
	    }
	    return false;
	}
  
    }
    public static boolean check(int start, int proPrime){
	return isPrime((int)Long.parseLong(start+""+proPrime)) && isPrime((int)Long.parseLong(proPrime+""+start));
    }
  
    public static boolean isPrime(int n){
	if(n <= 3) return 1 < n;
	if( n%2==0 || n%3==0) return false;
	Integer i=5;
	while(n>=(i*i)){
	    if(n % i == 0 || n % (i + 2) == 0) return false;
	    i+=6;	    
	}
	return true;
    }
}
