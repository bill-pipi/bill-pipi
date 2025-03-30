import math


def h(a, b, cities) : 
    aToA = cities[a][0] - cities[b][0]
    bToB = cities[a][1] - cities[b][1]
    return math.sqrt((aToA**2) + (bToB**2))
    

def f(next, finish, cities, front, frontier)  : 
    return h(next, finish, cities) + h(front, next, cities) + frontier[front][0] - h(front, finish, cities)


    
def aStar(cities, roads, frontier, start, finish) : 
    front = min(frontier.keys(), key = lambda f: frontier[f][0])
    if finish in frontier: 
        #If there could still be another value
        if frontier[front][0] < frontier[finish][0] : 
            frontier.pop(finish)
            return aStar(cities, roads, frontier, start, finish, route)
        #Return the shortest route
        return frontier[finish][1]
    
    else :
        #Expand the shortest path
        for next in roads[front] : 
            #Calculate F
            new = f(next, finish, cities, front, frontier)
            #If the next city has already been traveled to
            if next in frontier : 
                #If the next path is slower than the current path
                if frontier[next][0] < new : continue
            #Else, set the next to new
            frontier[next] = new, frontier[front][1]+[next]
            
        #Remove front
        frontier.pop(front)
        return aStar(cities, roads, frontier, start, finish)
    
    
    

def shortest_path(map, start, finish) :
    cities, roads = map.intersections, map.roads
    return aStar(cities, roads, {start: (h(start, finish, cities), [start])}, start, finish)

        