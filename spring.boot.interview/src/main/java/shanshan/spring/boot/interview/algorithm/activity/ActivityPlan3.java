package shanshan.spring.boot.interview.algorithm.activity;

import java.util.Scanner;

/**
 * 有若干个活动，第i个开始时间和结束时间是[Si,fi)，同一个教室安排的活动之间不能交叠，求要安排所有活动，最少需要几个教室？
 * @author zss
 * @date 2017年6月21日
 */
public class ActivityPlan3 {
	
	/**
	 * 活动安排
	 * @param a 代表开始时间
	 * @param b 代表结束时间
	 * return 所需教室数量
	 */
	private static int activityPlan(long[] a, long[] b){
		if(a == null || b == null){
			return 0;
		}
		
		int[] num = new int[b.length];
		getMaxByTime(a,b,num);
		return getMax(num);
	}
	
	private static void activitySort(long[] a, long[] b){
		for(int i=0; i<b.length-1; i++){
			for(int j=0; j<b.length-i-1; j++){
				if(a[j] > a[j+1]){
					swap(a, j, j+1);
					swap(b, j, j+1);
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
	
	private static void getMaxByTime(long[] a, long[] b, int[] num){
		activitySort(a,b);
		num[0] = 1;
		for(int i=1; i<a.length; i++){
			int k = 1;
			for(int j=i-1; j>=0; j--){
				if(b[j] > a[i]){
					k++;
				}
			}
			num[i] = k;
		}		
	}
	
	private static int getMax(int[] n){
		int max = n[0];
		for(int i=1; i<n.length; i++){
			if(n[i] > max){
				max = n[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int n = 0;
		long[] start = null;
		long[] end = null;
		
		try{
			Scanner in=new Scanner(System.in);
			String str=in.nextLine().trim();
			
			n = Integer.valueOf(str);
			start = new long[n];
			end = new long[n];
			for(int i=0; i<n; i++){
				str=in.nextLine().trim();
				String[] inStr = str.split(" ");
				start[i] = Integer.parseInt(inStr[0]);
				end[i] = Integer.parseInt(inStr[1]);
			}
			
		}catch(Exception e){
			System.out.println("输入异常");
		}
		if(start!=null){
			System.out.print(activityPlan(start,end));
		}
		
	}
}
