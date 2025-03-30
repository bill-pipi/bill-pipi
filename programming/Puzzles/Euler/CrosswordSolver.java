import java.util.*;
public class CrosswordSolver{
    public static void main(String[] args){
	//['c', 'a', 't']
	//['d', 'o', 'g']
	//['m', 'a', 'd']
        char[][] puzzle={{'c', 'a', 't'}, {'d', 'o', 'g'},{'m', 'a', 'd'}};
	System.out.println(findPossibleDiagonal(0, 0, "cod", puzzle));
	
    }
    public static String findDir(int startx, int starty, String word, char[][] puzzle, int ix, int iy){
	int wordLength=word.length();
	boolean valid=true;
	for(int i=0; i<wordLength; i++){
	    System.out.println(puzzle[startx+(ix*i)][starty+(iy*i)]);
	    if((char)word.charAt(i)!=puzzle[startx+(ix*i)][starty+(iy*i)]) valid=false;
	}
	if(valid){
	    if(ix==-1 && iy==-1) return "leftUp";
	    if(ix==-1 && iy==1) return "leftDown";
	    if(ix==1 && iy==-1) return "rightUp";
	    if(ix==1 && iy==1) return "rightDown";
	}
	return "NA";
    }
    public static ArrayList<String> findPossibleDiagonal(int startx, int starty, String word, char[][] puzzle){

	ArrayList<String> found=new ArrayList<String>();
	int wordLength=word.length()-1;
	if(startx-wordLength>=0 && starty-wordLength>=0){
	    found.add(findDir(startx, starty, word, puzzle, -1, -1));
	    System.out.println("hello");
	}

	int w =  startx+wordLength;
       if( w <= puzzle.length && w <=puzzle[0].length){
	   //found.add(findDir(startx, starty, word, puzzle, 1, 1));
	}
	
	return found;

    }
}
