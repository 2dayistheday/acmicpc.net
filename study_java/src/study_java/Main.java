package study_java;

import java.util.*;
class Main{
	public static void print(Map sets){
	      Set set=sets.keySet(); // 맵의 키를 받아 Set에서 저장한다
	      Iterator iter=set.iterator();
	      System.out.println("============= Map 클래스 출력 시작 ===============");
	      while(iter.hasNext()){
	      String key=(String)iter.next();
	      System.out.println(key+" "+sets.get(key));
	      }
	      System.out.println("============= Map 클래스 출력 종료 ===============");
	   }
	   
	   public static void main(String[] args){
	       HashMap<String, String> list=new HashMap<String, String>();
	        list.put("0","Z");
	        list.clear(); 
	        list.put("1","A"); 
	        list.put("2","B"); 
	        list.put("4","D"); 
	        list.put("3","C");
	        list.put("3","F"); 
	        System.out.println(list.size());
	        System.out.println(list.containsKey("3"));
	        list.remove("2");
	        System.out.println(list.size());
	        Main mt = new Main();
	        mt.print(list);
	   }

}