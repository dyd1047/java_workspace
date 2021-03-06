class  Car{
	String name="benz";
	String color="red";
	int price=500;
	Wheel wheel=null; // 이 코드가 낯설지 않은 이유??
	// 클래스 안에는 자료형을 둘 수 있는데, 자바의 자료형은 총 4개이다.
	// 따라서 이 클래스 안에는 문자, 숫자, 논리값 이외에도 객체형도 올 수 있다.
	//객체자료형도 자료형이니까
	public Car(){
		wheel = new Wheel();
	}

	public void go(){
		System.out.println("gogo");
	}

	public void stop(){
		System.out.println("stop");
	}

	// 클래스명과 동일한 이름의 메서드를 가리켜 생성자라 하고,
	// 생성자는 이름에서도 알 수 있듯이, 객체의 생성 타임에, 무언가 초기화 작업이 있을 때
	// 작업을 수행하는 용도의 메서드이다.

	public static void main(String[] args){
		// 자동차를 생성하고,
		// 이 자동차의 이름 출력하고, 
		// 자동차 바퀴의 브랜드, 색상, 가격을 출력까지 하시오
		Car c=new Car();
		System.out.println("자동차의 이름은 "+c.name);
		System.out.println("자동차 바퀴의 브랜드는 "+c.wheel.brand);
		System.out.println("자동차 바퀴의 색상은 "+c.wheel.color);
		System.out.println("자동차 바퀴의 가격은 "+c.wheel.price);
	}
}
