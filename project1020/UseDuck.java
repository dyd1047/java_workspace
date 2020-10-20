class  UseDuck{
	public static void main(String[] args) {
		// 오리의 인스턴스를 메모리에 올려보자
		int x=5; // 실행부가 지역변수를 만나면
		// d와 같이 사물자체를 보유하고 있는 변수가 아닌, 사물의 메모리상의 위치만을 담고
		// 있는 변수를 가리켜, 래퍼런스(참조) 변수라 한다.
		Duck d = new Duck();
		System.out.println("오리가 존재하는 힙 영역의 주소는 "+d);
		//컴파일 명령어
		// javac : javac 소스.java
		//실행
		// java : java 클래스명(확장자 없이)
	}
}
