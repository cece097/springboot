package shanshan.spring.boot.interview.algorithm.activity;

import java.util.Scanner;

/**
 * 活动安排
 * 	有若干个活动，第i个开始时间和结束时间是[Si,fi)，只有一个教室，活动之间不能交叠，求最多安排多少个活动？
 * @author zss
 * @date 2017年6月21日
 */
public class ActivityPlan2{
	
	private static void swap(int[] num, int a, int b){
		if(num.length < a || num.length < b){
			return;
		}
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	private static void activitySort(int[] a, int[] b){
		for(int i=0; i<b.length-1; i++){
			for(int j=0; j<b.length-i-1; j++){
				if(b[j] > b[j+1]){
					swap(a, j, j+1);
					swap(b, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args){
		int n = 0;
		int[] start = null;
		int[] end = null;
		
		try{
			Scanner in=new Scanner(System.in);
			String str=in.nextLine().trim();
			
			n = Integer.parseInt(str);
			start = new int[n];
			end = new int[n];
			for(int i=0; i<n; i++){
				str=in.nextLine().trim();
				String[] inStr = str.split(" ");
				start[i] = Integer.parseInt(inStr[0]);
				end[i] = Integer.parseInt(inStr[1]);
			}
			
		}catch(Exception e){
			System.out.println("输入异常");
		}
		
		if(start != null && end != null ){
			activitySort(start, end);
			int sum = 1; 
			int temp = end[0];
			for(int i=1; i<n; i++){
				if(start[i] >= temp){
					sum++;
					temp = end[i];
				}
			}
			System.out.println(sum);
		}
		
		
	}
}
