package use;
//����Ϸ��� Ŭ������ ��ġ ���
import bank.Account; //bank ������ ��δ� �̹� classpath�� ��ϵǾ�����
class UseAccount{
	public static void main(String[] args) {
		Account acc = new Account(); //���� Ŭ���� ����
		//bank ������� public���� ����Ǿ� �����Ƿ�, ������ ������ ����
		System.out.println(acc.bank);

		//customer�� protected�� ����Ǿ� �����Ƿ� ��Ӱ��迡 �ְų�, ���� ��Ű�� ��쿡�� ������ ����
		//���� UseAccount�� Account�� ��Ӱ��谡 ����
		//���� �ٸ� ��Ű���̹Ƿ�, ������ ������ �Ұ�����
		//System.out.println(acc.customer);

		//���¹��� num������, �����ڰ� �ƹ��͵� ������� �ʾҴµ���, �̷��� ���������ڸ� default ���������ڶ��ϰ�,
		//default��� Ű���带 ����ؼ��� �ȵȴ�. �׳� ���־���
		//default ���� �����ڴ� ���� ��Ű���� �ִ� Ŭ���������� ������ ������ֹǷ�, protected����
		//�Ѵܰ� �� ��ٷӴ�.(�� ��Ӱ��迡 �־, ���� ��Ű���� �ƴ϶�� ���� �Ұ���)
		//System.out.println(acc.num);
		//"�����Ǿ� ���� �����Ƿ� �ܺο��� ������ �Ұ��մϴ�."��� �޽����� ����
		//���ݱ��� �ǽ��ߴ� ��� Ŭ������ ���default����, �츮�� ���� ���丮����
		//�ǽ��� �ؿԱ� ������ ���ݱ��� �̷� ������ ������ �ʾҴ� �ͻ�... ���� ��Ű���� ����ϱ�
		//������ ���������ڸ� ���� �˾ƾ���
		
		//���� �ܾ� balance�� �׽�Ʈ�غ���.
		//balance�� ���� ������ ������������ private�� ����Ǿ� �����Ƿ�, Account Ŭ���� ������
		//�� ������ �����ϴ�. ���� �츮�� Account �ڽ��� �ƴ϶�, �������� ��� ����
		//���� ������̴�.
		//System.out.println(acc.balance);
		//balance has private access in Account(private ���������ڰ� ����Ǿ� �ִٴ� �ǹ�)

		//�ܰ� ����
		acc.setBalance(10);

		//�ܰ� Ȯ��
		System.out.println(acc.getBalance());
	}
}
