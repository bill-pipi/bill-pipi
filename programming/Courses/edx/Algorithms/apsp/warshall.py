inf = float('inf')


def compile(n, arcs) :
    a = dict()
    for i in range(n) :
        a[i] = [inf] * n
        a[i][i] = 0
        
    for e in arcs :
        (x, y, w) = e
        
        a[int(x)-1][int(y)-1] = int(w)
        

    return a


            
def warshall(a) :
    r = range(len(a))
    
    for k in r :
        print k
        for i in r :
            for j in r :
                opt = a[i][k] + a[k][j]
                if opt > a[i][j] :
                    opt = a[i][j]

                a[i][j] = opt

    return a


def read(txt) :
    arcs = []
    for l in file(txt, "r") :
        e = l.split()
        arcs.append(e)

    return arcs


def main(txt) :
    n = 1000
    arcs = read(txt)
    a = compile(n, arcs)
    return warshall(a)


a = main("g3.txt")

shortest = 0
for x in a.values() :
    for y in x :
        if y < shortest :
            shortest = y

print shortest
