package animal;
public class Duck extends Bird{
	//Duck is a Bird
	String name="������";

	public void quack(){
		System.out.println("�в�");
	}
	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();

		Bird b = new Bird();

		//��ü �ڷ����� �ڷ����̴�.
		Duck a = new Duck();
		Bird r = new Bird();
		r = a; //����
		a = r; //�Ұ���
		a = (Duck)r; //downcasting
		r = (Bird)a; //upcasting
		//��� : ��ü�ڷ����� �ڷ����̹Ƿ�, �⺻�ڷ����� ��Ģ��
		//���κ� �״�� ����ǰ� �ִ�
	}
}
