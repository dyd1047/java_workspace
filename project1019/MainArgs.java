/*
����ο� �Ű����� �����Ͽ� �����غ���
*/
class  MainArgs{
	// main�� ��ü?
	// ���� ����ζ� �Ҹ���... �ٵ� ������ ����, �и� �޼����ӿ���
	// �츮�� ȣ���� ���� ���µ� ������ �ȴ�...
	// ��) ���� �޼���� java.exe�� ���� ȣ��ȴ�.
	// ���� �ڵ峻���� ȣ���ϴ� ����� �ƴ϶�, �ڹ��� ���� ���Ͽ� ���� ȣ��ȴ�.
	// main�� �޼�����, �� �ȿ� ����� ������ �Ű������δ�.
	// �׷��ٸ�, java.exe�� ���� main �޼��� ȣ��� �Ű������� ȣ�⵵, �԰�
	// �Ѱܾ��ϴ� ���� ���� java.exe�� �����ؾ��Ѵ�.
	public static void main(String[] args) {
		System.out.println("����� �Ѱܹ��� �Ű������� ��	"+args.length);
		// �Ѿ�� �Ű������� ��� ����Ͻÿ�.
		for(var i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
		//System.out.println("Hello World!");
	}
}