package solution;

import java.util.Stack;

class RecurSolution {
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
		
	}
	
	
	public int dfs(int[] numbers, int target, int index, int currentSum) {
		int count = 0;
		
		Stack<State> stack = new Stack<>();
		stack.push(new State(0,0));
		
		
			State current = stack.pop();
			if (current.index == numbers.length) {
				return currentSum == target ? 1 :0;
			}
			stack.push(new State(current.index+1,current.currentSum + numbers[current.index]));
			stack.push(new State(current.index+1,current.currentSum - numbers[current.index]));			
		
		
		return count;
	
	}
}


public class Sol_Recur {

	public static void main(String[] args) {
		
		int[][] testNumbers = {
				{1, 1, 1, 1, 1},
				{4, 1, 2, 1}
		};
		int[] testTarget = {3,4};
		int[] expectResults = {5,2};
		
		
		
		
		
		
	}
}
