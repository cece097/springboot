package shanshan.spring.boot.interview.sort;

/**
 * 交换、打印等基本方法
 * @author Administrator
 * @date 2017年6月8日
 */
public class BaseSort {
	/**
	 * 将数组num的a与b互换位置
	 * @param num
	 * @param a
	 * @param b
	 * @return
	 */
	public static void swap(int[] num, int a, int b){
		if(num.length < a || num.length < b){
			return;
		}
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	/**
	 * 打印数组
	 * @param a
	 */
	public static void printInt(int[] a){
		for(int i=0;i<a.length;i++) { 
	        System.out.print(a[i]+",");     
		}
		System.out.println(" ");     
	}
	
}
