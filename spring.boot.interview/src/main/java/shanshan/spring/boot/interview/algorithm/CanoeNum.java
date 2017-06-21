package shanshan.spring.boot.interview.algorithm;

import java.util.Scanner;

/**
 * n个人，已知每个人体重。独木舟承重固定，每只独木舟最多坐两个人，可以坐一个人或者两个人。
 * 显然要求总重量不超过独木舟承重，假设每个人体重也不超过独木舟承重，问最少需要几只独木舟？
 * @author zss
 * @date 2017年6月21日
 */
public class CanoeNum {
	
	private static void weightSort(long[] weight){
		for(int i=0; i<weight.length-1; i++){
			for(int j=0; j<weight.length-i-1; j++){
				if(weight[j] > weight[j+1]){
					swap(weight, j, j+1);
				}
			}
		}
	}
	
	private static void swap(long[] num, int a, int b){
		if(num.length < a || num.length < b){
			return;
		}
		long temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	/**
	 * 递归获取所需独木舟的数量
	 * @param weight
	 * @param start
	 * @param end
	 * @param m
	 * 
	 * @return
	 */
	public static void getCanoeNum(long[] weight, int start, int end, long m, int num){
		if(start < end){
			if(weight[start] + weight[end] <= m){
				num += 1;
				getCanoeNum(weight, start+1, end-1, m, num);
			}else{
				num += 1;
				getCanoeNum(weight, start, end-1, m, num);
			}
		}else if(start == end){
			num += 1;
			System.out.println(num);
		}else{
			System.out.println(num);
		}
	}
	
	public static void main(String[] args){
		int n = 0; //n个人
		long m = 0L; //独木舟承重
		long[] weight = null; //n个人对应的体重
		
		try{
			Scanner in=new Scanner(System.in);
			String str=in.nextLine().trim();
			String[] inStr = str.split(" ");
			n = Integer.valueOf(inStr[0]);
			m = Long.parseLong(inStr[1]);
			
			weight = new long[n];
			for(int i=0; i<n; i++){
				weight[i] = Integer.parseInt(in.nextLine().trim());
			}
			
		}catch(Exception e){
			System.out.println("输入异常");
		}
		if(weight!=null){
			weightSort(weight);
			getCanoeNum(weight,0,n-1,m,0);
//			System.out.println();
		}
	}
}
