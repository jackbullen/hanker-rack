"""
https://stackoverflow.com/questions/73067434/lego-blocks-interview-question-subtracting-number-of-cases-with-clear-vertica
https://www.youtube.com/watch?v=u9fL52Hryiw
"""
modulo = 10**9 + 7
def legoBlocks(height, width):
    """Who knew lego could be so difficult..."""
    a = [1,2,4,8]
    if width > 4:
        for _ in range(5, width+1):
            a.append(sum(a[-4:]))
    else:
        a = a[:width]

    g = [0 for _ in range(width + 1)]
    g[:4] = a[:]
    for i in range(5, width + 1):
        g[i] = (g[i-4] + g[i-3] + g[i-2] + g[i-1]) % modulo
    for i in range(1, width):
        g[i] = g[i]**height % modulo

    h = [1]
    for i in range(2, width+1):
        idx = i - 1
        toRemove = 0
        for j, answer_j in enumerate(h):
            toRemove += answer_j * g[len(h)-1-j]
        h.append((g[idx] - toRemove) % modulo)

    return int(h[-1])

if __name__ == "__main__":
    with open('input.txt', 'r') as f:
        num_cases = int(f.readline())
        for _ in range(num_cases):
            height, width = [int(x) for x in f.readline().strip().split(' ')]
            print(legoBlocks(height, width))