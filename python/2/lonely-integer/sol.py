def lonelyinteger(a):
    possible = []
    for num in a:
        if num in possible:
            possible.remove(num)
        else:
            possible.append(num)
    return possible[0]