inf = float('inf')


class A :

    def __init__(self, m, nodes) :
        self.A = dict()

        for n in nodes :
            self.A[n] = [inf] * m


class Ford :


    def __init__(self, nodes, arcs) :
        self.arcs = arcs
        m = len(arcs)
        
        self.A = A(m, nodes)


    def root(self, node) :
        for r in self.arcs[node] :
            
            w = self.arcs[node][r]

            if w not inf : return r, w
                
                
        

    def compile(self) :
        
        for n in self.A :
            r = range(self.A[n])
            
            for i in r :
                opt = self.A[n][i-1]
                r, w = self.root(n)
                new = self.A[r][i-1] + w

                if new > opt : opt = new

                self.A[n][i-1] = opt
                


print None < 1
