package dfs_and_bfs;

import java.util.*;
public class p_7576_aka_tomato {
	public static int mat[][];
	public static boolean visited[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		mat = new int [n+2][m+2];
		visited = new boolean[n+2][m+2];
		
		for(int i = 0 ; i < n+2; i++) {
			for(int j = 0; j < m+2; j++) {
				if(i == 0 | j == 0) {
					mat[i][j] = -1;
				}else if(i == n+1 | j == m+1){
					mat[i][j] = -1;
				}else {
					mat[i][j] = sc.nextInt();
				}
			}
		}
		
		int max = bfs(n, m);
		
		for(int i = 1 ; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(mat[i][j] == 0) {
					max = -1;
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static int bfs(int n, int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 1 ; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(mat[i][j] == 1) {
					visited[i][j] = true;
					q.offer(new Pair(i, j));
				}
			}
		}
		
		int xp = 0;
		int yp = 0;
		while(!q.isEmpty()){
			Pair p= q.poll();
			xp = p.x;
			yp = p.y;
			
			if(visited[xp-1][yp] == false & mat[xp-1][yp] == 0) {
				visited[xp-1][yp] = true;
				mat[xp-1][yp] = mat[xp][yp]+1;
				q.offer(new Pair(xp-1, yp));
			}
			if(visited[xp][yp-1] == false & mat[xp][yp-1] == 0) {
				visited[xp][yp-1] = true;
				mat[xp][yp-1] = mat[xp][yp]+1;
				q.offer(new Pair(xp, yp-1));
			}
			if(visited[xp+1][yp] == false & mat[xp+1][yp] == 0) {
				visited[xp+1][yp] = true;
				mat[xp+1][yp] = mat[xp][yp]+1;
				q.offer(new Pair(xp+1, yp));
			}
			if(visited[xp][yp+1] == false & mat[xp][yp+1] == 0) {
				visited[xp][yp+1] = true;
				mat[xp][yp+1] = mat[xp][yp]+1;
				q.offer(new Pair(xp, yp+1));
			}
		}
		
		
		return mat[xp][yp]-1;
	}
}
class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
