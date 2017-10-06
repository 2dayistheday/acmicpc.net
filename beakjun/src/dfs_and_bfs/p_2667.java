package dfs_and_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class p_2667 {
	public static int mat[][];
	public static int visited[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		mat = new int[n+2][n+2];
		visited = new int[n+2][n+2];
		
		for(int i = 1; i < n+1; i++) {
			String line = sc.nextLine();
			for(int j = 1; j < n+1; j++) {
				mat[i][j] = line.charAt(j-1) - 48;
			}
		}
		
		int c = 1;
		int cArr[] = new int[(n*n)/2];
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(visited[i][j] == 0 & mat[i][j] == 1) {
					cArr[c-1] = dfs(i, j, c);
					c++;
				}
			}
		}
		Arrays.sort(cArr, 0, c-1);
		
		System.out.println(c-1);
		for(int i = 0; i < c-1; i++) {
			System.out.println(cArr[i]);
		}
		/*
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				System.out.print(visited[i][j]);
			}System.out.println();
		}
		*/
	}
	
	public static int dfs(int x, int y, int c) {
		int cnt = 1;
		visited[x][y] = c;
		
		if(visited[x-1][y] == 0 & mat[x-1][y] == 1) {
			cnt += dfs(x-1, y, c);
		}
		if(visited[x+1][y] == 0 & mat[x+1][y] == 1) {
			cnt += dfs(x+1, y, c);
		}
		if(visited[x][y-1] == 0 & mat[x][y-1] == 1) {
			cnt += dfs(x, y-1, c);
		}
		if(visited[x][y+1] == 0 & mat[x][y+1] == 1) {
			cnt += dfs(x, y+1, c);
		}
		return cnt;
	}
}
