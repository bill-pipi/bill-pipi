
class Heap :

    
    def __init__(self, tree) :
        self.tree = []
        self.length = 0
        
        for i in tree :
            self.add(i)
    

    def Parent(self, node) :
        return (node-1)//2


    def swap(self, a, b) :
        self.tree[a], self.tree[b] = self.tree[b], self.tree[a]

        
    def bubble(self, node) :
        parent = self.Parent(node)
        
        if node > 0 :
            if self.tree[node] < self.tree[parent] :
                self.swap(node, parent)
                self.bubble(parent)
                
        return


    def find(self, node) :
        if node < self.length-1 :
            return node
        
        return self.Parent(node)

    
    def Child(self, node) :
        a = self.find((node*2)+1)
        b = self.find((node*2)+2)
            
        if self.tree[a] < self.tree[b] :
            return a

        return b

 
            
    def sink(self, node) :
        child = self.Child(node)
        
        if self.tree[node] > self.tree[child] :
            self.swap(node, child)
            self.sink(child)
                
        
    def min(self) :
        return self.tree[0]

    
    def delete(self) :
        node = self.length-1
        self.swap(node, 0)
        del self.tree[node]
        self.length-=1
        
        if self.length > 1 :
            self.sink(0)
        

    def add(self, node) :
        self.length+=1
        self.tree.append(node)
        self.bubble(self.length-1)



    def set(self, index, new) :
        self.tree[index] = new
        self.sink(index)

