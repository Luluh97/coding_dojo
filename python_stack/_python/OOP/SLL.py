class node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SList:
    def __init__(self):
        self.head = None

    def add_to_front(self,val):
        new_node = node(val)
        new_node.next = self.head
        self.head = new_node
        return self
    
    def add_to_back(self, val):
        new_node = node(val)
        current = self.head
        while current.next != None:
            current = current.next
        current.next = new_node
        return self


    def print_values(self):
        current = self.head
        while current is not None:
            print(current.data)
            current = current.next
        return self

mylist = SList()
mylist.add_to_front(1).add_to_front(2).add_to_front(3).add_to_back(5).add_to_front(6).print_values()
