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
			if isPalindrome(s[st+1:ed+1]):
				return st
			if isPalindrome(s[st:ed]):
				return ed
			return -1
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
			print(result, s)