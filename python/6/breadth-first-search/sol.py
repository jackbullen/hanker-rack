from collections import deque, defaultdict

def bfs(num_nodes, edges, start):
    adj = defaultdict(list)
    for (n1, n2) in edges:
        adj[n1].append(n2)
        adj[n2].append(n1)

    distances = {i+1: -1 for i in range(num_nodes)}
    distances[start] = 0

    q = deque()
    q.append(start)
    while (len(q) != 0):
        node = q.popleft()
        print(node, distances[node])
        for adjacent in adj[node]:
            if distances[adjacent] == -1:
                distances[adjacent] = distances[node] + 1
                q.append(adjacent)
    return distances

if __name__ == "__main__":
    with open('input.txt', 'r') as f:
        num_cases = int(f.readline())
        for _ in range(num_cases):
            num_nodes, num_edges = [int(x) for x in f.readline().strip().split(' ')]
            edges = []
            for _ in range(num_edges):
                edges.append([int(x) for x in f.readline().strip().split(' ')])
            start = int(f.readline())
            bfs(num_nodes, edges, start)


# Node to self: use a queue for BFS...
# class Node:
#     def __init__(self, idx, adjacent=None):
#         self.idx = idx
#         self.adjacent = [] if adjacent is None else adjacent
#     def __str__(self):
#         return str(self.idx)
#     def __repr__(self):
#         return self.__str__()
        
# def bfs(num_nodes, edges, start):
#     nodes = []
#     for i in range(num_nodes):
#         nodes.append(Node(i))
#     for n1, n2 in edges:
#         n1, n2 = nodes[n1-1], nodes[n2-1]
#         n1.adjacent.append(n2)
#         n2.adjacent.append(n1)

#     # Traverse nodes in BFS manner
#     s = nodes[start-1]
#     distances = [0 for _ in range(num_nodes)]
#     toVisit = [s] + s.adjacent.copy()
#     while toVisit:
#         curr = toVisit[0]
#         for n in curr.adjacent:
#             if distances[n.idx] == 0:
#                 distances[n.idx] = distances[curr.idx] + 6
#                 # Visit this node after all current ones
#                 toVisit.append(n)
#         toVisit = toVisit[1:]
        
#     # Set all unreached nodes to -1
#     for i, d in enumerate(distances):
#         if d == 0 and i != s.idx:
#             distances[i] = -1
    
#     distances.pop(s.idx)
#     return distances

# if __name__ == "__main__":
#     with open('input.txt', 'r') as f:
#         num_cases = int(f.readline())
#         for _ in range(num_cases):
#             num_nodes, num_edges = [int(x) for x in f.readline().strip().split(' ')]
#             edges = []
#             for _ in range(num_edges):
#                 edges.append([int(x) for x in f.readline().strip().split(' ')])
#             start = int(f.readline())
#             print(bfs(num_nodes, edges, start))