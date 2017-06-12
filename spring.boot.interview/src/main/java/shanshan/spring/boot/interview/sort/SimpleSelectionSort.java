package shanshan.spring.boot.interview.sort;

/**
 * 简单选择排序
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
 * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
 * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 * @author Administrator
 * @date 2017年6月8日
 */
public class SimpleSelectionSort extends BaseSort{
	
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		simpleSelectionSort(a);
		printInt(a);
	}

	/**
	 * 简单快速排序
	 * @param a
	 */
	private static void simpleSelectionSort(int[] a) {
		for(int i=0; i<a.length; i++){
			simpleSelectionSort(a,i,a.length);
		}
	}
	
	private static void simpleSelectionSort(int[] a, int low, int high) {
		int key = getMinKey(a,low,high);
		swap(a, low, key);
		low++;
	}
	
	/**
	 * 查询出最小值所在位置
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	private static int getMinKey(int[] a, int low, int high){
		int temp = low;
		for(int i=low+1; i<high; i++){
			if(a[i] < a[temp]){
				temp = i;
			}
		}
		return temp;
	}
}
