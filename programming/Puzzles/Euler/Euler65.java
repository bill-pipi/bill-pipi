import java.math.BigInteger;
import java.util.*;
//1+(1/(1+(1/2));
public class Euler65{
    public static void main(String[] args){
	new Euler65().test();
    }
    /**
1+  (1/(1+(1/2)))
     **/
    public void test(){
	ArrayList<Integer> periods=new ArrayList<Integer>();
	int period=0;
	for(int i=1; i<=4; i++){
	    if((i-2)%3==0){
		period+=2;
		periods.add(period);
	    }
	    else{
		periods.add(1);
	    }
	}
	System.out.println(periods);
	//(1/1)
	//(2/1)
	//(1/2)
	//(3/2)
	//1+(1/x)
	//1+(1/1)
	Fraction fraction=new Fraction(new BigInteger("1"), new BigInteger(periods.get(periods.size()-1)+""));
	System.out.println(periods.size()-1+"");
	for(int i =1; i<periods.size(); i++){
	    System.out.println(periods.get(i));
	    fraction = new Fraction(fraction.numerator.add(BigInteger.valueOf(i).multiply(fraction.denominator)), BigInteger.valueOf(i));
	    fraction=new Fraction(fraction.denominator, fraction.numerator);
	}
	fraction = new Fraction(fraction.numerator.add(fraction.denominator), fraction.denominator);
	System.out.println(fraction);
	int count=0;
	for(int i=0; i<(fraction.numerator+"").length(); i++){
	    count+=Integer.parseInt((fraction.numerator+"").substring(i, i+1));
	}
	System.out.println(count);


    }
    public class Fraction{
	BigInteger numerator;
	BigInteger denominator;
	public Fraction(BigInteger numerator, BigInteger denominator){
	    this.numerator=numerator;
	    this.denominator=denominator;
	}
	@Override
	public String toString(){
	    return numerator+"/"+denominator;
	}
    }
}
