public class main {
    

    public static int solution(int limit){

        int ans = 0;
        long max = 0;
        
        for(int d = 2; d <= limit; d++){

            System.out.println("Currently at d : " + d);


            for(int n = 1; Math.sqrt(d) % 1.0 != 0.0; n++){
                
                Long x = Long.valueOf(n * d);

                if( Math.sqrt( n * (x + 2.0) ) % 1.0 == 0.0){
                    x++;
                    if (x > max){
                        max = x; 
                        ans = d;
                    } 
                    break;
                }

                if( Math.sqrt( n * (x - 2.0) ) % 1.0 == 0.0){
                    x--;
                    if (x > max){
                        max = x; 
                        ans = d;
                    }
                    break;
                }


            }

        }
        return ans;

    }



    public static void main(String[] args){

        System.out.println(solution(1000));

    }

}
