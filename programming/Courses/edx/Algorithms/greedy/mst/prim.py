class Cluster :
    def __init__(self, nodes) :
        self.pointers = dict()
        self.l = len(nodes)
        
        for n in nodes :
            self.pointers[n] = n


    def find(self, n) :
        p = self.pointers[n]
        if p == n : return p
        return self.find(p)


    def union(self, a, b) :
        pA, pB = self.find(a), self.find(b)
        self.l-=1
        self.pointers[pA] = pB

            

class Edge :
    def __init__(self, a, b, w) :
        self.a = a
        self.b = b
        self.w = w


    def __lt__(self, other) :
        return self.w < other.w



def Kruskal(nodes, edges, k) :
    total = 0
    cluster = Cluster(nodes)
    
    for e in edges :
        if cluster.l != k :
            if cluster.find(e.a) != cluster.find(e.b) :
                cluster.union(e.a, e.b)
                total+=e.w
        else :
            break

    return cluster, total


def read(txt) :
    nodes, edges = dict(), []
    
    for r in file(txt, "r") :
        
        (a, b, w) = r.split()
        a, b, w = int(a), int(b), int(w)
        
        nodes[a], nodes[b] = True, True
        
        e = Edge(a, b, w)
        edges.append(e)


    return nodes, edges


def main(txt, k) :
    nodes, edges = read(txt)
    edges.sort()
    print Kruskal(nodes, edges, k)
   
    
main("edges.txt", 1)
 
