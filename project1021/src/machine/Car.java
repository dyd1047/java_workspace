class  Car{
	String name="benz";
	String color="red";
	int price=500;
	Wheel wheel=null; // �� �ڵ尡 ������ ���� ����??
	// Ŭ���� �ȿ��� �ڷ����� �� �� �ִµ�, �ڹ��� �ڷ����� �� 4���̴�.
	// ���� �� Ŭ���� �ȿ��� ����, ����, ���� �̿ܿ��� ��ü���� �� �� �ִ�.
	//��ü�ڷ����� �ڷ����̴ϱ�
	public Car(){
		wheel = new Wheel();
	}

	public void go(){
		System.out.println("gogo");
	}

	public void stop(){
		System.out.println("stop");
	}

	// Ŭ������� ������ �̸��� �޼��带 ������ �����ڶ� �ϰ�,
	// �����ڴ� �̸������� �� �� �ֵ���, ��ü�� ���� Ÿ�ӿ�, ���� �ʱ�ȭ �۾��� ���� ��
	// �۾��� �����ϴ� �뵵�� �޼����̴�.

	public static void main(String[] args){
		// �ڵ����� �����ϰ�,
		// �� �ڵ����� �̸� ����ϰ�, 
		// �ڵ��� ������ �귣��, ����, ������ ��±��� �Ͻÿ�
		Car c=new Car();
		System.out.println("�ڵ����� �̸��� "+c.name);
		System.out.println("�ڵ��� ������ �귣��� "+c.wheel.brand);
		System.out.println("�ڵ��� ������ ������ "+c.wheel.color);
		System.out.println("�ڵ��� ������ ������ "+c.wheel.price);
	}
}
