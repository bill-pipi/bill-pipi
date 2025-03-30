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
        self.matrix = dict()
        
        names = [0]+items.keys()
            
        for n in names :
            column = dict()
            
            for d in range(0, dim+1) :
                column[d] = Item(0,0)

            self.matrix[n] = column


    def unbounded(self) :
       for x in self.items :
            item = self.items[x]
            
            for y in self.matrix[x] :
                opt = self.matrix[x-1][y]
                                
                if item.w <= y :
                    if item > opt :
                        opt = item

                rem = self.matrix[x][y-opt.w]
                new = opt.add(rem)
                self.matrix[x][y] = new      


    def bounded(self) :
        for x in self.items :
            item = self.items[x]
            
            for y in self.matrix[x] :
                opt = self.matrix[x-1][y]
                
                if item.w <= y :
                    rem = self.matrix[x-1][y-item.w]
                    new = item.add(rem)
                    
                    if new > opt : opt = new                                    
                self.matrix[x][y] = opt



    def compile(self, isbound) :
        if isbound :
            self.bounded()
        
        if not isbound :
            self.unbounded()

        return self.matrix


def main(txt, dim, isbound) :
    items = read(txt) 
    knapsack = Knapsack(dim, items)
    matrix = knapsack.compile(isbound)
    x = items.keys()[-1]
    y = matrix[0].keys()[-1]
    return matrix[x][y]

    
print main("knapsack.txt", 10000, True)
        
