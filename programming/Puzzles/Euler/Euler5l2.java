import java.util.*;
//Given 2, 3, 5, 7 make 81
//For i in prime list check which one (7 to 2) can 81 be divisible by 
//81 is divisible by 3 so the scores are 0100
//Then you can use recursion to keep doing it until 81 becomes 1
//When the that happens the score should be 0400
//Should work with other numbers too
public class Euler5l2{
    public static void main(String[] args){
	 ArrayList<Integer> options=new ArrayList<Integer>();
	 options.add(2);
	 options.add(3);
	 options.add(5);
	 options.add(7);
	 

	 //0001  7 
	 //2000  8
	 //0200  9 
	 //0010  10
	 ArrayList<Integer[]> numfactors=new ArrayList<Integer[]>();
	 for(int i=1; i<11; i++){	    
	     Integer [] array = findFactors2(i, options);
	     numfactors.add(array);
	 }
	 int product=1;
	 for(int f=0; f<options.size(); f++){
	     product*=Math.pow(options.get(f), findLargest(f, numfactors));
	 }
	 System.out.println(product);
	 
    }
    
    public static Integer findLargest(int index, ArrayList<Integer[]> numfactors){
	int largest=0;
	for(Integer[] factors:numfactors){
	    int i=factors[index];
	    if(i>largest) largest=i;
	}
	return largest;
    }
    public static Integer[] findFactors2(int num, ArrayList<Integer> options){
	Integer[] array=new Integer[options.size()];
	//System.out.println(Arrays.asList(array));
	for(int i=0; i<options.size(); i++){
	    int n=0;
	    int d=options.get(i);
	    if(num%d!=0) array[i]=n;
	    while(num%d==0){
		n++;
		num=num/d;
		array[i]=n;
	    }
	}
	return array;
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

