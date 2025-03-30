import java.lang.Math;
import java.util.Set;
import java.util.HashSet;


public class main {
    

    public static void main(String[] args){



        Set fractions = new HashSet<Double>();

        for(int d = 2; d <= 12000; d++){
        
            double bottom = Math.ceil(d/3.0);
            double top = Math.floor(d/2.0);
            for(double n = bottom; n <= top ; n++){
                if(n/d != 1/3.0 && n/d != 1/2.0) fractions.add(n/d);
            }
            
        }
        System.out.println(fractions.size());

    }


}
