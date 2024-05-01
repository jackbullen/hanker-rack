def recurse(n):
    string = str(n)
    if len(string) == 1:
        return int(string)
    else:
        return recurse(sum([int(x) for x in string]))
    
def superDigit(n, k):
    string = str(n)
    x = sum([int(x) for x in string]) * k
    return recurse(x)