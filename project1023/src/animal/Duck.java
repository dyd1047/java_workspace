package animal;
public class Duck extends Bird{
	//Duck is a Bird
	String name="난오리";

	public void quack(){
		System.out.println("꽥꽥");
	}
	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b = new Bird();

		//객체 자료형도 자료형이다.
		Duck a = new Duck();
		Bird r = new Bird();
		r = a; //가능
		a = r; //불가능
		a = (Duck)r; //downcasting
		r = (Bird)a; //upcasting
		//결론 : 객체자료형도 자료형이므로, 기본자료형의 원칙이
		//상당부분 그대로 적용되고 있다
	}
}
