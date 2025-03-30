import java.util.*;
public class Euler5{
    public static void main(String[] args){
	
	
	ArrayList<ArrayList<Integer>> bottomlists=new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> leftovers=new ArrayList<Integer>();
	ArrayList<Integer> topList=new ArrayList<Integer>();
	for(int i=1; i<19; i++){
	    ArrayList<Integer> options=new ArrayList<Integer>();
	options.add(2);
	options.add(3);
	options.add(5);
	options.add(7);
	options.add(11);
	options.add(13);
	options.add(17);
	options.add(19);
	    ArrayList<Integer> list=new ArrayList<Integer>();
	    findFactors(i, options, 0, 2, list);
	    System.out.println(list);
	    list.add(1);
	    bottomlists.add(list);
	}
	leastMultiple(topList, bottomlists,leftovers );
	

    }
    //In Progress
    public static void leastMultiple(ArrayList<Integer> topList, ArrayList<ArrayList<Integer>> bottomLists, ArrayList<Integer> leftovers){
	if(bottomLists.size()==0){
	    return;
	}
	System.out.println("bl"+bottomLists);
	for(ArrayList<Integer> list : bottomLists){
	    //System.out.println("uni "+topList+" "+list);
	    removeDup(topList, list, topList.get(0),0);
	    if(list.size()==0) bottomLists.remove(list);
	}
	System.out.println("topList "+topList);
	leftovers.add(topList.stream().reduce(1, (a, b) -> a * b));
	ArrayList<Integer> newTop=bottomLists.get(0);
	bottomLists.remove(newTop);
	leastMultiple(newTop, bottomLists, leftovers);
	
	
    }
    public static Boolean isPrime(int num){
	if(num<2){
	    return true;
	}
	for(int i=2; i<num; i++){
	    if(num%i==0) return false;
	}
	return true;
    }
    //good
    public static void removeDup( ArrayList<Integer> baseList,  ArrayList<Integer> removeList, int removeNum, int i){
	if(baseList.size()-1==i){
	    return;
	}
	else if(removeList.contains(removeNum)){
	    System.out.println(removeNum);
	    i++;
	    removeList.remove(removeList.indexOf(removeNum));
	    removeDup(baseList, removeList, baseList.get(i), i);
	}
	else{
	    i++;
	    removeDup(baseList, removeList, baseList.get(i), i);
	}

    }
    //Good
    public static void findFactors(int divideNum, ArrayList<Integer> options,
  				 int index, int denominator, ArrayList<Integer> factors){
	if(isPrime(divideNum)){
	    factors.add(divideNum);
	    return;
	}
	else if((double)divideNum/denominator==(Integer)divideNum/denominator){
	    factors.add(denominator);
	    findFactors(divideNum/denominator, options, index, denominator, factors);
	}
	else{
	    options.remove(options.indexOf(denominator));
	    index++;
	    findFactors(divideNum, options, index, options.get(index-1), factors);
	}
    }
}
