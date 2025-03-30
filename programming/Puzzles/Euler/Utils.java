import java.util.*;

public class Utils{
    public static void permute(String prefix, ArrayList<String> remainders, ArrayList<String> results, int length){
	if(prefix.length()==length){
	    results.add(prefix);
	    return;
	}
	for(String listPrefix : remainders){
	    ArrayList<String> newList=new ArrayList<String>();
	    newList.addAll(remainders);
	    newList.remove(listPrefix);
	    permute(prefix+listPrefix, newList, results, length);
	}
    }
    public static void choices(String prefix, ArrayList<String> remainders, ArrayList<String> results, int length){
	if(prefix.length()==length){
	    results.add(prefix);
	    return;
	}
	for(int i = 0; i<remainders.size(); i++){
	    ArrayList<String> list=new ArrayList();
	    for(int k=i+1; k<remainders.size(); k++){
		list.add(remainders.get(k));
	    }
	    choices(prefix+remainders.get(i), list, results, length);
	}
    }
    public static void main(String[] args){
	ArrayList<String> list=new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	ArrayList<String> results=new ArrayList();
	choices("", list, results, 3);
	System.out.println(results);
	
    }
}
