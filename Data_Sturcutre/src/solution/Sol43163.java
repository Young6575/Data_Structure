package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BFSQueueSolution {
	private static class State {
		String word;
		int depth;
		Set<String> visited;
		
		public State(String word, int depth, Set<String> visited) {
			
			this.word = word;
			this.depth = depth;
			this.visited = visited;
		}
		
	
		
		
	}
	
	
	public int solution(String begin, String target, String[] words) {
    	// 1. 제일 신나는 케이스
    	if (!Arrays.asList(words).contains(target)) {
    		return 0;
    	}
    	
    	Queue<State> queue = new LinkedList<>();
    	Set<String> visited = new HashSet<>();
    	queue.offer(new State(begin, 0, visited));
    	visited.add(begin);
    	
    	while (!queue.isEmpty()) {
    		State current = queue.poll();
    		
    		if (current.word.equals(target)) {
    			return current.depth;
    		}
    		for(String word : words) {
    			if(!visited.contains(word) && canTrasform(current.word, word)) {
    				visited.add(word);
    				queue.offer(new State(word, current.depth +1 , new HashSet<>()));
    			}
    		}
    	}
    	return 0;
	}
	
	private boolean canTrasform(String word1, String word2) {
		int diffCount = 0;
		for (int i=0;i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				diffCount++;
				if (diffCount > 1) {
					return false;
				}
			}
		}
		return diffCount == 1;
	}
}


public class Sol43163 {

	public static void main(String[] args) {
		
		BFSQueueSolution queuesol = new BFSQueueSolution();
		String[][] testWords = {
				{"hot", "dot", "dog", "lot", "log", "cog"},
				{"hot", "dot", "dog", "lot", "log"}
		};
		String[] testBegin = {"hit","hit"};
		String[] testTarget = {"cog","cog"};
		int[] expectResults = {4,0};
		for (int i = 0; i < testWords.length; i ++) {
			String[] words = testWords[i];
			String begin = testBegin[i];
			String target = testTarget[i];
			int expectResult = expectResults[i];
			int result = queuesol.solution(begin,target, words);
			if (expectResult == result) System.out.println("정답");
		}
		
		
		
		
		
	}
}
