package shanshan.spring.boot.interview.sort;

/**
 * 字符串翻转递归
 * @author Administrator
 * @date 2017年6月8日
 */
public class RecursionOne {
	
	private static void recursion(String s){
		if(s.lastIndexOf(" ") > -1){
			System.out.print(s.substring(s.lastIndexOf(" ")+1, s.length())+" ");
			recursion(s.substring(0, s.lastIndexOf(" ")));
		}else{
			System.out.println(s);
		}
	}
	
	/**
	 * 将"Today is a good day"翻转为"day good a is Today"
	 * @param args
	 */
	public static void main(String[] args){
		String str = "Today is a good day";
		recursion(str);
//		System.out.println(s);
	}
}
