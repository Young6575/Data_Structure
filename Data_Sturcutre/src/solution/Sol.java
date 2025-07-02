package solution;

import java.util.Stack;

class StackSolution {
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
		
		Stack<State> stack = new Stack<>();
		stack.push(new State(0,0));
		
		while (!stack.empty()) {
			State current = stack.pop();
			if (current.index == numbers.length) {
				if (current.currentSum == target) {
					count++;
				}
				continue;
			}
			stack.push(new State(current.index+1,current.currentSum + numbers[current.index]));
			stack.push(new State(current.index+1,current.currentSum - numbers[current.index]));			
		}
		
		return count;
	
	}
}


public class Sol {

	public static void main(String[] args) {
		
		int[][] testNumbers = {
				{1, 1, 1, 1, 1},
				{4, 1, 2, 1}
		};
		int[] testTarget = {3,4};
		int[] expectResults = {5,2};
		
		
		
		
		
		
	}
}
