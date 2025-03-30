public class Stem extends Node{
    
    private String length = 1;

    public Stem(){
    }

    public Stem(Node prev, int l){
        super(prev);
        lengthen(l);
    }

    @Override
    public String toString(){
        return super.toString() + " (Length) : " + this.length;
    }

    public String type(){
        return "Stem";
    }

    public void lengthen(int l){
        if(l > 0) this.length = l;
    }


}
