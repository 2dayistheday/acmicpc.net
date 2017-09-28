package dfs_and_bfs;

import java.util.*;

public class p_1260 {
	public static boolean visited[];
	public static int matrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeNum = sc.nextInt();
		int lineNum = sc.nextInt();
		int startNode = sc.nextInt();
		sc.nextLine();
		
		matrix = new int[nodeNum+2][nodeNum+2];
		visited = new boolean[nodeNum+1];
		
		while(lineNum-- > 0) {
			int v = sc.nextInt();
			int w = sc.nextInt();
			sc.nextLine();
			matrix[v][w] = 1;
			matrix[w][v] = 1;
		}
		
		for(int i = 1; i <= nodeNum; i++) {
			for(int j =1; j <= nodeNum; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		dfs(matrix, nodeNum, startNode);
	}
	
	public static void dfs(int [][]matrix, int size, int v) {
		visited[v] = true;
		System.out.print(v);
		
		for(int i = 1; i <= size; i++) {
			if(matrix[v][i] == 1 & !visited[i]) {
				dfs(matrix, size, i);
			}
		}
	}
	
	public static void bfs(int [][]matrix, int size, int v) {
		visited[v] = true;
		System.out.print(v);
		
	}
}
