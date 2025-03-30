class Directory :
    def __init__(self, name) :
        self.name = name
        self.children = []

    def add(self, child) :
        self.children.append(child)


def inDirectory(user, directory) :
    if not directory :
        return
    
    if len(directory.children) == 0 :
        if directory.name is user :
            print(True)
            return

    for child in directory.children :
        inDirectory(user, child)

        
parent = None
inDirectory("1", parent)
print()
#Nothing, it doesn't exist
parent = Directory("Parent")
adult = Directory("Child")
sibling = Directory("Sibling")
cousin = Directory("Cousin")
child = Directory("Child")
new = Directory("New")
adult.add(child)
adult.add(new)
sibling.add(cousin)
parent.add(sibling)
parent.add(adult)
inDirectory(None, parent)
print()
#Nothing, it doesn't exist
parent = Directory("Parent")
adult = Directory("Child")
sibling = Directory("Sibling")
cousin = Directory(False)
child = Directory("Child")
new = Directory("New")
adult.add(child)
adult.add(new)
sibling.add(cousin)
parent.add(sibling)
parent.add(adult)
inDirectory(False, parent)
print()
#False exists in the directory
parent = Directory("Parent")
adult = Directory("Child")
sibling = Directory("Sibling")
cousin = Directory("Cousin")
child = Directory("Child")
new = Directory("New")
adult.add(child)
adult.add(new)
sibling.add(cousin)
parent.add(sibling)
parent.add(adult)
inDirectory("Baby", parent)
#Nothing, it doesn't exist
