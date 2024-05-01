"""
Not a great solution. Will revisit this and write a basic tree
"""
def noPrefix(words):
    d = {}
    for word in words:
        if d.get(word[0]) is None:
            root = {}
            d[word[0]] = root
        else:
            root = d[word[0]]
            # Bad case
            if len(root) == 0:
                print("BAD SET")
                print(word)
                return
        tmp = root
        prev = tmp
        for char in word[1:]:
            prev = tmp
            tmp = tmp.get(char)
            
            # Previous word is a prefix
            if tmp is not None:
                if len(tmp) == 0:
                    print("BAD SET")
                    print(word)
                    return
                
            if tmp is None:
                tmp = {}
                prev[char] = tmp

        # Current word is a prefix
        if len(tmp) != 0:
            print("BAD SET")
            print(word)
            return

    print("GOOD SET")

if __name__ == "__main__":
    with open('input.txt', 'r') as f:
        num_words = int(f.readline())
        words = [x.strip() for x in f.readlines()]
        noPrefix(words)