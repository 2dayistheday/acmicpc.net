package dfs_and_bfs;

import java.util.Scanner;

public class p_1707 {
	public static int mat[][];
	public static int visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			sc.nextLine();
			mat = new int[n+2][n+2];
			visited = new int[n+2];
			
			for(int i = 0; i < l; i++) {
				int v = sc.nextInt();
				int w = sc.nextInt();
				sc.nextLine();
				
				mat[v][w] = 1;
				mat[w][v] = 1;
			}
			
			for(int i = 1; i < n+1; i++) {
				if(visited[i] == 0) {
					dfs(i, 1);
				}
			}
			if(color()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	public static void dfs(int x, int c) {
		visited[x] = c;
		int len = mat.length - 1;
		
		for(int i = 1; i < len; i++) {
			if(mat[x][i] == 1 & visited[i] == 0) {
				dfs(i, 3-c);
			}
		}
	}
	public static boolean color() {
		int len = mat.length-1;
		for(int i = 1; i < len; i++) {
			for(int j = 1; j < len; j++) {
				if(mat[i][j] == 1) {
					if(visited[j] == visited[i]) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
