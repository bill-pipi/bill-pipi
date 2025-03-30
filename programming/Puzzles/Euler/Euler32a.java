import java.util.*;

public class Euler32a{
    public static void test(){
	ArrayList<String> list=new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	ArrayList<String> results=new ArrayList();
	Utils.choices("", list, results, 3);
	System.out.println(results);
	
    }
    public static void main(String[] args){
	
	ArrayList<String> list=new ArrayList<String>();
	for(int i=1; i<=9; i++){
	    list.add(i+"");
	}
	ArrayList<String> results1=parseChosen(1, list);
	for(String result1: results1){
	    ArrayList<String> results4=parseChosen(4, removeString(list, result1));
	    for(String result4: results4){
		ArrayList<String> results42=parseChosen(4, removeString(list, result4+result1));
		for(String result42: results42){
		    //System.out.println(result42+"  "+result1);
		    if(Integer.parseInt(result1)*Integer.parseInt(result4)==Integer.parseInt(result42)) System.out.println(result1+"*"+result4+"="+result42);

		}

	    }

	    
	    /** for(String result4: results4){
		ArrayList<String> results4R4=parseChosen(4, removeString(list, result4+result1));
		if(result1=="5") System.out.println(result1+"*"+result4);

		for(String result4R4 : results4R4){
		    if(result1=="5") System.out.println(result1+"*"+result4+"="+result4R4);
		    if(Integer.parseInt(result1)*Integer.parseInt(result4)==Integer.parseInt(result4R4)) System.out.println(result1+"*"+result4+"="+result4R4);
		}
	    }
	    **/
	}
	
    }
    
    public static ArrayList<String> parseChosen(int lengthNum, ArrayList<String> list){
	ArrayList<String> results=new ArrayList();
	Utils.permute("", list, results, lengthNum);
	return results;
	
    }
    public static ArrayList<String> removeString(ArrayList<String> list, String string){
	ArrayList<String> list2=new ArrayList();
	list2.addAll(list);
	for(int i=0; i<=string.length()-1; i++) list2.remove(string.substring(i, i+1));
	return list2;
    }
}
