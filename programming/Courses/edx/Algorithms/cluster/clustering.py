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
        if pA != pB :
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
    cluster = Cluster(nodes)
    
    for e in edges :
        if cluster.l != k :
            cluster.union(e.a, e.b)
        else :
            break

    return cluster


def read(txt) :
    nodes, edges = dict(), []
    
    for r in file(txt, "r") :
        
        (a, b, w) = r.split()
        a, b, w = int(a), int(b), int(w)
        
        nodes[a], nodes[b] = True, True
        
        e = Edge(a, b, w)
        edges.append(e)


    return nodes, edges


def maxSpacing(edges, cluster) :
    for e in edges :
        a, b = e.a, e.b
        if cluster.find(a) != cluster.find(b) :
            return a, b, e.w
        
    return


def main(txt, k) :
    nodes, edges = read(txt)
    edges.sort()
    kruskal = Kruskal(nodes, edges, k)
    print maxSpacing(edges, kruskal)
        
    
main("clustering.txt", 4)
