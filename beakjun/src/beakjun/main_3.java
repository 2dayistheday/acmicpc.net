package beakjun;

public class main_3 {

	public static void main(String[] args) {
		int n = 23;
		int answer = n;
		//int answer = rev_plus(n);
		for(int  i = 0; i < 3; i++) {
			if(isSame(n)) {
				break;
			}else {
				n = rev_plus(n);
			}
		}
		if(isSame(n)){
			answer = n;
		}else {
			answer = -1;
		}
		System.out.println(answer);
	}
	public static int rev_plus(int n) {
		int rev_n = 0;
		String nStr = Integer.toString(n);
		String revStr = "";
		for(int i = nStr.length(); i > 0; i--) {
			revStr = revStr + nStr.charAt(i-1);
		}
		//System.out.println(revStr);
		rev_n = Integer.parseInt(revStr);
		
		return n + rev_n;
		//return 1;
	}
	public static boolean isSame(int n) {
		int rev_n = 0;
		String nStr = Integer.toString(n);
		String revStr = "";
		for(int i = nStr.length(); i > 0; i--) {
			revStr = revStr + nStr.charAt(i-1);
		}
		//System.out.println(revStr);
		rev_n = Integer.parseInt(revStr);
		if(rev_n == n)
			return true;
		return false;
	}
}
