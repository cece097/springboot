package shanshan.spring.boot.interview;

/**
 * 
 * @author Administrator
 * @date 2017年6月8日
 */
public class ShortClass {
	
	/**
	 * 注意：1.short范围
	 *     2.short运算，是先转换为int进行运算
	 */
	public static void addShort(){
		short a=1,b=1;
		short c = 1;
		a += 65533;
		b += 65534;
		c+= 65535;
		System.out.println(a);  //-2
		System.out.println((short)65534);//-2
		System.out.println(b);    //-1
		System.out.println(c);    //0
		System.out.println(Short.MIN_VALUE);  //-32768
		System.out.println(Short.MAX_VALUE);  //32767
	}
	
	public static void main(String[] i){
		addShort();	
	}
}
