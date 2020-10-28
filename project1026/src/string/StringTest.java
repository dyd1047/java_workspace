package string;
class StringTest{
	public static void main(String[] args){
		/*
		String �� Ŭ������!
		������ �츰 �ΰ��� String�� �ʹ� �е������� ���� ����ϱ� ������,
		new �����ڿ� ���� ��Ʈ���� �����ϴ� ���� �ʹ� �����ϴ�
		���� String ���ؼ��� ��ġ �Ϲ� �����ʹ���ó�� new ���� �ʴ� ǥ������ �������ش�
		�̷��� String �� ��������� �Ͻ���, ������(implicit) ������
		������ �������� ���� String �� ���Ǯ�� ���� �����Ǿ� ���µ�,
		*/
		String s1 = "apple";
		String s2 = "apple";
		System.out.println(s1 == s2);

		//String�� ���۹����� 'S'�� �빮�ڷ� ���� �и� ��ü���̴�
		//�츮�� ����ȯ�濡�� String.class�� ��򰡿� �־�� �ϴµ�, ������ �ʴ´�.
		//java se �� ��� api�� �����ִ� ����� ����...
		//C:/Java/jdk1.8.0_251/jre/lib/rt.jar

		//�Ʒ��� ���� new �����ڿ� ���� ��Ʈ�� �������� �����(explicit)�������̸�,
		//����� �������� ���Ǯ�� �������� �����Ƿ�, new �Ҷ����� �ߺ� ���θ� ������ �ʰ�
		//������ �����ȴ�!
		String s3 = new String("korea");
		String s4 = new String("korea");
		System.out.println(s3 == s4);

		//�ּҺ񱳰� �ƴ�, ��ü ���ϼ� ���ϴ� ��
		String k1 = "orange";
		String k2 = "orange";
		System.out.println(k1 == k2);//�ּҺ�
		System.out.println(k1.equals(k2));//�����
	}
}
