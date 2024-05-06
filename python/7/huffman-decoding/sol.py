def decodeHuff(root, s):
    out = ''
    node = root
    for char in s:
        if char == "1":
            node = node.right
        else:
            node = node.left
        if node.left is None and node.right is None:
            out += node.data
            node = root
    print(out, end='')