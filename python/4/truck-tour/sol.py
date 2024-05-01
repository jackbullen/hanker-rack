"""
Thought the problem wanted a full cycle from starting point
which is what the commented out code is trying to solve.
But it only requires to make it to N-1 node.
"""
def truckTour(pumps):
    d = {}
    for i, (fuel, dist) in enumerate(pumps):
        if len(d) == 0:
            d[i] = fuel - dist
        else:
            d[i] = d[i-1] + fuel - dist
        if d[i] < 0:
            d.clear()
    return min(d.keys())

# def truckTour(pumps):
#     minFuelReq = 0
#     residualFuel = 0
#     for i, p in enumerate(pumps):
#         fuelReq = p[1] - p[0]
#         residualFuel -= fuelReq
#         if -residualFuel > minFuelReq:
#             minFuelReq = -residualFuel
            
#     haveAtEnd = [0]
#     for p in pumps[::-1]:
#         haveAtEnd.append(haveAtEnd[-1] + p[0] - p[1])
        
#     for i, p in enumerate(pumps):
#         if haveAtEnd[len(pumps) - i] >= minFuelReq and p[0] >= p[1]:
#             print(haveAtEnd[len(pumps) - i], minFuelReq)
#             return i
            
#     return None