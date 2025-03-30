import java.util.*;
public class Euler1{
    public static void main(String[] args){
	int range=10;
	ArrayList<Integer> list1=new ArrayList<Integer>();
	int i=0;
	while(i<range){
	    i++;
	    if(isMulitple(i)) list1.add(i);
	}
	ArrayList<Integer> list2=new ArrayList<Integer>();
	int over=0;
	int five=0;
	int three=0;
	while(over<2){
	    if(five<range){
		five+=3;
	    }
	    if(five<range){
		three+=5;
	    }
	    over++;
	}
	System.out.println(list1.stream().mapToDouble(a->a).sum());
	
	    
    }
    public static Boolean isMulitple(int num){
	return num%5==0 || num%3==0;
    }
    //(i/5)/2)*i
    //5+10+15+10
    //2*20
    //3+6+9+12+15+18
    //60
}
