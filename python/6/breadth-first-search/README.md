Difference between

```python
class Node:
    def __init__(self, idx, adjacent=[]):
        self.idx = idx
        self.adjacent = adjacent
```

and 

```python
class Node:
    def __init__(self, idx, adjacent=None):
        self.idx = idx
        self.adjacent = [] if adjacent is None else adjacent
```

In the first case the adjacent list is only created once, when the function `__init__` is created. Which results in some interesting behaviour. In this case all created node objects with default adjacent parameter will share the same list in memory. Which means if you add to one Node objects adjacency list, you add to all nodes adjacency list, which is not the desired behvaiour for this application. In the second case each will get their own, because a new list is being created everytime a Node object is created.