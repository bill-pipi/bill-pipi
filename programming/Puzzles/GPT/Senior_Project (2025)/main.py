#Import two classes
from letter_generator.let_gen import let_gen
from project_reader.proj_read import proj_read



#Run letter generator
def run_lg(settings_txt):

    print("Run Block: ")
    index = int(input())

    #Read settings and alter index
    with open(settings_txt, 'r') as file:

        settings = file.readlines()
        settings[0] = index

        #Init and run generator
        generator = let_gen(settings = settings)
        generator.run()



#Run project reader
def run_pr(settings_txt):

    print("Proposal id: ")
    id = int(input())

    #Read settings into iterable
    with open(settings_txt, 'r') as file:
        settings = file.readlines()
        settings[0] = id

        #Init and run reader
        reader = proj_read(settings = settings)
        reader.run()
        


#Main method
def __main__():
    if(__name__ == "__main__"): 
        
        
        #run_lg('settings_lg.txt')
        run_pr('settings_pr.txt')
        


    
__main__()







