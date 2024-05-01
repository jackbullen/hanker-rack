def decodeHuff(root, s):
    out = ''
    while s:
        tmp = root
        while tmp.left or tmp.right:
            if s[0] == "1":
                tmp = tmp.right
            else:
                tmp = tmp.left
            s = s[1:]
        out += tmp.data
    print(out, end='')