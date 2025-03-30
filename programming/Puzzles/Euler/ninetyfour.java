import java.math.BigDecimal;

public class ninetyfour {
    
    public static void main(String[] args){

        long sum = 0;
        for(int c = 1000000; c > 3; c--){
          
            double y1 = (Math.pow((c+1l)*(c+1l) - (c/2l)*(c/2l), 0.5));
            double y2 = (Math.pow((c-1l)*(c-1l) - (c/2l)*(c/2l), 0.5));

            if((y1%1.0 * c / 2)%1.0 == 0){
                System.out.println("Bottom: " + c + " Hypotenuse : " + (c+1));
                System.out.println("Perimeter : " + (c+(c+1)+(c+1)));
                System.out.println(y1);
                System.out.println(c * y1/2);
                System.out.println();
                sum+=(c+(c+1)+(c+1));
            }
            if((y2%1.0 * c / 2)%1.0 == 0){
                System.out.println("Bottom: " + c + " Hypotenuse : " + (c-1));
                System.out.println("Perimeter : " + (c+(c-1) + (c-1)));
                System.out.println(c * y2/2);
                
                System.out.println();
                sum+=(c+(c-1)+(c-1));
            }

        }
        System.out.println(sum);
        System.out.println(Math.pow(34*34-(16.5*16.5), 0.5));
    }

}
        