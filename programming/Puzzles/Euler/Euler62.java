import java.util.*;
import java.io.*;
public class Euler62{
    public static void main(String[] args){
	int cube=10;
	while(true){
	    cube++;
	    ArrayList<String> list=new ArrayList<String>();
	    String cubeString=(long)Math.pow(cube, 3)+"";
	    for(int i=0; i<cubeString.length()-1; i++) list.add((cubeString+"").substring(i, i+1));
	    ArrayList<String> results=new ArrayList();
	    Utils.choices("", list, results, cubeString.length());
	    //System.out.println(list);
	    for(String permute : results){
		if(Math.pow(Integer.parseInt(permute), 1.0/3.0)==(long)Math.pow(Integer.parseInt(permute), 1.0/3.0)){
		    System.out.println(cube+"^3=="+cubeString +"&&"+ permute);
		    break;
		}
	    }
	}
    }
}
