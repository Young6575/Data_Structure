package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueSolution {
	private static class State {
		int index;
		int currentSum;
		
		State(int index, int currentSum) {
			this.index = index;
			this.currentSum = currentSum;
		}
		
		
	}
	
	public int solution(int[] numbers, int target) {
		int count = 0;
		
		Queue<State> queue = new LinkedList();
		queue.offer(new State(0,0));
		
		while (!queue.isEmpty()) {
			State current = queue.poll();
			
			if (current.index == numbers.length) {
				if (current.currentSum == target) {
					count++;
				}
				continue;
			}
			queue.offer(new State(current.index+1,current.currentSum + numbers[current.index]));
			queue.offer(new State(current.index+1,current.currentSum - numbers[current.index]));
			
		}
		
		return count;
	
	}
}


public class Sol2 {

	public static void main(String[] args) {
		
		int[][] testNumbers = {
				{1, 1, 1, 1, 1},
				{4, 1, 2, 1}
		};
		int[] testTarget = {3,4};
		int[] expectResults = {5,2};
		
		
		
		
		
		
	}
}
