package midas;
//don't place package name.// don't place package name.

import java.io.*;
import java.util.*;

// don't change 'Program' class name and without 'public' accessor.
class Program {//다익스트라 알고리즘 nuber4...수정중
    public static int maps[][];
    public static boolean visited[];
    public static int n;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        maps = new int[n+1][n+1];
        visited = new boolean[n+1];
        
        while(m-- > 0){
            int v = sc.nextInt();
            int w = sc.nextInt();
            int val = sc.nextInt();
            sc.nextLine();
            maps[v][w] = val;
            maps[w][v] = val;
        }
        dijkstra(1);
        
    }
        public static void dijkstra(int v){
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.
        for(int i=1;i<n+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화.
        distance[v] =0;
        check[v] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
         
         
        for(int a=0;a<n-1;a++){
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}