def plusMinus(arr):
    l = len(arr)
    pos = [x for x in arr if x > 0]
    neg = [x for x in arr if x < 0]
    print(f"{len(pos) / l:.6f}")
    print(f"{len(neg) / l:.6f}")
    print(f"{(l-len(pos)-len(neg)) / l:.6f}")