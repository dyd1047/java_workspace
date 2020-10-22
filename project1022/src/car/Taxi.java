package car;
public class Taxi extends Car{
	public Taxi(){
		super("벤츠");
	}
	//부모 클래스에 생성자를 여러개를 정의할때 매개변수 있는것, 없는것, 온갖 종류를
	//다 정의해 놓는 오버로딩
	public void pass(){
		System.out.println("승객을 태워요");
	}
}
