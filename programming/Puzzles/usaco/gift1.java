/*
ID: bill.pi1
LANG: JAVA
TASK: gift1
*/



import java.util.*;
import java.io.*;




public class gift1{


    public static int[] toIntArray(String[] str){
        int[] arr = new int[str.length];
        for(int i = 0; i < str.length; i++){
            arr[i] = (Integer.parseInt(str[i]));
        }
        return arr;
   
    }
    

    //Store info in Block class

    static class Block {
        String giver = "fubar";
        int mn = 0;
        List<String> takers = new ArrayList<String>();
    
        
        public Block(String giver, int mn, List<String> takers) {
            this.giver = giver;
            this.mn = mn;
            this.takers = takers;
        }
    }
    


    //read file into line
    public static List<String> stream(String name) {
        try{
            List<String> lines = new ArrayList<String>();
            Scanner sc = new Scanner(new FileInputStream(name));
            while(sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            sc.close();
            return lines;

        }catch(IOException e){
            System.out.println("uh oh");
            return null;
        } 
    }


    public static void blockerizer(List<String> input, List<Block> output){

        if(input.size() > 0) {
            
            String giver = input.get(0);
            int[] data = toIntArray(input.get(1).split(" ")); 
            List<String> takers = input.subList(2, 2+data[1]);
            output.add(new Block(giver, data[0], takers));
            blockerizer(input.subList(2+data[1], input.size()) , output);

        }

    }

    public static void cashier(HashMap<String, Integer> bank, List<Block> blocks){
        for(Block block : blocks){
            
            if(block.mn != 0){
                int a = (int)(block.mn / block.takers.size());
                int b = block.mn - (a*block.takers.size());

                for(String t : block.takers){
                    bank.put(t, bank.get(t)+a);
                }
                bank.put(block.giver, bank.get(block.giver) + b - block.mn);
            }
            
            
        }
    }
    
    public static List<String> banker(String file){

        HashMap<String, Integer> bank = new HashMap<String, Integer>();
        List<String> input = stream(file);
        List<Block> blocks = new ArrayList<Block>();
        List<String> people = input.subList(1, Integer.parseInt(input.get(0)) + 1);
        
        for(String p : people){
            bank.put(p, 0);
        }
        blockerizer(input.subList(people.size()+1, input.size()), blocks);
        cashier(bank, blocks);

        for(int i = 0; i < people.size(); i++){
            String p = people.get(i);
            people.remove(i);
            people.add(i, p + " " + bank.get(p));
        }

    return people;

    }


    public static void main(String[] args)throws IOException{

        List<String> output = (banker("gift1.in"));

        PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        for (String i : output) {
            outFile.println(i); 
            System.out.println(i);
        }
        outFile.close();

    }
}