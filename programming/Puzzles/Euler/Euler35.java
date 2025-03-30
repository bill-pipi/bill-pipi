import java.util.*;
public class Euler35{
    public static void main(String[] args){
	int cp=0;

	for(int prime=2; prime<1000000; prime++){
	    if(isPrime(prime)){
		//	System.out.println(prime);
		ArrayList<String> remainders=new ArrayList();
		for(int i=0; i<(prime+"").length(); i++) remainders.add((prime+"").substring(i, i+1));
		//System.out.println(remainders);
		ArrayList<String> permutes=new ArrayList();
		Utils.permute("", remainders, permutes, (prime+"").length());
		//System.out.println(permutes);
		boolean isCp=true;
		for(int index=0; index<permutes.size() && isCp; index++){
		    String permute=permutes.get(index);
		    if(!isPrime(Integer.parseInt(permute))){isCp=false;}
		    
		}
	        if(isCp==true) cp++;
		
	    }
	}
	System.out.println(cp);

	/**ArrayList<String> remainders=new ArrayList<String>();
	    remainders.add("3");
	    remainders.add("4");
	    ArrayList<String> results=new ArrayList<String>();
	    Utils.permute("", remainders, results, 2);
	    System.out.println(results);
	**/
	
	
	
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
}
