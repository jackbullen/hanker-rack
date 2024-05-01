def removeIth(s, i):
	return s[:i] + s[i+1:]

def palindromeIndexSimple(s):
	if s == s[::-1]:
		return -1
	
	for i in range(len(s) - 1):
		ithRemoved = removeIth(s, i)
		if ithRemoved == ithRemoved[::-1]:
			return i
		
	return -1

def isPalindrome(s):
	st = 0
	ed = len(s) - 1
	while st <= ed:
		if s[st] != s[ed]:
			return False
		st += 1
		ed -= 1
	return True

def palindromeIndex(s):
	if isPalindrome(s):
		return -1
	st = 0
	ed = len(s) - 1
	while st <= ed:
		if s[st] != s[ed]:
			if isPalindrome(removeIth(s, st)):
				return st
			if isPalindrome(removeIth(s, ed)):
				return ed
		st += 1
		ed -= 1
	return -1

if __name__ == "__main__":
	with open('input.txt', 'r') as f:
		num_cases = int(f.readline())
		cases = []
		for _ in range(num_cases):
			cases.append(f.readline().strip())

		for s in cases:
			print("Running test case", s)
			result = palindromeIndex(s)
			if result != -1:
				print("Resulting palind:", removeIth(s, result))
			else:
				print("Not a palindrome, or already is")
			print()