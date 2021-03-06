package dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p_2178 {
	public static int mat[][];
	public static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		mat = new int[n+2][m+2];
		visited = new boolean[n+2][m+2];
		
		for(int i = 1; i < n+1; i++) {
			String line = sc.nextLine();
			for(int j = 1; j < m+1; j++) {
				mat[i][j] = line.charAt(j-1) - 48;
			}
		}
		int cnt = bfs(n,m);
		System.out.println(cnt);
		
	}
	public static int bfs(int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1, 1));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int xp = p.x;
			int yp = p.y;
			if(!visited[xp-1][yp] & mat[xp-1][yp] == 1) {
				visited[xp-1][yp] = true;
				mat[xp-1][yp] = mat[xp][yp]+1;
				q.offer(new Pair(xp-1, yp));
			}
			if(!visited[xp+1][yp] & mat[xp+1][yp] == 1) {
				visited[xp+1][yp] = true;
				mat[xp+1][yp] = mat[xp][yp]+1;
				q.offer(new Pair(xp+1, yp));
			}
			if(!visited[xp][yp-1] & mat[xp][yp-1] == 1) {
				visited[xp][yp-1] = true;
				mat[xp][yp-1] = mat[xp][yp]+1;
				q.offer(new Pair(xp, yp-1));
			}
			if(!visited[xp][yp+1] & mat[xp][yp+1] == 1) {
				visited[xp][yp+1] = true;
				mat[xp][yp+1] = mat[xp][yp]+1;
				q.offer(new Pair(xp, yp+1));
			}
		}
		
		if(!visited[n][m]) {
			return -1;
		}else {
			return mat[n][m];
		}
	}
}
