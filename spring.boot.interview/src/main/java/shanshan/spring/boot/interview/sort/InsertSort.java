package shanshan.spring.boot.interview.sort;

/**
 * 插入排序
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * @author Administrator
 * @date 2017年6月8日
 */
public class InsertSort extends BaseSort{
	
	/**
	 * 插入排序
	 *    从小到大
	 * @param a
	 */
	public static void insertSort(int[] a){
		for(int i=1; i<a.length; i++){  //每个for循环，把i前面的部分当做一个有序组
			int temp = a[i];
			int position = i;
			for(int k=i-1; k>=0; k--){
				if(a[k] > temp){
					a[position] = a[k];
					position--;
				}else{
					break;
				}
			}
			a[position] = temp;
		}
	}
	
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		insertSort(a);
		printInt(a);
	}
}
