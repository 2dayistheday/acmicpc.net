package beakjun;
import java.util.*;

public class main_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = 0;
		int[] n = new int[10];
		//String str = sc.nextLine();
		//n =	str.split(" ")
		//int tmp;
		
		String str = sc.nextLine();
		str.split(" ");
		
		int nSize = t;
		int[] divN = new int[nSize];
		int[] rmdN = new int[nSize];
		int[] sortN = new int[nSize];
		
		for(int i = 0; i < nSize; i++) {
			divN[i] = n[i]/10;
			rmdN[i] = n[i]%10;
			if(divN[i] == 0)
				divN[i] = rmdN[i];
		}
		
		for(int i = 0; i < nSize; i++) {
			int max_idx = 0;
			for(int j = 1; j < nSize; j++) {
				if(divN[max_idx] <  divN[j]) {
					max_idx = j;
				}else if(divN[max_idx] == divN[j]) {
					if(rmdN[max_idx] < rmdN[j]) {
						max_idx = j;
					}
				}
			}
			sortN[i] = n[max_idx];
			divN[max_idx] = 0;
		}
		
		for (int i = 0; i < nSize; i++) {
			System.out.print(sortN[i]+" ");
		}System.out.println();
	}

}
