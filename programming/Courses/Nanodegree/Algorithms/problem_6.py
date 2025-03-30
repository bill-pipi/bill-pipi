def mM(list) :
    if not list : list = [0]
    min, max = list[0], list[0]
    for e in list :
        if not e : e = min
        if e < min : min = e
        if e > max : max = e
    return min, max


print(mM([1, 8, 5, 4, 8, 1, 7, 3, 2, 6, 7, 0, 3, 5]))
#(1, 8)
print(mM([0, 0, 0, 0, 0]))
#(0, 0)
print(mM([]))
#(0, 0)
print(mM([1, 2, 8, 5, 4, 8,5, 9, 8,4, 2, None, 5, 1, 7, 3, 2, 6]))
#(1, 9)
