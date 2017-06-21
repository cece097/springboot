package shanshan.spring.boot.interview.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TaskSequence0 {
	
	private static void swap(int[] num, int a, int b){
		if(num.length < a || num.length < b){
			return;
		}
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	private static void taskSort(int[] a, int[] b){
		for(int i=0; i<b.length-1; i++){
			for(int j=0; j<b.length-i-1; j++){
				if(b[j] < b[j+1]){
					swap(a, j, j+1);
					swap(b, j, j+1);
				}
			}
		}
	}
	
	private static int getbestBit(int[] b, int i, int bi){
		for(; i>=0; i--){
			if(bi <= b[i]){
				break;
			}
		}
		return i < 0 ? 0 : i;
	}
	
	/**
	 * -a+b始终为正整数
	 * @param a
	 * @param b
	 * @return
	 */
	private static int getSum(int[] a, int[] b){
		int sum = a[0];
		int dvalue = a[0];
		for(int i=0; i<b.length; i++){
			if(dvalue < a[i]){
				sum += a[i] - dvalue;
				dvalue = a[i];
			}
			dvalue = dvalue - a[i] + b[i];
		}
		return sum;
	}
	
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
//		int n = 0; //n个任务
//		int[] r = null; //n个任务执行所需的空间
//		int[] o = null; //n个任务存储所需的空间
//		int[] b = null; 
//		
//		try{
//			Scanner sc =new Scanner(System.in);
//			n = sc.nextInt();
//			r = new int[n];
//			o = new int[n];
//			b = new int[n];
//			for(int i=0; i<n; i++){
//				r[i] = sc.nextInt();
//				o[i] = sc.nextInt();
//				b[i] = r[i] - o[i];
//			}
//			
//		}catch(Exception e){
//			System.out.println("输入异常");
//		}
		
		int[] r = new int[100000];
		int[] b = new int[100000];
		for(int i =0; i<100000; i++){
			r[i] = 100000-i+23;
			b[i] = i+5;
		}
		taskSort(r,b);
		
		System.out.println(getSum(r,b));
		System.out.println(System.currentTimeMillis()-startTime);
	}
}
