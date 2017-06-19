package shanshan.spring.boot.interview.algorithm;

/**
 * 给定一个十进制正整数N，写下从1开始，到N的所有正数，计算出其中出现所有1的个数。
 * 例如：n = 12，包含了5个1。1,10,12共包含3个1，11包含2个1，总共5个1。
 * @author zss
 * @date 2017年6月4日
 */
public class OneCount {
	
	/**
	 * 循环实现
	 * @param n
	 * @return
	 */
	public static int count(int n){
		if( n <= 0){
			return 0;
		}
		
		int num = 0;
		int tn = n;
		int t, mul =1;
		while(tn > 0){
			t = tn % 10;  
	        if (t == 0){
	        	num += n / (mul * 10) * mul;  //高位数字   
	        }
	        else if (t == 1) 
	        {  
	        	num += n / (mul * 10) * mul;  
	        	num += (n % mul) + 1;  
	        }  
	        else{ //只与高位有关
	        	num += (n / (mul * 10) + 1) * mul;  
	        }
	        mul *= 10;  
	        tn /= 10;  
		}
		
		return num;
	}	
	
	/**
	 * f(10^n -1) = n*10^(n-1)
	 * @param n
	 * @return
	 */
//	private static int count2(int n){
//		return 0;
//	}
	
	public static void main(String[] args){
		for(int i=0; i<10;i++){
			int k = (int) Math.pow(10, i) -1;
			System.out.print(k);	
			System.out.print(":");	
			System.out.println(count(k));	
		}
	}
}
