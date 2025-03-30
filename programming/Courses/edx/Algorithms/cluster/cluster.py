def flip(string, i) :
    ch = string[i]
    if ch is "1" : ch = "0"
    if ch is "0" : ch = "1"
    return string[:i] + ch + string[i+1:]




def nearest(node, nodes, n, k, edges) :
    if n > k : return
        
    for i in range(0, len(node)-1) :
        new = flip(node, i)
        if new in nodes :
            if new not in edges :
                edges.append((new, n))
        else : 
            nearest(new, nodes, n+1, k, edges)

    
            

def toString(binary) :
    list = binary.split()
    new = ""
    for i in list :
        new += str(i)

    return new
        


def read(txt) :
    nodes = dict()
    for n, binary in enumerate(file(txt, "r")) :
        nodes[toString(binary)] = n
    return nodes


def form(nodes, k) :
    values = dict()
    for binary, n in nodes.items() :
        edges = []
        nearest(binary, nodes, 0, k, edges)
        for (new, n) in edges :
            values[(new, binary)] = n

    return edges
        


nodes = read("clustering.txt")



print form(nodes, 2)
