package shanshan.spring.boot.interview.algorithm;

/**
 * 河内之塔算法
 *    三个柱子之间搬运
 * @author zss
 *
 */
public class HanoiTowers {
	
	
	public void hanoi(int n, char a, char b, char c){
		if(n == 1)
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
        else {
        	hanoi(n - 1, a, c, b);
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
            hanoi(n - 1, b, a, c);
        }
	}
	
	public static void main(String args[]) {
        int n = 2;
        HanoiTowers hanoi = new HanoiTowers();
        hanoi.hanoi(n, 'A', 'B', 'C');
    }
}
