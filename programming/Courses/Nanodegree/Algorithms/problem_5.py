class Node:
    def __init__(self, word, value):
        self.word = False
        self.value = value
        self.children = {}

        
    def append(self, char):
        self.children[char] = Node(False, char)



class Trie :
    def __init__(self) :
        self.root = Node(True, "")

        
    def node(self, word, node) :
        if word :
            if word[0] not in node.children :
                return None
            
            next = node.children[word[0]]
            return self.node(word[1:], next)
        
        return node


    def add(self, word, node) :
        if not word :
            node.word = True
            return

        else :
            if word[0] not in node.children : node.append(word[0])
            next = node.children[word[0]]
            self.add(word[1:], next)

    def append(self, word) :
        self.add(str(word), self.root)
    
    
    def exists(self, word) :
        node = self.node(str(word), self.root)
        if node : return node.word
        return False

    
    def traverse(self, node, word, words) :
        if node.children :
            for next in node.children.values() :
                new = word + next.value
                self.traverse(next, new, words)

        if node.word : words.append(word)
        return

    def suggest(self, suffix) :
        words = []
        node = self.node(suffix, self.root)
        if node :
            self.traverse(node, "", words)
            words = [word for word in words]
        return words
            
        
        
        
trie = Trie()
trie.append("9huiji")
trie.append("happy")
trie.append("hello")
trie.append("heat")
trie.append("he")
trie.append("heapsort")
print(trie.exists("he"))
print(trie.exists("heap"))
print(trie.suggest("he"))
#False
#True
#['llo', 'at', 'apsort', '']
print()
trie = Trie()
print(trie.exists("hello"))
print(trie.suggest("he"))
#False
#[]
print()
trie = Trie()
trie.append(True)
print(trie.exists(False))
print(trie.suggest(""))
#False
#['True']
print()
trie = Trie()
trie.append(None)
print(trie.exists(None))
print(trie.suggest(""))
#True
#['None']
