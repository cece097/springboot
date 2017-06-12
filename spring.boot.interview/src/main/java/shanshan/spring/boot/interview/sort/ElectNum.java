package shanshan.spring.boot.interview.sort;

/**
 * 从n个数中选出最大的m个数
 * @author Administrator
 * @date 2017年6月9日
 */
public class ElectNum extends BaseSort{
	
	
	private static int[] electNum(int[] a, int m){
		if(a.length <= m){
			return a;
		}else{
			int[] b = new int[m];
			for(int i=0; i<m; i++){
				int maxKey = getMaxKey(a,m,a.length);
				if(a[i] < a[maxKey]){
					b[i] = a[maxKey];
					swap(a,i,maxKey);
				}else{
					b[i] = a[i];
				}
			}
			return b;
		}
	}
	
	/**
	 * 找出数组某范围内的最大值所在位置
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	private static int getMaxKey(int[] a, int low, int high){
		int temp = low;
		for(int i=low+1; i<high; i++){
			if(a[i] > a[temp]){
				temp = i;
			}
		}
		return temp;
	}
	
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		int[] b = electNum(a, 6);
		printInt(b);
	}
}
