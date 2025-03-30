class Heap :
    def __init__(self) :
        self.next = -1
        self.nodes = []

        

    def max(self, a, b) :
        if self.nodes[a] > self.nodes[b] : return a
        return b
    
    
    def rotateUp(self, index) :
        self.nodes[index] = int(self.nodes[index] or 0)
        parent = (index-1) // 2
        if self.nodes[index] > self.nodes[parent] and index != 0:
            self.nodes[index], self.nodes[parent] = self.nodes[parent], self.nodes[index]
            self.rotateUp(parent)

        else :
            return

    def add(self, data) :
        self.next+=1
        self.nodes.append(data)
        self.rotateUp(self.next)


        
    def rotateDown(self, index) :
        left = (index*2) + 1 
        right = left + 1
        
        if left < self.next :
            if right == self.next : right = index
                
            greater = self.max(left, right)
            if self.nodes[greater] > self.nodes[index] :
                self.nodes[greater], self.nodes[index] = self.nodes[index], self.nodes[greater]
                self.rotateDown(greater)
            else :
                return
            
        return
        
    def pop(self) :
        self.nodes[0], self.nodes[self.next] = self.nodes[self.next], self.nodes[0]
        root = self.nodes.pop()
        self.rotateDown(0)
        self.next = self.next-1
        return root



def heapify(list) :
    heap = Heap()
    for e in list : heap.add(e)
    return heap

def deheapify(heap) :
    list = []
    while len(heap.nodes) != 1 : list.append(heap.pop())
    list.append(heap.nodes[0])
    return list

def heapSort(list) : return deheapify(heapify(list))



def rearrange(list) :
    if len(list) > 1 :
        a, b = "", ""
        list = heapSort(list)
        for i in range(0, len(list)//2) :
            a += str(list[i*2])
            b += str(list[(i*2)+1])
        return int(a), int(b)
    
    if not list : return None, None
    return list[0], None


print(rearrange([1, 2, False, 3, 4, 5, 6,6]))
#('6531', '6420')
print(rearrange([1, 2, 3, None, 4, 5, 6]))
#(642, 531)
print(rearrange([1]))
#(1, None)
print(rearrange([]))
#(None, None)
print(rearrange([1, 4, 8, 3, 5, 7, 9, 2, 6]))
#(9753, 8642)

