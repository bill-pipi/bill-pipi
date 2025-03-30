import java.util.*;
import java.io.*;
public class Euler63{
    public static void main(String[] args){
	int count=1;
	for(int power=1; ; power++){
	    ArrayList<Integer> list=findExpo(power);
	    System.out.println(list);
	    count+=list.size();
	    if(list.size()==0) break;
	}
	System.out.println(findExpo(9));
	System.out.println(count);
	System.out.println(Math.pow(10, 2));
    }
    public static ArrayList<Integer> findExpo(int power){
	ArrayList<Integer> list=new ArrayList();
	for(int i=9; i>(int)Math.pow(Math.pow(10, power-1),1.0/ power); i--){	    
	    list.add((int)Math.pow(i, power));
	}
	return list;
       
    }
}
