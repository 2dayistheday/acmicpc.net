package dfs_and_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class p_2331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		while(true) {
			arr.add(n);
			n = func(n, p);
			for(int i = arr.size()-1; i >= 0; i--) {
				if(arr.get(i) == n) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	
	public static int func(int n, int p) {
		int sum = 0;
		while(n > 9) {
			sum = (int) (sum + Math.pow((n % 10), p));
			n = n / 10;
		}
		sum = (int)(sum + Math.pow(n, p));
		return sum;
	}

}
