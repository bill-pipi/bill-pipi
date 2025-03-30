import java.util.*;
import java.io.*;
public class Euler61{
    public static void main(String[] arg){
	int digits=4;
	ArrayList<Integer> polygons=new ArrayList();
	polygons.add(3);
	polygons.add(4);
	polygons.add(5);
	polygons.add(6);
	polygons.add(7);
	polygons.add(8);
	ArrayList<Integer> test=new ArrayList();
	test.add(8282);
	test.add(5494);
	test.add(4458);
	test.add(5489);
	test.add(2345);
	test.add(9758);
	System.out.println(findStart("82", test));

	for(int polygonType1 : polygons){
	    ArrayList<Integer> polygonNumberList1=generateList(digits, polygonType1);

	    for(int polygonNumber1 : polygonNumberList1){
		
		String start1=(polygonNumber1+"").substring(digits/2, digits);
		ArrayList<Integer> polygons2=new ArrayList<Integer>();
		polygons2.addAll(polygons);
		polygons2.remove(polygons.indexOf(polygonType1));
		
		for(int startPolygon1 : polygons2){
		    
		    ArrayList<Integer> startPolygons=findStart(start1, generateList(digits, startPolygon1));
		    if(startPolygons.size()==0) break;
		    
		    for(int polygonNumber2 : startPolygons){
			
			String start2=(polygonNumber2+"").substring(digits/2, digits);
			ArrayList<Integer> polygons3=new ArrayList<Integer>();
			polygons3.addAll(polygons2);
			polygons3.remove(polygons2.indexOf(startPolygon1));
			
			for(int startPolygon2 : polygons3){
			    
			    ArrayList<Integer> startPolygons2=findStart(start2, generateList(digits, startPolygon2));
			    if(startPolygons.size()==0) break;
			    System.out.println(polygonType1+": "+polygonNumber1+", "+startPolygon1+": "+polygonNumber2+", "+startPolygon2+": "+startPolygons2);
			}
		    }
		}
	    }
	}
    }
    public static ArrayList<Integer> findStart(String start, ArrayList<Integer> list){
	ArrayList<Integer> starts=new ArrayList();
	for(int polygon : list){
	    if((polygon+"").substring(0, (start+"").length()).equals(start)) starts.add(polygon);
	}
	return starts;
    }
    public static int findTriangle(int num){
	return num*(num+1)/2;
    }
    public static int findSquare(int num){
	return (int)Math.pow(num, 2);
    }
    public static int findPentagon(int num){
	return num*((3*num)-1)/2;
    }
    public static int findHexagon(int num){
	return num*((2*num)-1);
    }
    public static int findHeptagon(int num){
	return num*((5*num)-3)/2;
    }
    public static int findOctagon(int num){
	return num*((3*num)-2);
    }
    public static ArrayList<Integer> generateList(int digits, int polygonSides){
	ArrayList<Integer>list=new ArrayList<Integer>();
	boolean keepGoing=true;
	for(int i=0; keepGoing; i++){
	    int polygon=0;
	    if(polygonSides==3)  polygon=findTriangle(i);
	    if(polygonSides==4)  polygon=findSquare(i);
	    if(polygonSides==5)  polygon=findPentagon(i);
	    if(polygonSides==6)  polygon=findHexagon(i);
	    if(polygonSides==7)  polygon=findHeptagon(i);
	    if(polygonSides==8)  polygon=findOctagon(i);
	    if(polygon>Math.pow(10, digits)-1){
		keepGoing=false;
	    }
	    if(polygon>Math.pow(10, digits-1)) list.add(polygon);
	}
	list.remove(list.size()-1);
	return list;
	
    }
    /**public static int findNum(ArrayList<Integer> polyLists, int startNum){
    }
    **/

}
