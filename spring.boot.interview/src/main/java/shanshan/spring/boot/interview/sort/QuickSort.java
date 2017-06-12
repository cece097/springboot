package shanshan.spring.boot.interview.sort;

/**
 * 快读排序
 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
 * 一部分比基准元素小,一部分大于等于基准元素,
 * 此时基准元素在其排好序后的正确位置,
 * 然后再用同样的方法递归地排序划分的两部分。
 * @author Administrator
 * @date 2017年6月8日
 */
public class QuickSort extends BaseSort{
	
	/**
	 * 快速排序
	 * @param a
	 * @return
	 */
	public static void quickSort(int[] a){
		//递归方式对a进行快速排序
		_quickSort(a, 0, a.length-1);
	}
	
	/**
	 * 快速排序
	 * @param a
	 * @param min
	 * @param max
	 */
	private static void _quickSort(int[] a, int min, int max){
		if(min < max){   //递归有个截止条件
			int middle = getMiddle2(a,min,max);
//			int middle = getMiddle(a,min,max);
			_quickSort(a,min,middle-1);
			_quickSort(a,middle+1,max);
		}
	}
	
	/**
	 * 取数组low位置元素应在的正确位置
	 * @param list
	 * @param low
	 * @param high
	 * @return
	 */
	private static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];    //数组的第一个作为中轴     
        while (low < high) {     
            while (low < high && list[high] >= tmp) {     
                high--;     
            }     
            list[low] = list[high];   //比中轴小的记录移到低端     
            
            while (low < high && list[low] <= tmp) {     
                low++;     
            }     
            list[high] = list[low];   //比中轴大的记录移到高端     
        }     
        list[low] = tmp;              //中轴记录到尾     
        return low;                   //返回中轴的位置
	}

	private static int getMiddle2(int[] list, int low, int high) {
		int tmp = list[high];    //数组的最后一个作为中轴     
        while (low < high) {     
        	while (low < high && list[low] <= tmp) {     
        		low++;     
        	}     
        	list[high] = list[low];   //比中轴大的记录移到高端     
        	
            while (low < high && list[high] >= tmp) {     
                high--;     
            }     
            list[low] = list[high];   //比中轴小的记录移到低端     
        }     
        list[low] = tmp;              //中轴记录到尾     
        return low;                   //返回中轴的位置
	}
	
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		quickSort(a);
		printInt(a);
	}
}
