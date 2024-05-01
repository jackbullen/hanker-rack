def diagonalDifference(arr):
    l = len(arr)
    return abs(sum([arr[i][i]-arr[l-1-i][i] 
                    for i in range(l)]))