public class Leaf extends Node{
    private String color = "Green";
    
    public Leaf(){
    }
    
    public Leaf(Node prev, String color){
        super(prev);
        tint(color);
    }
    
    @Override
    public String toString(){
        return super.toString() + " (Color) : " + this.color;
    }
    
    public String type(){
        return "Leaf";
    }
    
    public void tint(String color){
        switch(color) {
            case "Red" : this.color = "Red";
            case "Orange" : this.color = "Orange";
            case "Yellow" : this.color = "Yellow";
            case "Green" : this.color = "Green";
            case "Blue" : this.color = "Blue";
            case "Purple" : this.color = "Purple";
            default : ;
        }
    }   
}
