def find(d, t) :
    for i in d.keys() :
        o = t-i
        if not i is o :
            if o in d :
                return True

    return False

def read(txt) :
    d = dict()
    for r in file(txt, "r") :
        d[int(r)] = True

    return d



d =  read("twosum.txt")
c = 0

for t in range(-10000, 10001) :
    if find(d, t) :
        print c, t
        c+=1

print c
        




    
