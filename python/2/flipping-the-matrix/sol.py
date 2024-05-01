from itertools import product

def flippingMatrix(matrix):
    n = len(matrix[0]) // 2
    indices = list(range(n))
    final_vals = []
    for i, j in product(indices, indices):
        final_vals.append(max([matrix[i][j], 
                               matrix[2*n-1-i][j], 
                               matrix[i][2*n-1-j],
                               matrix[2*n-1-i][2*n-1-j]]))
    return sum(final_vals)

matrix = [[1,2,3,4],
          [5,6,7,8],
          [9,10,11,12],
          [13,14,15,16]]

print(flippingMatrix(matrix) == 11+12+15+16)