package phone;


import java.util.*;

public class Util{

    
    public static void quick(Comparable[] arr, int a, int b){

	if(a < b) {
	    
	    int i = partition(arr, a, b);
	    
	    quick(arr, a, i-1);
	    quick(arr, i+1, b);
	}
	
    }


    public static int partition(Comparable[] arr, int a, int b){

     
	Comparable pivot = arr[b];
	
	int i = a - 1;
	
	for(int j = a; j <= b - 1; j++){		

	    if (arr[j].compareTo(pivot) < 0){
		i++;
		swap(arr, i, j);
	    }
	    
	}
	swap(arr, i + 1, b);
	return i + 1;
    }


    public static void swap(Comparable[] arr, int a, int b){

	Comparable t = arr[a];
	arr[a] = arr[b];
	arr[b] = t;
	
    }
    
    
    public static Comparable[] sort(Comparable[] arr){

	int l = arr.length;

	quick(arr, 0, l-1);

	return arr;
	
    }

    
    public static Comparable[] slice(int a, int b, Comparable[] arr){

	return Arrays.copyOfRange(arr, a, b);
	
    }
    

    public static void binary(Comparable[] arr, Comparable ob, int a, int b, int[] j){
	int i = (a+b) / 2; 

	if(arr[i].compareTo(ob) == 0){

	    j[0] = i;
	    
	}
	
	else{

	    if(arr[i].compareTo(ob) < 0)  binary(arr, ob, i, b, j);
	
	    else binary(arr, ob, a, i, j);

	}
	return;
	

    }


    public static int find(Comparable[] arr, Comparable ob){

	int[] j = new int[1];
	try{
	    binary(arr, ob, 0, arr.length, j);
	    return j[0];
	}
	catch(StackOverflowError e){
	    return -1;
	}
	

    }

    
}

