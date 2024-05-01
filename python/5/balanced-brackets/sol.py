openers = ['{', '[', '(']
closers = ['}', ']', ')']
close_to_open = {
    '{': '}',
    '[': ']',
    '(': ')'
}

def isBalanced(s):
    brackets = []
    for c in s:
        if c in openers:
            brackets.append(c)
        if c in closers:
            if not brackets:
                return 'NO'
            if c != close_to_open[brackets.pop()]:
                return 'NO'
    if brackets != []:
        return 'NO'
    return 'YES'