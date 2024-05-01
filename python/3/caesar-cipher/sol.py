alp = "abcdefghijklmnopqrstuvwxyz"

def caesarCipher(s, k):
    def getNewChar(char):
        idx = alp.find(char.lower())
        if idx == -1:
            return char
        newChar = alp[(idx + k) % 26]
        if char.isupper():
            return newChar.upper()
        return newChar
        
    return ''.join([getNewChar(c) for c in s])