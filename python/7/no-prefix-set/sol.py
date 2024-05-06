"""
https://www.youtube.com/watch?v=evqAsdJ05yY
"""
def insert(trie, word):
    for i, char in enumerate(word):
        if char in trie:  
            # If there is a prefix for this word
            # or this word is a prefix for other
            if trie[char][1] or i == len(word) - 1:
                return True
        else:# This combination not seen yet
            trie[char] = ({}, i == len(word) - 1)
        trie, _ = trie[char] # Look down the tri
    return False

def noPrefix(words):
    trie = {}
    for word in words:
        if insert(trie, word):
            print("BAD SET")
            print(word)
            return
    print("GOOD SET")

if __name__ == "__main__":
    with open('input.txt', 'r') as f:
        num_words = int(f.readline())
        words = [x.strip() for x in f.readlines()]
        noPrefix(words)