def countingSort(arr):
    freq = [0 for _ in range(100)]
    for i in arr:
        freq[i] += 1
    return freq