package use;
import car.*;// *의 대상이 될 수 있는건 패키지명이 아니라 클래스명
			// 참고로 현업에서는 *를 잘 쓰지 않는다. 저렇게 해버리면 import에서 다루고자하는
			// 기술이 무엇인지 빨리 해석이 안됩니다. 따라서 따로따로 해주는 것이 좋다.

class UseCar{
	public static void main(String[] args) {
		Taxi t = new Taxi(); // 택시의 인스턴스 생성, 얼핏보기에는 택시만 생성될 것 같지만
							 // 택시보다 앞선 부모인 Car 가 존재해야, 택시도 존재할 수 있기 때문에
							 // js 시절의 원리가 그대로 적용되어 Car 인스턴스도 생성된다.
		t.pass(); // 택시 메서드 호출
		//Car 클래스가 보유한 변수를 메서드 호출한다.
		t.move();
	}
}
