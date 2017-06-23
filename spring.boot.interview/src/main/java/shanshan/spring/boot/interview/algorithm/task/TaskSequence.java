package shanshan.spring.boot.interview.algorithm.task;

import java.util.Scanner;

/**
 * 任务顺序执行
 * 	有N个任务需要执行，第i个任务计算时占R[i]个空间，而后会释放一部分，最后储存计算结果需要占据O[i]个空间（O[i] < R[i]）
 * @author zss
 * @date 2017年6月21日
 */
public class TaskSequence {
	
	/**
	 * 向数组a、b的第i个位置插入数据，并排序
	 *           按照b从大向小排序
	 * @param a
	 * @param b
	 * @param i
	 * @param ai
	 * @param bi
	 */
	private static void inset(int[] a, int[] b, int i, int ai, int bi) {
		if(i==0){
			a[i] = ai;
			b[i] = bi;
		}else if(bi <= b[i-1]){
			a[i] = ai;
			b[i] = bi;
		}else{
			int k = getbestBit(b, i-2, bi);
			System.arraycopy(a, k, a, k+1, i-k);
			System.arraycopy(b, k, b, k+1, i-k);
			b[k] = bi;
			a[k] = ai;
		}
	}
	
	private static int getbestBit(int[] b, int i, int bi){
		for(; i>=0; i--){
			if(bi <= b[i]){
				return i+1;
			}
		}
		return i < 0 ? 0 : i;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param i
	 * @param ai
	 * @param bi
	 */
	private static void swapArray(int[] a, int[] b, int i, int ai, int bi) {
		for(; i>=0; i--){
			if(bi > b[i]){
				b[i+1] = b[i];
				a[i+1] = a[i];
			}else{
				b[i+1] = bi;
				a[i+1] = ai;
				break;
			}
			if(i==0){
				b[0] = bi;
				a[0] = ai;
			}
		}
	}
	
	/**
	 * -a+b始终为正整数
	 * @param a
	 * @param b
	 * @return
	 */
	private static long getSum(int[] a, int[] b){
		long sum = a[0];
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
//		long startTime = System.currentTimeMillis();
		int n = 0; //n个任务
		int[] r = null; //n个任务执行所需的空间
		int[] b = null; 
		
		try{
			Scanner sc =new Scanner(System.in);
			n = sc.nextInt();
			r = new int[n];
			b = new int[n];
			for(int i=0; i<n; i++){
				int temp0 = sc.nextInt();
				int temp1 = sc.nextInt();
				inset(r, b, i, temp0, temp0-temp1);
			}
		}catch(Exception e){
			System.out.println("输入异常");
		}
		
		System.out.println(getSum(r,b));
//		System.out.println(System.currentTimeMillis()-startTime);
	}

}
