package dfs_and_bfs;

import java.util.*;

public class p_11724 {
	public static int[][] mat;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		mat = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		while(m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			mat[u][v] = 1;
			mat[v][u] = 1;
			
		}
		int cnt = 0;
		for(int i = 1; i < n+1; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		//System.out.print(x+" ");
		
		int len = mat.length;
		for(int i=0;i<len; i++){
			if(!visited[i] & mat[x][i] == 1) {
				dfs(i);
			}
		}
	}

}
