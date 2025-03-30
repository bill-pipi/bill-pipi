import java.util.*;
public class Euler33{
    public static void main(String[] args){
	//System.out.println(replace("*__*", "48", "9"));
	//System.out.println(divide("4998"));
	for(int denominator=2; denominator<=9; denominator++){
	    for(int numerator=1; numerator<=denominator-1; numerator++){
		for(int replace=1; replace<=9; replace++){
		    findCancelDigit(numerator+""+denominator, replace+"");
		}
	    }
	}
    }
    public static ArrayList<String> permuteStringReplacement(int digits){
	ArrayList<String>replace=new ArrayList<String>();
	for(int i=1; i<=digits; i++){
	    replace.add("*");
	    replace.add("_");
	}
	ArrayList<String> permuted=new ArrayList<String>();
	Utils.permute("", replace, permuted, digits*2);
	HashSet<String> h=new HashSet<String>();
        for(String permute : permuted) h.add(permute);
	return new ArrayList<String>(h);
    }
    public static String replace(String permute, String digits, String replace){
	String num="";
	int digitIndex=0;
	for(int i=0; i<permute.length(); i++){
	    String isReplace=permute.substring(i, i+1);
	    if(isReplace.equals("*")){
		digitIndex++;
		num+=digits.substring(digitIndex-1, digitIndex);
	    }
	    if(isReplace.equals("_")){
		num+=replace;
	    }
	}
	return num;
    }
    public static double divide(String replaced, boolean isDoubleDigits){
	int middle=isDoubleDigits ? 2 : 1;
	int end=isDoubleDigits ? 4 : 2;
	int numerator=Integer.parseInt(replaced.substring(0, middle));
	int denominator=Integer.parseInt(replaced.substring(middle, end));
	return (double)numerator/denominator;
    }
    public static void findCancelDigit(String digits, String replace){
	ArrayList<String> permutes=permuteStringReplacement(digits.length());
	for(String permute : permutes){
	    String replaced=replace(permute, digits, replace);
	    double divided=divide(replaced, true);
	    double digitsDiv=divide(digits, false);
	    if(divided ==  digitsDiv) System.out.println(parse(digits, false)+" and "+replace+"=="+parse(replaced, true));
	}
    }
    public static String parse(String replaced, boolean isDoubleDigits){
	int middle=isDoubleDigits ? 2 : 1;
	int end=isDoubleDigits ? 4 : 2;
	int numerator=Integer.parseInt(replaced.substring(0, middle));
	int denominator=Integer.parseInt(replaced.substring(middle, end));
	return numerator+"/"+denominator;
    }
    
}
