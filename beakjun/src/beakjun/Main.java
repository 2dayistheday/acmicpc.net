package beakjun;
import java.util.*;

class Main {
	static int m[][];
	static boolean visited[][];
	static int c;
	
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		m = new int[t+1][t+1];
		visited = new boolean[t+1][t+1];
		c = 0;
		ArrayList<Integer> num= new ArrayList<>();
		String line;
		char a = (char)('A'+0);
		
		for(int i = 1; i <= t; i++){
			for(int j = 1; j <= t; j++){
				m[i][j] = sc.nextInt();
			}
		}
		
		//print(t);
		
		for(int i = 1; i <= t; i++){
			for(int j = 1; j <= t; j++){
				if(m[i][j] != 0 && visited[i][j] == false){
					num.add(dfs(i, j));
					c++;
				}
			}
		}
		
		System.out.println(c);
		Object[] arraynum = num.toArray();
		Arrays.sort(arraynum);
		for(int i = 0; i < arraynum.length; i++){
			System.out.print(arraynum[i]);
			if(i != arraynum.length -1) {
				System.out.print(" ");
			}
		}
		
		//print(t);
		
	}
	public static int dfs(int i, int j){
		int cnt = 1;
		visited[i][j] = true;
		m[i][j] = c;
		//System.out.println(m[i][j]);
		
		int mrlen = m.length;
		int mclen = m[0].length;
		
		if(i < mrlen-1){
			if(m[i+1][j] != 0 && visited[i+1][j] == false){
				cnt = cnt + dfs(i+1, j);
			}
		}
		if(j < mclen-1){
			if(m[i][j+1] != 0 && visited[i][j+1] == false){
				cnt = cnt + dfs(i, j+1);
			}
		}
		if(i > 1){
			if(m[i-1][j] != 0 && visited[i-1][j] == false){
				cnt = cnt + dfs(i-1, j);
			}
		}
		if(j > 1){
			if(m[i][j-1] != 0 && visited[i][j-1] == false){
				cnt = cnt + dfs(i, j-1);
			}
		}
		
		return cnt;
	}
	
	public static void print(int t){
		for(int i = 1; i <= t; i++){
			for(int j = 1; j <= t; j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
