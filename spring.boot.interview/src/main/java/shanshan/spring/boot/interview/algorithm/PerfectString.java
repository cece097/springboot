package shanshan.spring.boot.interview.algorithm;

import shanshan.spring.boot.interview.sort.BaseSort;
import shanshan.spring.boot.interview.sort.BubbleSort;

/**
 * 完美字符串
 *    求最大完美度
 * @author zss
 *
 */
public class PerfectString extends BaseSort{
	
	/**
	 * 初始化数组
	 * @return
	 */
	private static int[] getInitInt(){
		int[] in = new int[26];
		for(int i = 0; i < 26; i++) {  
            in[i] = 0;  
        } 
		return in;
	}
	
	/**
	 * 以int[]形式存储字符出现个数
	 * @param str
	 * @return
	 */
	private static int[] getCharNum(String str){
		int[] count = getInitInt();
		
		for(int i=0; i<str.length();i++){
			char key = str.charAt(i);
			if(key > 96){
				count[key-97]++;
			}else{
				count[key-65]++;
			}
		}
		
		printInt(count);
		
		return count;
	}
	
	
	public static long perfect(String str){
		long sum = 0L;
		if(str == null || str.length() == 0){
			return 0L;
		}
		
		int[] count = getCharNum(str);  
		
		//冒泡排序，最大的置后
		count = BubbleSort.bubbleSort(count);
		for(int j=0; j<count.length; j++){
			sum += (j+1) * count[j]; 
		}
		return sum;
	}
	
	public static void main(String[] args){
		String a = "babk";
		long sum = perfect(a);
		System.out.println(sum);  
	}
}
