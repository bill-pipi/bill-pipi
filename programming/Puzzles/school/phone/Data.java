public class Data {
    
    private String path;

    public Data(){
        path= "/";
    }

    public Data(String path){
        this.path = path;
    }

    @Override
    public String toString(){
        return "Name is : " + this.path;
    }

    public void set(String nPath){
        this.path = nPath;
    }

    public void add(Object other){
        set(this.path + ((Data)other).path);
    }

    public static void main(String[] args){
        System.out.println("hello world");
    }


}
