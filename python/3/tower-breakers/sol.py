def isPrime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def towerBreakers(n, m):
    # If p2 can mirror or p1 has no moves
    if n % 2 == 0 or m == 1:
        return 2
    else:
        # Now p2 in a spot where there is even num towers
        # so p1 can mirror
        return 1