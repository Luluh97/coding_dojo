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
    
    def remove_node(self): 
		if self.head != None: 
			current_node = self.head 
		#Remove if list only has one node
		if self.head.next == None: 
			self.head = None
			print self.head
			#While not last, set current_node to next node 
			while current_node.next != None: 
				current_node = current_node.next
				#If only one item in list, remove it
				if current_node.next.next == None: 
					current_node.next = None
		else: 
			print "No nodes"
			return False

mylist = SList()
mylist.add_to_front(1).add_to_front(2).add_to_front(3).add_to_back(5).add_to_front(6).print_values()
