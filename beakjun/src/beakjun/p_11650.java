package beakjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		pair arr[] = new pair[t];
		
		for(int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr[i] = new pair(x, y);
		}
		Arrays.sort(arr, new Comparator<pair>() {
			@Override
			public int compare(pair a, pair b) {
				int x1 = a.x;
				int x2 = b.x;
				if(x1 == x2) {
					int y1 = a.y;
					int y2 = b.y;
					
					return y1-y2;
				}else {
					return x1-x2;
				}
			}
		});
		for(int j = 0; j < t; j++) {
			System.out.println(arr[j].x + " " + arr[j].y);
		}
		
	}
}
class pair{
	int x;
	int y;
	public pair(int x, int y) {
		this.x =x;
		this.y = y;
	}
}
