package shanshan.spring.boot.interview;

public class StringClass {
	
	public static void stringEqual(){
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		String d = new String("abc");
		
		System.out.println(a==b);     //true
		System.out.println(a.equals(b));//true
		System.out.println(a.equals(c));//true
		System.out.println(a==c);//false
		System.out.println(c==d);//false
		System.out.println(c.equals(d));//true
	}
	
	public static void main(String[] args){
		stringEqual();	
	}
	
}
