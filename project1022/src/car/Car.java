//이 클래스는 모든 자동차류의 최상위 클래스로서, 가장 보편적인 기능과 속성들만을
//보유하면 됩니다.
package car;
public class Car{
	String brand;

	//부모 클래스의 생성자를 정의
	/*
	public Car(){
		System.out.println("자식의 super()호출에 의해 난 호출됩니다.");
	}
	*/
	//개발자가 매개변수 있는 생성자만 정의함, 개발자가 생성자를 정의하면 컴파일러에 의한 디폴트 생성자
	//자동 삽입은 없음
	//따라서 Car 클래스는 생성자가 오직 딱 1개만 있게됨
	public Car(String brand){ //매개변수 있는 생성자라서, new Car()등 방법으로 호출해야함
		this.brand=brand;
	}
	public Car(){ //매개변수 없는 생성자도 추가, 생성자가 2개 이상 추가되면 마치 중복정의처럼
		//보이지만, 자세히 보면 매개변수의 갯수가 틀리므로 오버로딩으로 인정
		//이렇게하면, Taxi()생성자에서 매개변수 없는 super() 호출시, 이 디폴트 생성자를 호출하게 된다.
		
	}
	public void move(){
		System.out.println("차가 움직입니다.");
	}
}
