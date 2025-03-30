import java.util.*;
public class Euler64{
    public static void main(String[] args){
	new Euler64().test();
    }
    public void test(){
	for(int num=5; num<10000; num++){
	rootFraction rf=new rootFraction(new bothVal(7, new rootAndRemainder(num, findLargestRoot(num)*-1)), new bothVal(7, new rootAndRemainder(num, findLargestRoot(num)*-1)));
	System.out.println(findLargestRoot(num)*-1);
	String root=findLargestRoot(23)+".";
	int count=0;
	HashSet<String> list=new HashSet<String>();
	for(int i=0; true; i++){
	    if(list.contains(rf.toString())){
		count--;
		root=root.substring(0, root.length()-1);
		break;
	    }
	    list.add(rf.toString());
	    rf.switchVal2();
	    rf.switchVal();
	    count++;
	    System.out.println(rf+" "+list);
	    root+=rf.removeRemainder();

	}
	System.out.println(count);
	System.out.println(root);
	
	
	}
	
    }
    public static int findLargestRoot(int num){
	return (int)Math.pow(num, 0.5);
    }
    public class bothVal{
	int integer;
	rootAndRemainder rr;
	public bothVal(int integer, rootAndRemainder rr){
	    this.integer=integer;
	    this.rr=rr;
	}
	@Override
	public String toString(){
	    return integer+ " " + rr;
	}

    }

    public class rootFraction{
	bothVal numerator;
	bothVal denominator;
	public rootFraction(bothVal numerator, bothVal denominator){
	    this.numerator=numerator;
	    this.denominator=denominator;
	}

	@Override
	public String toString(){
	    return numerator+"/"+denominator;
	}
	public void switchVal(){
	    numerator.rr=new rootAndRemainder(denominator.rr.squareRoot, denominator.rr.remainder*-1);
	    denominator.integer=denominator.rr.convertToInt()/numerator.integer;
	}
	public int removeRemainder(){
	    int i=((int)Math.pow(numerator.rr.squareRoot, 0.5)+numerator.rr.remainder)/denominator.integer;
	    numerator.rr.remainder=numerator.rr.remainder-(i*denominator.integer);
	    return i;
	    
	}
	public void switchVal2(){
	    numerator.integer=denominator.integer;
	    denominator.rr=numerator.rr;
	}
    }
    public class rootAndRemainder{
	public rootAndRemainder(){
	}
	int squareRoot;
	int remainder;

	public rootAndRemainder(int squareRoot, int remainder){
	    this.squareRoot=squareRoot;
	    this.remainder=remainder;
	}
	public int convertToInt(){
	    return squareRoot-(int)Math.pow(remainder, 2);
	}
	@Override
	public String toString(){
	    return "("+squareRoot+")^0.5"+"+"+remainder;
	}
    }
    }

