def findMedian(arr):
    arr = sorted(arr)
    mid = len(arr) // 2
    return arr[mid]