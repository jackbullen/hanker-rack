num_ops = int(input())

ops = [input().split(' ') for _ in range(num_ops)]

S = ''
history = [S]

def append(W):
    global S
    history.append(S)
    S+=W
    
def delete(k):
    global S
    history.append(S)
    S = S[:-k]
    
def pprint(k):
    global S
    print(S[k-1])

def undo():
    global S
    S = history.pop()
    
for op in ops:
    operation = int(op[0])
    # print('op', operation, 'before:', S, end=' ')
    if len(op) > 1:
        arg = op[1]
        # print('arg:', arg, end=' ')
        
    # Append
    if operation == 1:
        append(arg)
        
    # Delete
    if operation == 2:
        delete(int(arg))
        
    # Print
    if operation == 3:
        pprint(int(arg))
        
    # Undo
    if operation == 4:
        undo()
    # print('after:', S)