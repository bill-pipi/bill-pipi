def pivot(list, a, b):       
    mid = (a + b) // 2
    if list[a] is None : list[a] = 0
    if a != b :
        if list[a] < list[mid] : return pivot(list, mid, b)
        else : return pivot(list, a, mid)
    return mid
        

def binary(list, a, b, n) :
    if a <= b:
        mid = (a + b) // 2
        if list[mid] != n :
            if n > mid : return binary(list, mid+1, b, n)
            else : return binary(list, a, mid-1, n)
        return mid
    return -1



def find(n, list) :
    if not n : n = 0
    if not list : return -1
        
    piv = pivot(list, 0, len(list)-1)+1
    if n >= list[0] and n <= list[pivot-1] : return binary(list[:piv], 0, piv, n)
    else :
        index = binary(list[piv:], 0, len(list)-piv, n)
        if index != -1 : return index+piv
        return index

    
list = [5, 6, 1, 2, 2, 3, 4]
print(find(3, list))
#5
list = [5, 6, False, 3, 4]
print(find(False, list))
#2
list = []
print(find(8, list))
#-1
list = [3, 4, None, 5, 6, 1, 3, 4]
print(find(None, list))
#-1

