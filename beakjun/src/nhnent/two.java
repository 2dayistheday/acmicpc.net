package nhnent;
import java.util.*;

public class two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str=sc.nextLine();
	    String words[]=str.split(" ");
	    
	    String secretWord = words[1];
	    int rot = Integer.parseInt(words[2]);
	    String msg = words[3];
	    
	    
	    
	    if(words[0].equals("encrypt")) {
	    		char[] tmpStr = en(msg, secretWord, rot);
	    		
	    		tmpStr = rot(tmpStr, rot);
	    		System.out.println(tmpStr);
	    }else if(words[0].equals("decrypt")) {
	    		char[] tmpStr = rot(msg.toCharArray(), rot*(-1));//en(msg, secretWord, rot);
	    		
	    		tmpStr = de( tmpStr, secretWord, rot);//rot(tmpStr, rot);
	    		System.out.println(tmpStr);
	    }
	}
	
	public static char[] en(String msg, String secret, int rot) {
		
		int msglen = msg.length();
		char[] msgChar = msg.toCharArray();
		char[] secChar = secret.toCharArray();
		char[] temp = new char[msglen];
		
		for(int i = 0; i < msglen; i++) {
			char ch = (char) (msgChar[i] + secChar[i] - 'a');
			
			
			if(ch > 'z') {
				ch = (char) (ch - 26);
			}
			secChar[i] = ch;
		}
		return secChar;
	}
	
	public static char[] de(char[] msg, String secret, int rot) {
		
		int msglen = msg.length;
		char[] secChar = secret.toCharArray();
		char[] temp = new char[msglen];
		
		for(int i = 0; i < msglen; i++) {
			char ch = (char) (msg[i] - secChar[i] + 'a');
			
			
			if(ch < 'a') {
				ch = (char) (ch + 26);
			}
			secChar[i] = ch;
		}
		return secChar;
	}
	
	public static char[] rot(char[] secret, int rot) {
		
		int msglen = secret.length;
		char[] temp = new char[msglen];
		
		//rot
		for(int i = 0; i < msglen; i++) {
			int n = i - rot;
			if(n < 0) {
				n = msglen + n ;
			}else if(n >= msglen) {
				n = n%msglen;
			}
			temp[n] = secret[i];
		}
		
		return temp;
	}

}
