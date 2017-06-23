package shanshan.spring.boot.interview.algorithm.prim;

import java.util.Scanner;

/**
 * 最小生成树
 * @author zss
 * @date 2017年6月23日
 */
public class Prim1 {
	
	/**
	 * Prim算法求最小生成树
	 * @param graph
	 * @param n
	 */
	private static long prim(int [][] graph, int n){
		long sum = 0;  //所有最小权重之和
		
		int[] lowest = new int[n];
		int[] mst = new int[n];
		int currentNode = 0;
		int min = 0;
		for(int j=0; j<n; j++){
			lowest[j] = graph[currentNode][j]; 
		}
		
		for(int i=1; i<n; i++){
			//找出初始化currentNode节点的最小权重,并且大于0
			min = 0;
			for (int j = 1; j < n; j++){  
	            if (lowest[j] != 0 && lowest[j] != -1){  
	            	if(min == 0 || lowest[j] < min){
	            		min = lowest[j];  
	            		currentNode = j;  
	            	}
	            }  
	        }  
	        
	        sum += min;  
	        lowest[currentNode] = -1; 
	        graph[mst[currentNode]][currentNode] = 0;
	        graph[currentNode][mst[currentNode]] = 0;
	        
	        //初始化新的currentNode节点相关数据(已经选定的节点就不再初始化)
	        for(int j=1; j<n;j++){
				if (graph[currentNode][j] != 0 && (lowest[j] == 0 || graph[currentNode][j] < lowest[j])) {  
	            	lowest[j] = graph[currentNode][j];  
	                mst[j] = currentNode;  
		        }
			}
	        
		}

		return sum;
	}
	
	public static void main(String[] args){
		try{
			Scanner sc =new Scanner(System.in);
			int n = sc.nextInt();  //节点个数
			int num = sc.nextInt();//边的个数
			int [][] graph = new int [n][n]; 
		    
			//赋值
			for(int i=0; i<num; i++){
				int graphV0 = sc.nextInt()-1;
				int graphV1 = sc.nextInt()-1;
				int value = sc.nextInt();
				graph[graphV0][graphV1] = value;
				graph[graphV1][graphV0] = value;
			}
			
			//求最小生成树的权重
			System.out.println(prim(graph, n));
		}catch(Exception e){
			System.out.println("输入异常");
		}		
	}
}
