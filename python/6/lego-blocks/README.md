# Explanation

1. Initialize list of number of all possible walls with given height and up to given width.

```python
a = [1,2,4,8]
if width > 4:
    for _ in range(5, width+1):
        a.append(sum(a[-4:]))
else:
    a = a[:width]

g = [0 for _ in range(width + 1)]
g[:4] = a[:]
for i in range(5, width + 1):
    g[i] = (g[i-4] + g[i-3] + g[i-2] + g[i-1]) % modulo
for i in range(1, width):
    g[i] = g[i]**height % modulo
```

*Interesting that the number of partitions can be computed by summing the four previous.*

2. Using the following recursion, compute $h$ up to the desired width. Each `i` is computing the next step.

$$
\begin{align*}
    h(n,k) &= g(n,k) - \text{(number of walls that violate the rule)}\\
           &= g(n,k) - \text{(num break in right most)} - ... - (\text{num satisfy in all but left most})\\
           &= g(n,k) - h(1,k)g(n-1,k) - ... - h(n-1,k)g(1,k)
\end{align*}
$$

where $h(1,k) = g(1,k) = 1$.

```python
    h = [1]
    for i in range(2, width+1):
        idx = i - 1
        toRemove = 0
        for j, answer_j in enumerate(h):
            toRemove += answer_j * g[len(h)-1-j]
        h.append((g[idx] - toRemove) % modulo)

    return int(h[-1])
```

# Hints

1. First hint I got came from stackexchange. I did not read it all but wrote down the definitions given for $f(n), g(n, k)$, and the answer $h(n,k)$. I also got the idea of trying to derive a recursion.

2. Eventually I went back and got the recursion as I wasn't able to come up with one. 

3. Finally I got a solution that was working for widths less than and equal to four. Which I realized was giving wrong answers for greater widths because I thought $g(n,k) = 2^{(width-1)\times height}$. This is all possible walls if we can use any integer in the partition, but the question only allows one through four. The correct way to compute $g$ came from the tutorial in YouTube.