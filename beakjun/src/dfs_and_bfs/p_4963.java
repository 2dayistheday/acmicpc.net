package dfs_and_bfs;

import java.util.Scanner;

public class p_4963 {
	public static int mat[][];
	public static boolean visited[][];
	public static int val[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if(m == 0 & n == 0) {
				break;
			}
			mat = new int[n+2][m+2];
			visited = new boolean[n+2][m+2];
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < m+1; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < m+1; j++) {
					if(mat[i][j] == 1 & !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		//8 is length of val
		for(int i = 0; i < 8; i++) {
			int xp = val[i][0];
			int yp = val[i][1];
			if(!visited[x+xp][y+yp] & mat[x+xp][y+yp] == 1) {
				dfs(x+xp, y+yp);
			}
		}
	}
}
