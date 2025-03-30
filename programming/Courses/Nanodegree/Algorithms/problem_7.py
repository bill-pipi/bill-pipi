class Node:
    def __init__(self, value):
        self.value = value
        self.handler = "404 error page"
        self.children = {}

        
    def append(self, char):
        self.children[char] = Node(char)

        
class Trie :
    def __init__(self, defualt) :
        self.default = defualt
        self.root = Node("")
        self.root.children["home"] = Node("home")

        
    def node(self, path, node) :
        if path :
            if path[0] not in node.children :
                return self.default
            
            next = node.children[path[0]]
            return self.node(path[1:], next)
        
        return node.handler


    def add(self, path, node, handler) :
        if not path :
            node.handler = handler
            return

        else :
            if path[0] not in node.children : node.append(path[0])
            next = node.children[path[0]]
            self.add(path[1:], next, handler)

            
    def append(self, path, handler) : self.add(path[1:], self.root.children["home"], handler)
    
    
    def find(self, path) : return self.node(path, self.root)

        
def split(route): return route.split('/')
    
class Router:
    def __init__(self, default):
        self.trie = Trie(str(default))
        
    def find(self, route):
        return self.trie.find(split(str(route)))

    def add(self, route, handler):
        self.trie.append(split(str(route)), handler)


default = "Error page"
router = Router(default)
router.add("home/about/me", "about me")
router.add("home/about/you", "about you")
print(router.find("home/about/you"))
print(router.find("home/about/me"))
print(router.find("home/about/who?"))
print()
#about me
#about me
#Error page song La La La
router = Router(default)
router.add("nowhere/", "bothing")
print(router.find("nowhere/"))
print()
#Error page, not in home
router = Router(default)
router.add("home/False", False)
print(router.find("home/False"))
print()
#False
router = Router(default)
router.add("home/None", None)
print(router.find("home/None"))
print()
#None
router = Router(False)
print(router.find("home/"))
#False



    


    


            
        

