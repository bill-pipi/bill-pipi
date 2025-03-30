def flag(string) :
    zs, os, ts = 0, 0, 0
    for i in str(string):
        if i is "0" : zs+=1
        elif i is "1" : os+=1
        elif i is "2" : ts+=1
        else : continue

    return ["0" for z in range(0, zs)] + ["1" for o in range(os)] + ["2" for t in range(ts)]


string = "012121012001211110221021"
print(flag(string))
#['0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2']
string = "444433343563347557863576779789785466585554"
print(flag(string))
#[]
string = False
print(flag(string))
#[]
string = 12111211021102120120011200
print(flag(string))
#['0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2']
string = None
print(flag(string))
#[]
