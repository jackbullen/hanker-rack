num_queries = int(input())

enqueue_stack = list()
dequeue_stack = list()

def transfer():
    while enqueue_stack:
        dequeue_stack.append(enqueue_stack.pop())

def dequeue():
    if len(dequeue_stack) == 0:
        transfer()
    dequeue_stack.pop()
    
for _ in range(num_queries):
    query = input().strip()
    
    #Enqueue
    if len(query) > 1:
        x = int(query.split(' ')[1])
        enqueue_stack.append(x)
        
    else:
        if not dequeue_stack:
            transfer()
            
        # Dequeue
        if query == '2':
            if dequeue_stack:
                dequeue()
            else:
                print("QueryError: Dequeue when queue is empty.\n")
                
        # Peek
        else:
            if dequeue_stack:
                print(dequeue_stack[-1])
            else:
                print("QueryError: Peek when queue is empty.\n")