"""
https://www.youtube.com/watch?v=cJtq8eZCWpk
https://docs.python.org/3/library/heapq.html
"""
import heapq
def cookies(k, A):
    heapq.heapify(A)

    ops = 0
    while True:
        minSweet = heapq.heappop(A)

        # If min value is above threshold 
        if minSweet >= k:
            return ops
            
        else:
            if not A: # No more items to mix
                return -1 # Not possible
            
            # Mix two least items
            nextMinSweet = heapq.heappop(A)
            newSweet = minSweet + 2*nextMinSweet
            heapq.heappush(A, newSweet)
            ops += 1