class Tree :
    def __init__(self, value, left = None, right = None) :
        self.data = value
        self.left = left
        self.right = right

#n
def toNodes(sentence) :
    data = []
    for c in list(set(sentence)) :
        data.append(Tree([c, sentence.count(c)]))
    data.sort(key = lambda x : x.data[1])
    return data 

#n
def toTree(data) :
    if len(data) == 1 :
        return data[0]

    smallest = data[:2]
    bottom = Tree(["" , smallest[0].data[1] +  smallest[1].data[1]])
    bottom.left = smallest[0]
    bottom.right = smallest[1]
    new = data[2:]
    new.append(bottom)
    new.sort(key = lambda x : x.data[1])
    return toTree(new)

#n
def findPath(tree, curr, crypt) :
    if tree.left or tree.right :
        left = curr+"0"
        findPath(tree.left, left, crypt)
        right = curr+"1"
        findPath(tree.right, right, crypt)
        
    crypt[tree.data[0]] = curr
    return

#n
def key(tree) :
    crypt = {}
    if tree.left is None and tree.right is None :
        crypt[tree.data[0]] = "1"
        return crypt
    
    findPath(tree, "", crypt)
    crypt.pop('')
    return crypt

#4n
def encode(string) : 
    string = str(string)
    if(len(string) == 0) : return "", Tree(["", 0])
        
    string = string.lower()
    root = toTree(toNodes(string))
    keys = key(root)
    encoded = ""
    
    for ch in string : encoded += keys[ch]
    return [encoded, root]


def decode(code, keys, message) :
    if len(code) == 0 : return message
    for ch, co in keys.items():
        if co == code[0:len(co)] :
            return decode(code[len(co):], keys, message+ch)




encoded = encode(None)
print(key(encoded[1]))
print(encoded[0])
print(decode(encoded[0], key(encoded[1]), ""))
#{'n': '0', 'e': '10', 'o': '11'}
#011010
#none
print()

encoded = encode(True)
print(key(encoded[1]))
print(encoded[0])
print(decode(encoded[0], key(encoded[1]), ""))
#{'t': '00', 'r': '01', 'u': '10', 'e': '11'}
#00011011
#true
print()

encoded = encode("AAAAAAAAAAAAA")
print(key(encoded[1]))
print(encoded[0])
print(decode(encoded[0], key(encoded[1]), ""))
#{'a': '1'}
#1111111111111
#aaaaaaaaaaaaa
print()

encoded = encode("")
print(key(encoded[1]))
print(encoded[0])
print(decode(encoded[0], key(encoded[1]), ""))
#{'': '1'}
print()

encoded = encode("Hello World")
print(key(encoded[1]))
print(encoded[0])
print(decode(encoded[0], key(encoded[1]), ""))
#{'r': '000', ' ': '001', 'w': '010', 'h': '011', 'l': '10', 'o': '110', 'd': '1110', 'e': '1111'}
#01111111010110001010110000101110
#hello world
