package string;

//�ڹ��� ��� ��ü�� ���� ���� �� ���� �ֻ��� ��ü�� �ΰ� �ִ�.
//Object ��ü�̴�. �����ڰ� ����� ������� �ʴ��� ����Ʈ�� �̹� ��ӵǾ� �ִ�.
class Duck{
	String name = "����";

	//�Ʒ��� �޼���� Object Ŭ�����κ��� ��ӹ��� �޼����̸�,
	//�� �޼���� ��ü�� ��Ʈ������ ��ȯ�ϰ��� �� �� �����F��!
	//�� �Ʒ��� �޼����, ��ü�� ����ϰ��� �� �� � �ڵ����� �����F��.
	//�Ʒ��� �޼���� Object�� �޼���������, �׽�Ʈ�� �����ϴ� ������ �˱����� ���
	//�������̵� ����.
	public String toString(){
		System.out.println("toString() �޼��� �����մϴ�.");
		return "";
	}
	public static void main(String[] args){
		Duck d = new Duck();

		//System.out.println(d); //���� ��ü�� �ƴ϶�, ������ �ּҰ�
		System.out.println(new Duck()); //���� ��ü�� ���
	}
}
