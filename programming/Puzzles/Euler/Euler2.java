import java.util.*;
public class Euler2{
    public static void main(String[] args){
	int a=0;
	int b=1;
	ArrayList<Integer> list=new ArrayList<Integer>();
	while(b<4000000){
	    a=b+a;
	    b=a+b;
	    if(a%2==0) list.add(a);
	    if(b%2==0) list.add(b);

	}
	System.out.println(list.stream().mapToDouble(c->c).sum());
    }
}
