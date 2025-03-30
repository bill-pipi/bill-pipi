public class Euler36{
    public static Boolean isPalindrome(String num){
	String reversed=new StringBuilder(num).reverse().toString();
	return num.equals(reversed);
    }
    public static void main(String[] args){
	int sum=0;
	System.out.println(isPalindrome(10001+""));
	for(int i=0; i<1000000; i++){
	    String binary=Integer.toString(i, 2);
	    //if(isPalindrome(binary+"")) System.out.println(binary);
	    if(isPalindrome(i+"") && isPalindrome(binary)) sum+=i;
	    }
    }
}
