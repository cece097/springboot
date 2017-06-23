package shanshan.spring.boot.interview.algorithm.prim;

import java.util.Scanner;

/**
 * 最小生成树
 * @author zss
 * @date 2017年6月23日
 * 问题：时间复杂度太大
 */
public class Prim {
	
	//权重最大值，表示没有相连
	private static final int MAX_VALUE = Integer.MAX_VALUE; 
	
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
		int min = MAX_VALUE;
		for(int j=0; j<n; j++){
			lowest[j] = graph[currentNode][j]; 
		}
		System.out.println("：： 1"); 
		for(int jj=0;jj<lowest.length;jj++) { 
	        System.out.print((lowest[jj]==MAX_VALUE?"0":lowest[jj]+"")+",");     
		}
		System.out.println(" "); 
		
		for(int i=1; i<n; i++){
			//找出初始化currentNode节点的最小权重
			min = MAX_VALUE;
			for (int j = 1; j < n; j++){  
	            if (lowest[j] < min && lowest[j] != 0){  
	                min = lowest[j];  
	                currentNode = j;  
	            }  
	        }  
	        
			System.out.println(mst[currentNode]+1+"-----"+(currentNode+1)+" , "+min);
	        sum += min;  
	        lowest[currentNode] = 0; 
	        graph[mst[currentNode]][currentNode] = MAX_VALUE;
	        graph[currentNode][mst[currentNode]] = MAX_VALUE;
	        
	        //初始化新的currentNode节点相关数据(已经选定的节点就不再初始化)
	        System.out.println("：："+(currentNode+1)); 
	        for(int j=1; j<n;j++){
				if (graph[currentNode][j] < lowest[j]) {  
	            	lowest[j] = graph[currentNode][j];  
	                mst[j] = currentNode;  
		        }
			}
	        
	        for(int jj=0;jj<lowest.length;jj++) { 
		        System.out.print((lowest[jj]==MAX_VALUE ? "0" : lowest[jj]+"")+",");     
			}
			System.out.println(" "); 
		}

		return sum;
	}
	
	public static void main(String[] args){
		try{
			Scanner sc =new Scanner(System.in);
			int n = sc.nextInt();  //节点个数
			int num = sc.nextInt();//边的个数
			int [][] graph = new int [n][n]; 
			//初始化图  
		    for (int i = 0; i < n; i++)  
		    {  
		        for (int j = 0; j < n; j++)  
		        {  
		            graph[i][j] = MAX_VALUE;  
		        }  
		    }
		    
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
