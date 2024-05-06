from functools import reduce
def lonelyinteger(li):
    return reduce(lambda a, b: a^b, li, 0)