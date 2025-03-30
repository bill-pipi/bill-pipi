public class Node{

    private Node past;

    public Node(){
        past = null;
    }

    public Node(Object past){
        this.past = (Node)past;
    }

    @Override
    public String toString(){
        if(this.past == null){
            return "Root";
        }
        return past.toString() + "-->" + this.type();
    }

    public String type(){
        return "Node";
    }

}