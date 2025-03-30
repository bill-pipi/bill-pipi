import java.util.*;

public class Euler76{
    
   public static void main(String[] args){
	//200
	//200
	//0
	//1
	//0
	//10000
	//200
	//100
	//200
	//100000
	//000000
	//100
	//50
	//150
	//200
	//
	ArrayList<Integer> coinTypes=new ArrayList();
	for(int i=1; i<=4; i++) coinTypes.add(i);
	ArrayList<ArrayList<Integer>> coinMatrix=new ArrayList();
	coinSumCalculator(coinTypes, coinMatrix, new ArrayList(), 5);
	System.out.println(coinMatrix.size());

    }
    public static void coinSumCalculator(ArrayList<Integer> coinTypes,
								  ArrayList<ArrayList<Integer>> coinMatrix,
								  ArrayList<Integer> coinList, int changeLeft){
	//System.out.println(coinList+", "+changeLeft);
	
	int coin = coinTypes.get(0);	
	for(int i=0; i<=(changeLeft-(changeLeft%coin))/coin; i++){
	    int currentChange=changeLeft-(i*coin);
	    ArrayList<Integer> cct=new ArrayList<Integer>();
	    cct.addAll(coinTypes);
	    cct.remove(0);
	    ArrayList<Integer> ccl=new ArrayList<Integer>();
	    ccl.addAll(coinList);
	    ccl.add(i);
	    if(coinTypes.size()==1){
		coinList.add(changeLeft);
		coinMatrix.add(coinList);
		break;
	    }
	    coinSumCalculator(cct, coinMatrix, ccl, currentChange);
	}
	
    }


    
}
