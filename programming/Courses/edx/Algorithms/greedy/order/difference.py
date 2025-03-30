class Node :
    def __init__(self, l, w) :
        self.l = int(l)
        self.w = int(w)


    def dif(self) :
        return self.w - self.l


    def __lt__(self, other) :
        a = self.dif()
        b = other.dif()
        if a > b :
            return True

        if a == b :
            if self.w > other.w :
                return True

            if self.w < other.w :
                return False

        
        else :
            return b



def main(txt) :
    list = []
    for r in file(txt, "r") :
        print r
        l, w = r.split()[0], r.split()[1]
        node = Node(l, w)
        list.append(node)

    return max(list)


print main("jobs.txt")
