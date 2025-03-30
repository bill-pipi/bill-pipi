import java.util.*;
public class Euler4{
    public static void main(String[] args){
	Boolean keepGoing
	for(int x=999; x>100; x--){
	    for(int y=999; y>100; y--){
		if(isPalindrome(x*y)){
		    System.out.println(x+"*"+y+"="+x*y);
		    
		}
	    }
	}
    }
    public static Boolean isPalindrome(int num){
	String reversed=new StringBuilder(num+"").reverse().toString();
	return num==Integer.parseInt(reversed);
    }
}
