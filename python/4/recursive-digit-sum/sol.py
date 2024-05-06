def recurse(n):
    if n < 10:
        return n
    else:
        return recurse(sum([int(x) for x in str(n)]))

def superDigit(n, k):
    x = sum([int(x) for x in str(n)]) * k
    return recurse(x)