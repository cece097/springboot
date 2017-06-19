package shanshan.spring.boot.interview.algorithm;

/**
 * 费式数列
 * @author zss
 *
 */
public class Fibonacci {
	
	private static int fibonacci(int n){
		if(n == 1 || n == 2)
            return 1;
        else {
        	return fibonacci(n-2)+fibonacci(n-1);
        }
	}
	
	public static void main(String args[]) {
        int n = 7;
        System.out.println(fibonacci(n));
    }
}
