def gridChallenge(grid):
    grid = [sorted(row) for row in grid]
    cols = [[row[i] for row in grid] for i in range(len(grid[0]))]
    
    if all(sorted(col) == col for col in cols):
        return 'YES'
    else:
        return 'NO'