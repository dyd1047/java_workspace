class  Dog{
	String name="dog";
	int age=5;
	static String color="white"; // �� ������, Ŭ�����κ��� ������ �ν��Ͻ��� ���� �ö��� ����
	// Ŭ���� ������ �� �޶�پ� �־��.. �� �ν��Ͻ� �Ҽ��� �ƴ϶�, Ŭ���� ���� �Ҽ����� ����!!

	public void bark(){
		System.out.println("woooo");
	}

	public static void main(String[] args){ // java.exe �Ű�����
//		Dog.coloc="black"; FM���� ǥ�����
		color="yellow";
		int a=8;
		Dog d1=new Dog();
		Dog d2=new Dog();
		boolean k=true;
	}
}
