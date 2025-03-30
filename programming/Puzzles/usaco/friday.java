/*
ID: bill.pi1
LANG: JAVA
TASK: friday
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class friday {

    static int[] freq = new int[]{0,0,0,0,0,0,0};
    final static int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    final static int[] leapdays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new File("friday.out"));
        int n = sc.nextInt();



        int x = 0;
        for(int i = 1900; i <1900+n; i++){
            int[] d = days;
            if(isLeap(i)) d = leapdays;   
            for(int m = 0; m<12; m++){
                freq[((x+12)%7)]++;
                x += d[m];
            }
            
        }
        out.print(freq[5]);
        out.print(' ');
        out.print(freq[6]);
        out.print(' ');
        out.print(freq[0]);
        out.print(' ');
        out.print(freq[1]);
        out.print(' ');
        out.print(freq[2]);
        out.print(' ');
        out.print(freq[3]);
        out.print(' ');
        out.println(freq[4]);
        out.close();


    }


    public static boolean isLeap(int y){
        if(y%4 == 0){
            if(y%100 == 0){
                if(y%400 == 0) return true;
                return false;
            }
            return true;
        }
        return false;
    }



}