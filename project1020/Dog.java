class  Dog{
	String name="dog";
	int age=5;
	static String color="white"; // 이 변수는, 클래스로부터 생성된 인스턴스에 딸려 올라가지 말고
	// 클래스 원본에 딱 달라붙어 있어라.. 즉 인스턴스 소속이 아니라, 클래스 원본 소속으로 선언!!

	public void bark(){
		System.out.println("woooo");
	}

	public static void main(String[] args){ // java.exe 매개변수
//		Dog.coloc="black"; FM적인 표현방식
		color="yellow";
		int a=8;
		Dog d1=new Dog();
		Dog d2=new Dog();
		boolean k=true;
	}
}
