class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

    def toString(self):
        if self.next is None: 
            print(self.value)
            return
        
        print(self.value, end = '-> ')
        self.next.toString()

        
class LinkedList:
    def __init__(self):
        self.head = Node(None)

    def add(self, value) :
        node = Node(value)
        if not self.head.value :
            self.head = node
            return
        
        node.next = self.head
        self.head = node
        

def linkToList(link) :
    l = []
    node = link.head
    while node :
        l.append(node.value)
        node = node.next
    return l


def listToLink(l) :
    link = LinkedList()
    for i in l : link.add(i)
    return link


def union(linkOne, linkTwo):
    values = dict()
    node = linkOne.head
    
    while node :
        values[node.value] = node.value
        node = node.next
        
    node = linkTwo.head
    
    while node :
        try :
            values[node.value]
        except :
            values[node.value] = node.value
        node = node.next

    return listToLink(values.keys())
    pass


def intersection(linkOne, linkTwo):
    link = LinkedList()
    values = dict()
    node = linkOne.head

    while node :
        values[node.value] = node.value
        node = node.next

    node = linkTwo.head

    while node :
        try :
            link.add(values[node.value])
            values.pop(node.value)
        except KeyError:
            pass
        node = node.next

    return link
    pass


link = LinkedList()
link.head.toString()
link2 = listToLink([4, 3, 7, 2, 5, 1])
link2.head.toString()
intersection(link, link2).head.toString()
union(link, link2).head.toString()
#None
#1-> 5-> 2-> 7-> 4
#None
#4-> 3-> 7-> 2-> 5-> 1
print()

link = listToLink([False])
link.head.toString()
link2 = listToLink([False])
link2.head.toString()
intersection(link, link2).head.toString()
union(link, link2).head.toString()
#False
#False
#False
#False
print()

link = listToLink([8, 6, 13, 20, 5])
link.head.toString()
link2 = listToLink([4, 3, 7, 2, 1])
link2.head.toString()
intersection(link, link2).head.toString()
union(link, link2).head.toString()
#5-> 20-> 13-> 6-> 8
#1-> 2-> 7-> 3-> 4
#None
#4-> 3-> 7-> 2-> 1-> 8-> 6-> 13-> 20-> 5
print()

link = LinkedList()
link.head.toString()
link2 = LinkedList()
link2.head.toString()
intersection(link, link2).head.toString()
union(link, link2).head.toString()
#None
#None
#None
#None
print()
