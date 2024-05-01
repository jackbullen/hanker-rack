from collections import Counter
def pairs(k, arr):
    ct = Counter(arr)
    return sum([ct[x] for x in arr if x + k in ct])