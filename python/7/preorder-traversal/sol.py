def preOrder(root):
    print(root.info, end=' ')
    if root.left:
        preOrder(root.left)
    if root.right:
        preOrder(root.right)