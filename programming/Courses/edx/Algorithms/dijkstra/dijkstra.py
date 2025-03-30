import numpy as np


class Arc :
    def __init__(self, n, w) :
        self.n = n
        self.w = w


    def __lt__(self, other) :
        return other.w > self.w


def getArcs(l) :
    arcs = []
    n = l[0]
    for a in l[1:] :
        v, w = a.split(",")
        arcs.append(( int(n), int(v), int(w) ))

    return arcs





def readArcs(txt, dim) :
    arcs = np.empty(dim)
    
    for i in file(txt, "r") :
        l = i.split()

        for (n, v, w) in getArcs(l) :
            arcs[n-1][v-1] = w

    return arcs
            

def Vertices(matrix, node) :
    arcs = []
    for i in range(0, len(matrix)) :
        
        w = matrix[node.n][i]

        if w != 0 :
            arcs.append((i, w))

    return arcs


def Next(outside) :
    return min(outside.values())



def dijkstra(matrix, pivot) :
    
    mold = dict()
     outside = {pivot : Arc(pivot, 0)}
    
    while outside :
        next = Next(outside)
        del outside[next.n]
        
        if next.n not in mold :
            
            print next.n, "w", next.w

            mold[next.n] = next.w
            vertices = Vertices(matrix, next)
        
            for (n, w) in vertices :
                w = next.w+w
            
                if n in outside :
                    if w > outside[n].w :
                        continue

                outside[n] = Arc(n, w)

    return mold
594 615 328 275 1193
                    

                    
        

        
    


    
        

print dijkstra(readArcs("dijkstra.txt", (200, 200)), 0)









                
  




    
