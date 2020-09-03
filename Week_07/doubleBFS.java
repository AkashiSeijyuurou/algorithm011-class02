//双向BFS模板
Set<String> wordDict = new HashSet<>(wordList);
if (wordDict.contains(end)) {
	return 0;
}

Set<String> beginSet = new HashSet<>();
Set<String> endSet = new HashSet<>();

beginSet.add(begin);
endSet.add(end);

Set<String> visited = new HashSet<>();

int len = 1;

while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	if (beginSet.size() > endSet.size()) {
		Set<String> set = beginSet;
		beginSet = endSet;
		endSet = set;
	}
	
	Set<String> temp = new HashSet<>();
	
	for (String word : beginSet) {
		char[] chs = word.tocharArray();
		for (int i = 0; i < chs.length; i++) {
			for (char c = 'a'; c < 'z'; c++) {
				char old = chs[i];
				chs[i] = c;
				String target = String.valueOf(chs);
				
				if (endSet.contains(target)) {
					return len + 1;
				}
				
				if (!visited.contains(target) && wordDict.contains(target)) {
					visited.add(target);
					temp.add(target);
				}
				
				chs[i] = old;
			}
		}
	}
	
	beginSet = temp;
	len++;
}

return 0;