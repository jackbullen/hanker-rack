def minimumBribes(q):
    b = 0
    for i, p in enumerate(q):
        idx = i + 1
        if p - idx > 2:
            print("Too chaotic")
            return
        for t in q[max(0, p-2):i]:
            if t > p:
                b += 1
    print(b)