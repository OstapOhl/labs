class Node:
    def __init__(self, year_of_produce, name, type, m_limit):
        self.left = None
        self.right = None
        self.data = year_of_produce
        self.name = name
        self.type = type
        self.m_limit = m_limit


class Tree:
    root = None
    def __init__(self):
        self.root = None


    def insert(self, year_of_produce, name, type, m_limit):

        if self.root is None:
            self.root = Node(year_of_produce, name, type, m_limit)
            return
        if year_of_produce < self.root.data:
            if self.root.left is None:
                self.root.left = Tree()
            self.root.left.insert(year_of_produce, name, type, m_limit)
        else:
            if self.root.right is None:
                self.root.right = Tree()
            self.root.right.insert(year_of_produce, name, type, m_limit)

    def find(self, year_of_produce):
        if self.root is None:
            return None
        if year_of_produce == self.root.data:
            return self.root.data, self.root.name, self.root.type, self.root.m_limit   
        if year_of_produce < self.root.data:
            if self.root.left is None:
                return None
            return self.root.left.find(year_of_produce)
        else:
            if self.root.right is None:
                return None
            return self.root.right.find(year_of_produce)

    def print(self):
        if self.root is None:
            return "none"
        if self.root.left:
            self.root.left.print()
        print(self.root.data, " - ", self.root.name, " - ", self.root.type, " - ", self.root.m_limit,)

        if self.root.right:
            self.root.right.print()

    def printSortedByMaxLimit(self, m_limit):
        if self.root is None:
            return "none"
        if self.root.m_limit >= m_limit:
            print(self.root.data, " - ", self.root.name, " - ", self.root.type, " - ", self.root.m_limit,)
        
        if self.root.left:
            self.root.left.printSortedByMaxLimit(m_limit)

        if self.root.right:
            self.root.right.printSortedByMaxLimit(m_limit)


    def delete_node(self, current_node, year_of_produce) -> Node or None:


        deleted = self.find(year_of_produce)
        if deleted == None:
            return


        if deleted.left == None or deleted.right == None:

            replacement = None

            if deleted.right == None:
                replacement = deleted.left
            else:
                replacement = deleted.right
    

            if deleted.parent == None:
                if replacement != None:
                    deleted.data = replacement.data
                    deleted.left = replacement.left
                    deleted.right = replacement.right
                    deleted.name = replacement.name
                    deleted.m_limit = replacement.m_limit
                    deleted.type = replacement.type
                    deleted.parent = None
                if replacement == None:
                    del deleted
                    self.root = None
                del replacement
                return self.delete_node(self, year_of_produce)

            if deleted == deleted.parent.right:
                deleted.parent.right = replacement
                if replacement != None:
                    replacement.parent = deleted.parent
            else:
                deleted.parent.left = replacement
                if replacement != None:
                    replacement.parent = deleted.parent

            del deleted
            return self.delete_node(self, year_of_produce)

        else:
            replacement = deleted.right
            only_right = True
            while replacement.left != None:
                only_right = False
                replacement = replacement.left
    

            if only_right == False:
                replacement.parent.left = replacement.right
                if replacement.right != None:
                    replacement.right.parent = replacement.parent
            if only_right == True:
                deleted.right = replacement.right
                if replacement.right != None:
                    replacement.right.parent = replacement.parent

            deleted.key = replacement.key
            deleted.value = replacement.value

            del replacement   
            return




tree = Tree()
tree.insert(2000, "name1", "type1", 2001)
tree.insert(1998, "name2", "type2", 2002)
tree.insert(1990, "name3", "type3", 2003)
tree.insert(2004, "name4", "type4", 2004)
tree.insert(2005, "name5", "type5", 2005)
tree.insert(2006, "name6", "type6", 2006)
print("\n\n")

print("Simple print check:")
print("year:    name:     type:    m_limit:")
tree.print()

print("\n\n")

print("Find by year check:")
print(tree.find(2004))

print("\n\n")

print("Sorted by max limit check:")
tree.printSortedByMaxLimit(2003)

print("After delating print check:")
print("year:    name:     type:    m_limit:")


tree.find(2008)