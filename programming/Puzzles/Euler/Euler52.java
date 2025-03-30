import java.util.*;
public class Euler52{
    public static void main(String[] args){
	System.out.println(isEqual(123, 312));
	ArrayList<String> items=new ArrayList();
	for(int i=2; i<=9; i++) items.add(i+"");
	int maxFactor=6;
	int maxDigit=6;
	ArrayList<String> results=new ArrayList();
	Utils.permute("", items, results, 5);
	for(String result : results){
	    int permute=Integer.parseInt("1"+result);
	    boolean isTrue=true;
	    for(int i=2; i<=6 && isTrue; i++){
		if(!isEqual(permute, permute*i)) isTrue=false;
	    }
	    if(isTrue){
		System.out.println(permute);
		break;
	    }
	}
    }
    public static boolean isEqual(int number1, int number2){
	ArrayList<String> splited1 = new ArrayList(Arrays.asList((number1+"").split("")));
	ArrayList<String> splited2 = new ArrayList(Arrays.asList((number2+"").split("")));
	ArrayList<Integer> converted1=new ArrayList();
	ArrayList<Integer> converted2=new ArrayList();
	for(String split1 : splited1){
	    converted1.add(Integer.parseInt(split1));
	}
	for(String split2 : splited2){
	    converted2.add(Integer.parseInt(split2));
	}
	System.out.println(new HashSet(converted1)+"=="+new HashSet(converted2));
        if(new HashSet(converted1).equals(new HashSet(converted2))) return true;
	return false;

    }
    /** public static ArrayList<Integer> convert(int number){
	for(int )
    }
    **/
	
    }
    
    
   

