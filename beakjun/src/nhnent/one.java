package nhnent;

import java.util.*;

public class one {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str=sc.nextLine();
	    String number[]=str.split(" ");
	    int len=number.length;
	    int []n = new int[len];
	    
	    for(int i=0;i<len;i++){
	         n[i]=Integer.parseInt(number[i]);
	    }

		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 0; i< len; i++) {
			int num = n[i];
			if(que.contains(num)) {
				que.remove(num);
			}else {
				if(que.size() == 3) {
					System.out.println(que.poll());
				}
			}
			que.offer(num);
		}
	}

}
