import java.util.*;
public class Euler5k2{
    public static void main(String[] args){
	ArrayList<Integer> options=new ArrayList<Integer>();
	options.add(2);
	options.add(3);
	options.add(5);
	options.add(7);
	int product=1;
	for(int i: options){
	    int max=0;
	    for(int f=0; Math.pow(i, max)<10 ; i++) max++;
	    System.out.println(Math.pow(i, max));
	    product*=Math.pow(i, max);
	}
	System.out.println(product);
    }
}
