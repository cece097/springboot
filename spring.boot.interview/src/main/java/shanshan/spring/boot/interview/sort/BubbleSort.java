package shanshan.spring.boot.interview.sort;

/**
 * java实现冒泡排序
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，让较大（小）的数往下沉，较小（大）的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * @author Administrator
 * @date 2017年6月8日
 */
public class BubbleSort extends BaseSort{
	
	/**
	 * 冒泡排序
	 * @param a
	 * @return
	 */
	public static int[] bubbleSort(int[] a){
		for(int k=0; k<a.length-1; k++){
			for(int j=0; j<a.length-k-1; j++){  //从前往后排，所以最后一位是最大或最小值
				if(a[j] > a[j+1]){
					swap(a,j,j+1);
				}
			}
		}
		return a;
	}
	
	
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		a = bubbleSort(a);
		printInt(a);
	}
}
