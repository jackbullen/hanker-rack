class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class List:
    def __init__(self, head=None):
        self.head = head

    def __str__(self):
        out = '['
        t = self.head
        while t is not None:
            out += str(t.data)
            t = t.next
            if t is not None:
                out += ', '
            else:
                out += ']'
        return out
    
    def __repr__(self):
        return self.__str__()