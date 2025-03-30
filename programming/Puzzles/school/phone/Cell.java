package phone;


import java.util.*;

public class Cell{

    String number;
    
    public Cell(){

	number = "0000000000";
	
    }

    
    public void tryNum(String str){

	try{
	    Long.parseLong(str);
	    if(str.length() == 10) number = str;
	}
	catch(Exception e){
	    System.out.println("Not a number");
	}


    }

    
    public String toString(){
	return "("+number.substring(0, 3)+")"+number.substring(3,6)+"-"+number.substring(6,10);  }
    
}
