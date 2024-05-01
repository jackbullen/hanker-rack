def merge(li1, li2):
    head1, head2 = li1.head, li2.head

    # Set head1 to be the list with first least first element
    if head2.data < head1.data:
        temp = head1
        head1 = head2
        head2 = temp

    # If list 1 is one item, then add on list 2
    if head1.next is None:
        head1.next = head2
        return List(head1)
        
    # While the second list contains items, add them to the first
    while head2 is not None:
        # Find the spot where to add data of head2 into first list
        tmp1 = head1
        while tmp1.next.data < head2.data:
            tmp1 = tmp1.next
            # If we get to the end, add all of list 2 on the end
            if tmp1.next is None:
                tmp1.next = head2
                return List(head1)
        
        # Insert current head2 node into first list
        tmp = tmp1.next
        tmp1.next = Node(head2.data)
        tmp1.next.next = tmp
        head2 = head2.next
        
    return List(head1)

if __name__ == "__main__":
    from ds import *
    with open('test.txt', 'r') as f:
        num_cases = int(f.readline())

        lists = []
        for _ in range(num_cases):
            num_nodes = int(f.readline())
            li1 = List()
            li1.head = Node(int(f.readline()))
            t = li1.head
            for _ in range(num_nodes-1):
                t.next = Node(int(f.readline()))
                t = t.next

            num_nodes = int(f.readline())
            li2 = List()
            li2.head = Node(int(f.readline()))
            t = li2.head
            for _ in range(num_nodes-1):
                t.next = Node(int(f.readline()))
                t = t.next

            lists.append((li1, li2))
            
    for (li1, li2) in lists:
        h1, h2 = li1.head, li2.head
        print(merge(li1, li2))