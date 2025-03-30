import random as rando

#Outside variables
l= {}
g = {}
c = ""
limbs = 0
n = 11
x = 100
words = open("wordlist.txt", "r").readlines()


#Read txt 
def read(txt) :
    with open(str(txt) + ".txt") as file :
        print(file.read())


#Return list of dictionary keys
def keys(dic) :
    keys = []
    for k, v in dic.items() : 
        keys.append(k)
    return keys


    #Replace character in string
def rep(str, i, ch) :
    return str[:i] + ch + str[i+1:]


#Add new page
def newPage() :
    for i in range(1, x) : 
        print()


#Generate word
def generate() :
    i = rando.randint(0, 9999)
    return words[i][:-1]






#Initialize for a new word
def init(word) :
    global c, l, limbs, g

    l= {}
    g = {}
    c = ""
    limbs = 0

    i = 0
    for ch in word :
        c += "_"

        if(ch not in l) :
            l[ch] = [i]
        else : 
            l[ch].append(i)

        i += 1



#Enter character
def tryCh(ch) :
    global c, limbs

    if(ch not in g) :
        g[ch] = True

        if(ch in l) : 
            for i in l[ch] :  c = rep(c, i, ch)
            return "New Letter!"

        limbs+=1;
        return "Wrong Letter"
    
    return "Guessed Already"


#Return statistics 
def stats() :
    print(c)
    read(limbs)
    print("Letters guessed: " + str(keys(g)))
    if(n == limbs) : 
        print("GAME OVER")
        return

    print("Still have " + str(n - limbs) + " limbs left")


#Main hangman body
def hang(word) :
    init(word)

    while(limbs <= n) :
        

        ch = input("Type a letter: ")
        newPage()
        print(tryCh(ch))
        if(word == c) :
            print("CONGRATULATIONS \nCONGRATULATIONS")
            return

        stats()

    print("ur bad")
    print("anyways")
    print("here's the word")
    print(word)

#Main
def main() :
    prompt = "\n\n\n\nWould you like to play hangman? (y/n)"
    while(True) : 
        play = input(prompt).lower() == "y"
        if(not play) : 
            print("ok")
            return

        prompt = "Try Again? (y/n)"

        
        hang(generate())
        


main()

        



