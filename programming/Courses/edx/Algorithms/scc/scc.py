
from collections import OrderedDict 



def Node(str) :
    return int(str.split()[0])


def Vertex(str) :
    return int(str.split()[1])


def read(txt) :
    nodes = dict()
    for l in file(txt, "r") :
        node = Node(l)
        vertex = Vertex(l)
        
        if node not in nodes :
            nodes[node] = []
            
        if vertex not in nodes :
            nodes[vertex] = []

            
        nodes[node].append(vertex)

    return nodes


def dfs(nodes, first, visited, map) :
    times = []
    calls = [first]
    while calls:
        node = calls[-1]
        if node not in visited :
            visited[node] = True
            for vertex in nodes[node] :
                if vertex not in visited:
                    calls.append(vertex)
            continue

        calls.pop()
        if node not in map :
            times.append(node)
        map[node] = True

    return times

  

def index(nodes) :
    times = []
    map = dict()
    visited = dict()
    for n in reversed(nodes.keys()) :
        if n not in visited:
            times += dfs(nodes, n, visited, map)

    
    new = dict()
    for i, n in enumerate(times) :
        new[n] = i

    return new


def regraph(nodes, map) :
    new = dict()
    for node in nodes :
        vertices = nodes[node]
        node = map[node]
        for vertex in vertices :
            vertex = map[vertex]

            if vertex not in new :
                new[vertex]=[]

            if node not in new :
                new[node]=[]

            new[vertex].append(node)

    return new



def find(nodes) :
    visited = dict()
    sccs = []
    map = dict()
    for n in reversed(nodes.keys()) :
        if n not in visited:
            scc = dfs(nodes, n, visited, map)
            sccs.append(len(scc))

    sccs.sort()
    print sccs[-5:]


            

    
def main(txt) :
    nodes = read(txt)
    indexes = index(nodes.copy())
    new = regraph(nodes, indexes)
    find(new)
    



main("scc.txt")
    
    

