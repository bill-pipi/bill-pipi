package phone;

import java.util.*;

public class Addressbook{

    static Boolean isNormal = false; 
    
    public static Contact[] promptInit(Scanner input){

	System.out.println("How many contacts would you like to add?");
	int n = Integer.parseInt(input.nextLine());

	Contact[] contacts = new Contact[n];

	
	for(int i = 0; i < n; i++){

	    String first, last;
	    String cellNumber;
	    
	    System.out.println("Enter a first name");
	    first = input.nextLine().toLowerCase();
	    
	    System.out.println("Enter a last name");
	    last = input.nextLine().toLowerCase();
	    
	    System.out.println("Enter a 10 digit cell number with no spaces or special characters");
	    cellNumber = input.nextLine();

	    Person person = new Person(first, last);

	    Cell cell = new Cell();
	    cell.tryNum(cellNumber);
	    
	    Contact contact = new Contact(person, cell);
	    contacts[i] = contact;
	    
	}
	return contacts;
	
    }


    public static Contact[] promptSort(Scanner input, Contact[] contacts){
	System.out.println("Would you like to sort and find by first or last name (or normal)?");

	
	String str = input.nextLine().toLowerCase();
	
	if(str.equals("last")) Contact.isFirst = false;
	if(str.equals("normal")) isNormal = true;
	
	System.out.println("Final UNSORTED AddressBook");
	for(Contact contact : contacts) System.out.println(contact+"\n");

	Contact[] sorted = (Contact[]) Util.sort(contacts);
	System.out.println("Final SORTED AddressBook");
	for(Contact contact : contacts) System.out.println(contact+"\n");

	return sorted;
		
	
    }

    public static void promptFind(Scanner input, Contact[] sorted){


	System.out.print("Enter a");
	if(isNormal) System.out.print(" first or last ");
	else if(Contact.isFirst) System.out.print(" first ");
	else System.out.print(" last ");
	System.out.print("name you are trying to find\n");

	String name  =  input.nextLine().toLowerCase();	

	if(isNormal){
	    normalFind(sorted, name);
	    return;
	}

	Contact proxy = new Contact(name, name);
	int i = Util.find(sorted, proxy);
	if(i != -1){
	    Contact c = sorted[i];
	    System.out.println(c);
	    for(Comparable a : Util.slice(0, i, sorted)){
		if(a.compareTo(c) == 0) System.out.println(a);
	    }
	    for(Comparable b : Util.slice(i+1, sorted.length, sorted)){
		if(b.compareTo(c) == 0) System.out.println(b);
	    }
	    return;
	}
	System.out.println("Not Found");
	
    }

    public static void normalFind(Contact[] sorted, String name){
	for(Contact contact : sorted){
	    if(contact.person().first().equals(name)){
		System.out.println(contact);
	    }
	    else{
		if(contact.person().last().equals(name)){
		System.out.println(contact);
		}
	    }
	}
    }
    
    public static void main(String[] args){

	while(true){

	    try{
		Scanner input = new Scanner(System.in);
		
		Contact[] contacts = promptInit(input);
		
		Contact[] sorted = promptSort(input, contacts);
		
		promptFind(input, sorted);
		break;
	    }

	    catch(Exception e){
		System.out.println("OOPS try again");
		continue;
	    }
	}
    }
    
}
    
