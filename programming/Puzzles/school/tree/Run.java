import java.util.*;

public class Run {
    
    public static void main(String[] args){

        List<Node> list = new List<Node>();

        //Tree1
        Node a = Node();
        Node b = Stem(a, "1");
        Leaf c = Leaf(b, "Red");
        Leaf d = Leaf(b, "Blue");
        c.tint("Black");

        list.add(c);
        list.add(d);

        //Tree2
        Node d = Stem();
        Node e = Stem(d, "8");
        Stem f = Stem(e, "14");       
        Node g = Node(f); 
        f.lengthen(-100);

        list.add(g);

        //Tree3
        Node h = Node();
        list.add(h);

        //Tree4
        Leaf i = Leaf();
        list.add(i);

        //Tree5
        Stem j = Stem();
        list.add(j);

        for(Node n : list){
            System.out.println(n);
        }


    }

}
