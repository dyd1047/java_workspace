/*
고양이를 정의하시오
클래스명 : Cat
이름 : 묘
나이 : 3
결혼여부 : 미혼
걷는 동작
우는 동작

UseCat 클래스로 Cat의 정보를 화면에 출력해본다.
*/
class  Cat{
	String name="설";
	int age=3;
	String married="미혼";

	public void walk(){
		System.out.println("걷는다");
	}

	public void miu(){
		System.out.println("miumiu");
	}
}
