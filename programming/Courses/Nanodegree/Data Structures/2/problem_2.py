import os


def find_file(path, suffix) :
    path = str(path)
    files = None
    
    try :
        files = os.listdir(path)
    except :
        if os.path.isfile(path) and path.endswith(suffix):
            print(path)
            return
        
        print(None)
        return
    
    for file in files :
        new = os.path.join(path, file)
        if(os.path.isdir(new)) :
            find_file(new, suffix)

        else :
            if(file.endswith(suffix)) :
                print(new)
                continue

            
find_file(None, "c")
#None
find_file(True, "c")
#None
find_file("/Users/rxx/project/testdir/t1.c", "c")
#/Users/rxx/project/testdir/t1.c
find_file(os.getcwd(), "c")
#/Users/rxx/project/testdir/subdir3/subsubdir1/b.c
#/Users/rxx/project/testdir/t1.c
#/Users/rxx/project/testdir/subdir5/a.c
#/Users/rxx/project/testdir/subdir1/a.c
