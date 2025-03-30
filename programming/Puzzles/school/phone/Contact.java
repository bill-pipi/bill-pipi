package phone;


public class Contact implements Comparable{

    Person person;
    Cell cell;
    static Boolean isFirst = true;


    
    public Contact(Person person, Cell cell){

	this.person = person;
	this.cell = cell;
	
    }


    public Contact(String first, String last){
	this.person = new Person(first, last);
	this.cell = new Cell();
    }

    
    public Person person(){  return person;  }
    public Cell cell(){  return cell;  }

    
    public String toString(){

	return "Contact: " + person + "\nCell: " + cell; 
	
    }

    public int compareFirst(Object o){
	Contact c = (Contact) o;
	String a = this.person.first();
	String b = c.person.first();
	
	if(a.equals(b)) return 0;
	return a.compareTo(b);
    }

    public int compareLast(Object o){
	Contact c = (Contact) o;
	String a = this.person.last();
	String b = c.person.last();
	
	if(a.equals(b)) return 0;
	return a.compareTo(b);
    }
    
    @Override public int compareTo(Object o)
    {

	if(isFirst) return compareFirst(o);
	return compareLast(o);
	
    }

}

