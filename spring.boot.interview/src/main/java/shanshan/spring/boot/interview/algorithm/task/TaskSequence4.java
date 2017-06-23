package shanshan.spring.boot.interview.algorithm.task;

import java.util.Scanner;

/**
 * jdk1.4可用
 * @author zss
 *
 */
public class TaskSequence4 {
	
	private static void swap(int[] num, int a, int b){
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	private static void bubbleSort(int low, int high, int[] a, int[] b){
		for (int i=low; i<high; i++){
			for (int j=i; j>low && b[j-1]-b[j]<0; j--){
				swap(b, j, j-1);
				swap(a, j, j-1);
			}
		}
	}
	
	private static void mergeSort(int low, int high, int[] a, int[] b, int[] ca, int[] cb){
		int n = high - low;
		if(n<7){
			bubbleSort(low,high,a,b);
			return;
		}

		int mid = (low + high)/2;
		mergeSort(low, mid, ca, cb, a, b);
	    mergeSort(mid, high,ca, cb, a, b);
	    
	    if(cb[mid-1] > cb[mid]){
	    	//将ca、cb复制到a、b
	    	System.arraycopy(cb, low, b, low, n);
	    	System.arraycopy(ca, low, a, low, n);
	    	return;
	    }
	    
	    
	    for(int i = low, p = low, q = mid; i < high; i++) {
            if (q >= high || p < mid && cb[p]>cb[q]){
            	int temp0 = p++;
            	b[i] = cb[temp0];
            	a[i] = ca[temp0];
            }else{
            	int temp = q++;
            	b[i] = cb[temp];
            	a[i] = ca[temp];
            }
        }
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 */
	private static void taskSort(int n, int[] a, int[] b) {
		mergeSort(0,n,a,b,(int[])a.clone(),(int[])b.clone());
	}

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
		try{
			Scanner sc =new Scanner(System.in);
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for(int i=0; i<n; i++){
				int temp0 = sc.nextInt();
				a[i] = temp0;
				b[i] = temp0-sc.nextInt();
			}
			
			taskSort(n, a, b);
			System.out.println(getSum(a,b));
		}catch(Exception e){
			System.out.println("输入异常");
		}		
	}

}
