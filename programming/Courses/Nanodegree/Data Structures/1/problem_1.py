class Node :
    
    def __init__(self, value) :
        self.value = value
        self.previous = None
        self.next = None


        
class LinkedList :
    def __init__(self) :
        self.head = None
        self.tale = None


    def toString(self):
        node = self.head        
        while node :
            print(node.value[1], end = ' -> ')
            node = node.next
        


    def shift(self, node) :
        shift = None
        if node is self.tale :
            return

        elif node is self.head :
            past = self.head
            self.head = past.next
            self.head.previous = None
            shift = past


        else :
            before = node.previous
            after = node.next
            before.next = after
            after.previous = before
            shift = node

        self.tale.next = shift
        shift.previous = self.tale
        self.tale = shift
        self.tale.next = None


        
    def append(self, node) :
        if self.head is None :
            self.tale = node
            self.head = node

        elif self.head.next is None :
            self.tale = node
            self.head.next = self.tale
            self.tale.previous = self.head

        else :
            self.tale.next = node
            node.previous = self.tale
            self.tale = node

            

    def pop(self) :
        past = self.head
        if self.tale is self.head :
            self.tale = None
            self.head = None
            return past
        
        self.head = past.next
        past.next = None
        self.head.previous = None
        return past





class Cache :

    
    def __init__(self, capacity) :
        self.capacity = capacity
        self.history = dict()
        self.cache = LinkedList()


    def get(self, key) :
        try :
            node = self.history[key]
            self.cache.shift(node)
            return node.value[1]

        except :
            return -1

        
    def set(self, key, value) :
        try :
            self.cache.shift(self.history[key])

        except :
            node = Node([key, value])
            self.cache.append(node)
            self.history[key] = node


        if len(self.history) > self.capacity :
            popped = self.cache.pop()
            self.history.pop(popped.value[0])

                
        
cache = Cache(2)
cache.set(1, "a")
print(cache.cache.toString())
cache.set(2, "b")
print(cache.cache.toString())
cache.set(None, "d")
print(cache.cache.toString())
print(cache.get(None))
print(cache.cache.toString())
print(cache.get(1))
print(cache.cache.toString())
print(cache.get(2))
print(cache.cache.toString())
#a -> None
#a -> b -> None
#b -> d -> None
#d
#b -> d -> None
#-1
#b -> d -> None
#b
#d -> b -> None


print()
print()

cache = Cache(True)
cache.set(1, "a")
print(cache.cache.toString())
cache.set(2, "b")
print(cache.cache.toString())
cache.set(None, "d")
print(cache.cache.toString())
print(cache.get(None))
print(cache.cache.toString())
print(cache.get(1))
print(cache.cache.toString())
print(cache.get(2))
print(cache.cache.toString())
cache.set(2, 2)
print(cache.cache.toString())
#a -> None
#b -> None
#d -> None
#d
#d -> None
#-1
#d -> None
#-1
#d -> None
#2 -> None



print()
print()

cache = Cache(2)
cache.set(1, "a")
print(cache.cache.toString())
cache.set(2, "b")
print(cache.cache.toString())
cache.set(2, "b")
print(cache.cache.toString())
cache.set(2, "b")
print(cache.cache.toString())
print(cache.get(2))
print(cache.cache.toString())
print(cache.get(1))
print(cache.cache.toString())
print(cache.get(3))
print(cache.cache.toString())
cache.set(4, "d")
print(cache.cache.toString())
print(cache.get(4))
print(cache.cache.toString())
print(cache.get(1))
print(cache.cache.toString())
print(cache.get(2))
print(cache.cache.toString())
print()
#a -> None
#a -> b -> None
#a -> b -> None
#a -> b -> None
#b
#a -> b -> None
#a
#b -> a -> None
#-1
#b -> a -> None
#a -> d -> None
#d
#a -> d -> None
#a
#d -> a -> None
#-1
#d -> a -> None


cache = Cache(0)
cache.set(1, "a")
print(cache.cache.toString())
cache.set(2, "b")
print(cache.cache.toString())
cache.set(None, "d")
print(cache.cache.toString())
print(cache.get(None))
print(cache.cache.toString())
print(cache.get(1))
print(cache.cache.toString())
print(cache.get(2))
print(cache.cache.toString())
#None
#None
#None
#-1
#None
#-1
#None
#-1
#None
