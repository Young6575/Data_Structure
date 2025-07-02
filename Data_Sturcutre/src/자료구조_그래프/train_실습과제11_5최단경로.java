package 자료구조_그래프;

import java.util.Arrays;

// 최단거리
// 1. 벨만포드
// 2.다익스트라
// 3. 무방향
// 4. 행렬
import java.util.Scanner;

class Graph5 {
    
	// Graph5는 최단거리에 사용되는 자료구조
	private static final int NMAX = 10;
    private static final int MAX_WEIGHT = 999999;
    private int[][] length = new int[NMAX][NMAX]; // 10x10 노드가 10개짜리
    private int[] dist = new int[NMAX]; // 거리의 기본값이 999999, 최소값을 구하기 위해서 최대값을 기본으로 세팅

    private boolean[] s = new boolean[NMAX]; // s?????
    private final int n; // ???????
    
    // 1. 생성자의 가장 큰 역할 => 필드 초기화
    public Graph5(int nodeSize) {
    	 this.n = nodeSize;
    	 // 그래프 초기화
    	 for (int i=0; i < n; i++) {
    		 Arrays.fill(length[i],MAX_WEIGHT);
    		 length[i][i] = 0;
    	 }
    }

    // 간선을 추가
    public void insertEdge(int start, int end, int weight) {
    	length[start][end] = weight;
    	length[end][start] = weight;
    }

    //
    public void displayConnectionMatrix() {
    	for (int i=0; i < n; i++) {
    		for (int j=0; j < n; j++) {
    			if (length[i][j] == MAX_WEIGHT) {
    				System.out.print("❌ ");
    			} else {
    				System.out.print(length[i][j] + " ");
    			}
    		}
    		System.out.println();
    	}
    }

    public boolean isNonNegativeEdgeCost() {
    	for (int i=0; i < n; i++) {
    		for (int j=0; j <n; j++) {
    			//음수를 찾았음 => false
    			if (length[i][j] != MAX_WEIGHT && length[i][j] < 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

    // 핵심 매서드
    public void shortestPath(int startNode) {
        Arrays.fill(s, false);
        
        for (int i = 0; i < n; i++) {
            dist[i] = length[startNode][i];
        }
        s[startNode] = true;
        dist[startNode] = 0;

        // 전역탐색
        for (int i = 0; i < n - 1; i++) {
        	// 가장 작은 값을 가져와야 함(choose)
        	int u = choose();
        	s[u] = true;
        	for (int j=0; j <n; j++) {
        		if (!s[j] && dist[u] + length[u][j] < dist[j]) {
        			dist[j] = dist[u] + length[u][j];
        		}
        	}
        	// 방문기록 s[index] = true
        	// 최단거리를 합산해서 기록
        	
        	
        }
        printDistances(startNode);
    }

    private int choose() {
        int minDist = MAX_WEIGHT;
        
        int minPos = -1;
        for (int i = 0; i < n; i++) {
        	if(!s[i] && dist[i] < minDist) {
        		minDist = dist[i];
        		minPos = i;
        	}
        }
        return minPos;
    }

    private void printDistances(int startNode) {
        System.out.print("출발노드 " + startNode + ": ");
        for (int i = 0; i < n; i++) {
        	System.out.print("->("+i+")");
            System.out.print((dist[i] == MAX_WEIGHT ? "∞" : dist[i]) + " ");
        }
        System.out.println();
    }
}
public class train_실습과제11_5최단경로 {
	static void showMatrix(int[][] m) {
		System.out.println("Adjacency matrix:");
		for (int[] row : m) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
    public static int[][] makeGraph1() {
        // 주 대각선이 
    	return new int[][]{
            {0, 6, 5, 7, 0, 0, 0},
            {6, 0, -2, 0, -1, 0, 0},
            {5, -2, 0, -2, 1, 0, 0},
            {7, 0, -2, 0, 0, -1, 0},
            {0, -1, 1, 0, 0, 0, 3},
            {0, 0, 0, -1, 0, 0, 8},
            {0, 0, 0, 0, 3, 8, 0}
        };
    }

    public static int[][] makeGraph2() {
        return new int[][]{
            {0, 300, 1000, 0, 0, 0, 0, 1700},
            {300, 0, 800, 0, 0, 0, 0, 0},
            {1000, 800, 0, 1200, 0, 0, 0, 0},
            {0, 0, 0, 1200, 1500, 1000, 0, 0},
            {0, 0, 0, 1500, 0, 250, 0, 0},
            {0, 0, 0, 1000, 250, 0, 900, 1400},
            {0, 0, 0, 0, 0, 900, 0, 1000},
            {1700, 0, 0, 0, 0, 1400, 1000, 0}
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph5 g = null;

        System.out.println("1: 그래프(가중치 마이너스), 2: 그래프(도시간 거리)");
        int select = scanner.nextInt();
        if (select == 1) {
            int[][] matrix = makeGraph1();
            showMatrix(matrix);
            g = new Graph5(7);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else if (select == 2) {
            int[][] matrix = makeGraph2();
            showMatrix(matrix);
            g = new Graph5(8);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        g.insertEdge(i, j, matrix[i][j]);
                    }
                }
            }
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.print("\nCommands: 1: Display Matrix, 2: Dijkstra (non-negative), 3: Quit => ");
            select = scanner.nextInt();
            if (select == 3) break;

            switch (select) {
                case 1:
                    g.displayConnectionMatrix();
                    break;
                case 2:
                    if (g.isNonNegativeEdgeCost()) {
                        System.out.print("Start node: ");
                        int startNode = scanner.nextInt();
                        g.shortestPath(startNode);
                    } else {
                        System.out.println("Negative edge가 존재하므로 Bellman-Ford 알고리즘 사용해야 한다.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
        scanner.close();
    }
}
