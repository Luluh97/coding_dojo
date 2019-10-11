
class node :

    def __init__(self, data = None):
        self.data = data
        self.next = None


class linked_list:
    def __init__(self):
        self.head = node()

    def append(self, newVal):
        newNode = node(newVal)
        if self.head.data == None:
            self.head.data = newVal
        else:
            newNode.next = self.head
            self.head = newNode


    def display(self):
        current = self.head;

        while current is not None:
            print(current.data)
            current=current.next


    def length(self):
        counter = 0
        current = self.head
        while current != None:
            counter+=1 
            current = current.next
        return counter
    
   

    def get(self, index):
        counter = 0
        current = self.head
        while current is not None:
            if counter == index:
                return current.data
            else:
                current = current.next
                counter=counter+1

    def remove (self, index):
        counter = 0
        current = self.head
        while current is not None:
            if counter == index-1:
                current.next = current.next.next
                break
            else:
                current = current.next
                counter=counter+1

list = linked_list()
list.append(1)
list.append(2)
list.append(3)
list.remove(1)
list.display()

