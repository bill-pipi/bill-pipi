class Heap :

    
    def __init__(self,  type) :
        self.type = type
        self.tree = []
        self.l = 0
                    
        

    def Parent(self, node) :
        return (node-1)//2


      
    def Child(self, n) :
        l, r = (n*2)+1, (n*2)+2
        
        if r > len(self.tree)-1 :
            r = n

        if l > len(self.tree)-1 :
            l = n


        return l, r

        
    def swap(self, a, b) :
        self.tree[a], self.tree[b] = self.tree[b], self.tree[a]

        
    def bubble(self, n) :

        p = self.Parent(n)
        node = self.tree[n]
        
        if n > 0 :
            if self.type :
                if node < self.tree[p] :
                    self.swap(n, p)
                    self.bubble(p)

            else :
                if node > self.tree[p] :
                    self.swap(n, p)
                    self.bubble(p)


    def sink(self, n) :
        l, r = self.Child(n)
        node = self.tree[n]
        left, right = self.tree[l], self.tree[r]

        if self.type:
            c = l if left < right else r

            if node > self.tree[c] :
                self.swap(n, c)
                self.sink(c)


        if not self.type :
            c = l if left > right else r

            if node < self.tree[c] :
                self.swap(n, c)
                self.sink(c)


    def pop(self) :
        end = len(self.tree)-1
        self.swap(end, 0)
        del self.tree[end]
        
        if len(self.tree) >= 1 :
            self.sink(0)

        self.l-=1
        
        

    def add(self, val) :                    
        end = len(self.tree)
        self.tree.append(val)
        self.bubble(end)

        self.l+=1



    def __lt__(self, other) :
        return self.l < other.l


    def root(self) :
        if self.tree :
            return self.tree[0]
        return False
        






    
def even(left, right) :
    while abs(left.l-right.l) > 1 :
        if left > right :
            end = left.root()
            left.pop()
            right.add(end)
            
        if right > left :
            end = right.root()
            right.pop()
            left.add(end)
        

def add(new, left, right) :
    if new < left.root() :
        left.add(new)
        even(left, right)
        
    else :
        right.add(new)
        even(left, right)


def median(list) :
    total = 0
    left, right = Heap(False), Heap(True)
    for i in list :
        add(i, left, right)
        total += middle(left, right)
            
            


    return total%10000


def middle(left, right) :
    mid = left.root()
    if right > left :
        mid = right.root()
    return mid
    

list = []
for i in file("median.txt", "r") :
    list.append(int(i))

print median(list)

    




    
