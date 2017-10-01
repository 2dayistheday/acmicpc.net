package dfs_and_bfs;

import java.util.*;


public class p_1260 {
	public static boolean visited[];
	public static int matrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int matSize = sc.nextInt();
		int lineNum = sc.nextInt();
		int first = sc.nextInt();
		sc.nextLine();
		
		matrix = new int[matSize+2][matSize+2];
		visited = new boolean[matSize+1];
		
		for(int i = 0; i < matSize; i++) {
			int v = sc.nextInt();
			int w = sc.nextInt();
			sc.nextLine();
			matrix[v][w] = 1;
			matrix[w][v] = 1;
		}
		
		dfs(first);
		System.out.println();
		visited = new boolean[matSize+1];
		bfs(first);
	}
	public static void dfs(int visit) {
		visited[visit] = true;
		System.out.print(visit + " ");
		int len = matrix.length-1;
		
		for(int i = 1; i < len; i++) {
			if(!visited[i] & matrix[visit][i] == 1) {
				dfs(i);
			}
		}
	}
	public static void bfs(int visit) {
		Queue<Integer> q = new LinkedList<>();
		int len = matrix.length-1;
		
		visited[visit] = true;
		q.offer(visit);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int i = 1; i < len; i++) {
				if(matrix[x][i] == 1 & !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
	}
}
