import random
import copy


def getN(edge) :
    node = edge.split()[0]
    return node

def getV(edge) :
    vertex = edge.split()[1]
    return vertex

def toEdge(node, vertex) :
    return node + " " + vertex


def merge(edge, edges) :
    node = getN(edge)
    vertex = getV(edge)
    for new in edges[vertex] :
        newVertex = getV(new)
        reverse = toEdge(newVertex, vertex)
        edges[newVertex].remove(reverse)

        if newVertex != node :
            edges[newVertex].append(toEdge(newVertex, node))
            edges[node].append(toEdge(node, newVertex))

        






def randomEdge(edges) :
    list = []
    for value in edges.values() : list+=value
    return random.choice(list)
    
def mincut(edges) :
    if len(edges) == 2 :
        return edges

    edge = randomEdge(edges)
    merge(edge, edges)
        
    del edges[getV(edge)]
    return mincut(edges)

def readEdges(raw) :
    graph = dict()
    for node, vertices in raw.items():
        graph[node] = []
        for vertex in vertices :
            edge = toEdge(node, vertex)
            graph[node].append(edge)
    return graph


def readFile(txt) :
    lines = dict()
    file = open(txt, "r")
    
    for line in file :
        list = line.split()
        lines[list[0]] = list[1:]

    return lines





raw = readFile("min.txt")

for i in range(1, 20000) :
    edges = readEdges(raw)
    number =  mincut(edges).values()
    print len(number[0]), len(number[1])
    print


        






x`            
