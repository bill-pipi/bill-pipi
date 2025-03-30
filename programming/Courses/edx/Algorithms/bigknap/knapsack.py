def read(txt) :
    items = dict()
    n = 1
    
    for i in file(txt, "r") :
        v, w = i.split()
        items[n] = Item( int(v), int(w) )
        n+=1
        
    return items
        
        

class Item :
    def __init__(self, value, weight) :
        self.w = weight
        self.v = value


    def add(self, other) :
        return Item(self.v+other.v, self.w+other.w)


    def __str__(self) :
        return "Value : " + str(self.v) + "," + " Weight : " + str(self.w)



    def __lt__(self, other) :
        return self.v < other.v


class Knapsack :
    def __init__(self, dim, items) :
        self.dim = dim
        self.items = items
        self.matrix = []
        names = items.keys()
        
        self.matrix.append([Item(0,0)]*dim)
            
        for n in names :
            self.matrix.append([])

            

        
    def bounded(self) :
        
        for x in self.items.keys() :
            
            item = self.items[x]
            print x, item
            
            for y in range(0, self.dim) :

                opt = self.matrix[x-1][y]
                
                if item.w <= y :
                    rem = self.matrix[x-1][y-item.w]
                    new = item.add(rem)
                    
                    if new > opt : opt = new                                    
                self.matrix[x].append(opt)





    def compile(self) :
        self.bounded()
        return self.matrix


def main(txt, dim) :
    items = read(txt) 
    knapsack = Knapsack(dim+1, items)
    matrix = knapsack.compile()
    return matrix[-1][-1]

print main("knapsack_big.txt", 2000000)
