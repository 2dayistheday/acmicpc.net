package dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p_7576_aka_tomato {
	public static int matrix[][];
	public static boolean visited[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		
		matrix = new int[n+2][m+2];
		visited = new boolean[n+2][m+2];
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < m+2; i++) {
			matrix[0][i] = -1;
			matrix[n+1][i] = -1;
		}
		for(int i = 0; i < n+2; i++) {
			matrix[i][0] = -1;
			matrix[i][m+1] = -1;
		}/*
		for(int i = 0; i < matrix.length; i++) {
			for(int j= 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}*/
		
		int cnt = 0;
		cnt = bfs(n, m);
		
		boolean flag = true;
		for(int i = 0; i < matrix.length; i++) {
			for(int j= 0; j < matrix[i].length; j++) {
				if( matrix[i][j] == 0) {
					flag = false;
				}
			}
		}
		if(flag) {
			System.out.println(cnt);
		}else {
			System.out.println("-1");
		}
		
	}
	
	public static int bfs(int n, int m) {
		Queue<pair> q = new LinkedList<pair>();
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(!visited[i][j] & matrix[i][j] == 1) {
					q.offer(new pair(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			pair tmp = q.poll();
			int xn = tmp.x;
			int yn = tmp.y;
			
			cnt = matrix[xn][yn];
			if(!visited[xn-1][yn] & matrix[xn-1][yn] == 0) {
				q.offer(new pair(xn-1, yn));
				visited[xn-1][yn] = true;
				matrix[xn-1][yn] = matrix[xn][yn]+1;
			}
			if(!visited[xn][yn-1] & matrix[xn][yn-1] == 0) {
				q.offer(new pair(xn, yn-1));
				visited[xn][yn-1] = true;
				matrix[xn][yn-1] = matrix[xn][yn]+1;
			}
			if(!visited[xn+1][yn] & matrix[xn+1][yn] == 0) {
				q.offer(new pair(xn+1, yn));
				visited[xn+1][yn] = true;
				matrix[xn+1][yn] = matrix[xn][yn]+1;
			}
			if(!visited[xn][yn+1] & matrix[xn][yn+1] == 0) {
				q.offer(new pair(xn, yn+1));
				visited[xn][yn+1] = true;
				matrix[xn][yn+1] = matrix[xn][yn]+1;
			}
		}
		
		return cnt-1;
	}
}

class pair{
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
}
