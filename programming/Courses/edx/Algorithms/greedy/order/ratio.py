class Node :
    def __init__(self, l, w) :
        self.l = int(l)
        self.w = int(w)


    def ratio(self) :
        return self.w - self.l


    def __lt__(self, other) :
        a = self.ratio()
        b = other.ratio()
        if a > b : return True
        return False


def main(txt) :
    list = []
    for r in file(txt, "r") :
        print r
        l, w = r.split()[0], r.split()[1]
        node = Node(l, w)
        list.append(node)

    return max(list)


print main("jobs.txt")
