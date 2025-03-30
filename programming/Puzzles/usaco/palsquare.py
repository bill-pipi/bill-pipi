"""
ID: bill.pi1
LANG: PYTHON3
TASK: palsquare
"""
import math

b = int(open("palsquare.in", "r").read())
f = open("palsquare.out", "a")

def convert_base(num : int, i : int, out : str):
    if(i < 0) :
        return out    
    
    x = math.pow(b, i)
    print(num/x)
    if(int(num / x) < b) : 
        out += str(int(num / x))
        num = int(num % x)
        return convert_base(num, i-1, out)

    return ""

for n in range(1, 300):

    sq = convert_base(n*n, int(math.log(n*n) / math.log(b)), "")
    n = convert_base(n, int(math.log(n) / math.log(b)), "")
    if(sq == sq[::-1]) : f.write(str(n) + " " + sq +"\n")


f.close()