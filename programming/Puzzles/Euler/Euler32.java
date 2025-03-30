//1, (8)
import java.util.*;
public class Euler32{
    public static void main(String[] args){
	Euler32 euler32=new Euler32();
	System.out.println(euler32.findTriples(9));

    }
    public ArrayList<Triplet> findTriples(int max){
	ArrayList<Triplet> triplets=new ArrayList<>();
	for(int product=4;product<=max-2;product++){
	    for(int mul=1;mul<=(max-1)-product;mul++){
		Triplet triple=new Triplet(product, mul, max-(product+mul));
		triple.getPandigit();
	    }
	}
	    
	return (triplets);   
    
	
	
    }
	public class Triplet{
	    int productSize;
	    int mulSize;
	    int mul2Size;
	    int panDigit;
	    @Override
	    public String toString(){
		return "product: "+productSize+" mul: "+mulSize+" mul2: "+(panDigit-(mulSize+productSize));
	    }
	    public Triplet(int productSize, int mulSize, int mul2Size){
		this.productSize=productSize;
		this.mulSize=mulSize;
		this.mul2Size=mul2Size;
		this.panDigit=mulSize+productSize+mul2Size;
	    }
	    public boolean isPandigital(String num){
		ArrayList<Integer> panList=new ArrayList<>();
		ArrayList<Integer> splitString=new ArrayList<>();
		for(int i=0; i<=num.length()-1; i++){
		    splitString.add(Integer.parseInt(num.substring(i, i+1)));
		    panList.add(i+1);
		}
		Collections.sort(splitString);
		return (panList.equals(splitString));
	    }
	    public void getPandigit(){
		for(int product=(int)Math.pow(10, productSize-1); product<(int)Math.pow(10, productSize)-1; product++){
		    for(int mul=(int)Math.pow(10, mulSize-1); mul<(int)Math.pow(10, mulSize)-1; mul++){
			for(int mul2=(int)(Math.pow(10, mul2Size-1)); mul2<(int)Math.pow(10, mul2Size)-1; mul2++){
			    if(mul*mul2!=product) continue;
			    
			    if(mul*mul2==product){
				if(isPandigital((mul+"")+(mul2+"")+(product+""))){
				    System.out.println(mul+", "+mul2+", "+product);
				}
				
			    }
			    
			}
		    }
		}
	    }
	    6952
		7852
		4396
		5346
		5796
		7254
		7632
		

	    
	        6952
		7852
		4396
		5346
		5346
		5796
		5796
		7254
		7632

		    4, 1738, 6952
		4, 1963, 7852
		28, 157, 4396
		18, 297, 5346
		27, 198, 5346
		12, 483, 5796
		42, 138, 5796
		39, 186, 7254
		48, 159, 7632
		157, 28, 4396
		198, 27, 5346
		297, 18, 5346
		138, 42, 5796
		483, 12, 5796
		186, 39, 7254
		159, 48, 7632
		1738, 4, 6952
		1963, 4, 7852


	    
	    
	     
	}
}
