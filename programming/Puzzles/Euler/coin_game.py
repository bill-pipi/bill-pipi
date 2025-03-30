#0                           1
#1                           1
#0(2)  1(1)                  2
#0(3)  1(2)                  1+2=3
#0(4)  1(3) 2(2)             1+3+2-1=5     
#0(5)  1(4) 2(3)             1+5+(3-2)  =7      
#0(6)  1(5) 2(4) 3(3)        1+7+5-3+1=11
#0(7)  1(6) 2(5) 3(4)        1+11+7-5+1=15
#0(8)  1(7) 2(6) 3(5) 4(4)   1+15+11-7+7-6

def sum(dict) :
    c = 0
    for i in dict : c+= dict[i]
    return c

coins = {}
coins[0] = {0:0}
coins[1] = {0:1}
coins[2] = {0:1, 1:1}
coins[3] = {0:1, 1:sum(coins[2])}
coins[4] = {0:1, 1:sum(coins[3]), 2:sum(coins[2])-coins[2][1]}
coins[5] = {0:1, 1:sum(coins[4]), 2:sum(coins[3])-coins[3][1]}
coins[6] = {0:1, 1:sum(coins[5]), 2:sum(coins[4])-coins[4][1], 3:sum(coins[3])-coins[3][1]}
coins[7] = {0:1, 1:sum(coins[6]), 2:sum(coins[5])-coins[5][1], 3:sum(coins[4])-coins[4][1]-coins[4][2]}
coins[8] = {0:1, 1:sum(coins[7]), 2:sum(coins[6])-coins[6][1], 3:sum(coins[5])-coins[5][1]-coins[5][2], 4:sum(coins[4])-coins[4][1]-coins[4][2]}
coins[9] = {0:1, 1:sum(coins[8]), 2:sum(coins[7])-coins[7][1], 3:sum(coins[6])-coins[6][1]-coins[6][2], 4:sum(coins[5])-coins[5][1]-coins[5][2]}

for n in range(3, 100) :
    coins[n]={0:1} 
    for i in range(1,(int)(n/2)) : 
        coins[n][i] = sum(coins[n-i])
        
        for x in range(1,i-1) : 
            try :
                coins[i] -= coins[n-i][x]
            except : 
                pass
    print(n, coins[n])

