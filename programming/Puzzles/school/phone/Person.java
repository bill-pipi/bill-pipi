package phone;

import java.util.*;

public class Person{

    String first;
    String last;
    
    public Person(String first, String last){

	this.first = first;
	this.last = last;
	
    }

    
    public String first(){  return first;  }
    public String last(){  return last;  }

    
    public String toString(){

	return first + " " + last;

    }
    
}
