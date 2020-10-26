/*
�����쿡 �� �� �ִ� ���� ������Ʈ �˾ƺ���
ex) ��ư, �ؽ�Ʈ �ʵ�, �����ڽ�, üũ�ڽ�, ���̽�, �̹���...
*/
package gui;
import java.awt.Frame; //����Ϸ��� Ŭ������ ��ġ ���
					   //��򰡿� .class�� �����ϱ� ������ ��밡���� ���̴�.
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;
class App1{
	public static void main(String[] args){
		/*������ ����*/
		//���� ó������ Ŭ������ ������ �� ��ó��
		//����, ��ó�ڼ�0)����Ϸ��� Ŭ������ ���� � �������� �����Ǵ� ������ �� �뵵�� �ľ�
		//����, ��ó�ڼ�1)�ڹ��� ��� ��ü�� �ᱹ 3���� �����ۿ� ����.
		//����, ��ó�ڼ�2)Ŭ������ ����� ������̴�, ���� �޸𸮿� �ø��� ���� �˸�ȴ�.
		//1. �Ϲ�Ŭ���� : new �ϸ� �ȴ�! new ���� ����������(api������ ����)
		//2. �߻�Ŭ���� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new �ϰų� �̹� �����ϴ� �ν��Ͻ��� �̿��ϸ� �ȴ�.(api������ ����)
		//3. �������̽� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� �ȴ�.(api������ ����)

		//ó��������, �Ϲ��̱� ������ new ������ ���� �����ڸ� �����ؼ� ����ϸ� ��
		Frame frame = new Frame(); //�ڹ� ���������α׷��ֿ����� ������!
		//�������� ����Ʈ�� ���� ������ �ʴ� ������, ���� ���̵��� �޼��� ȣ��!
		frame.setVisible(true);//Window ��ü�κ��� ��ӹ޴� �޼���
		//�Ű������δ� ������ ����� �� �ִ�.
		//�������� �ʺ�, ���̸� ������ �� �ִ� �޼��� ã��
		frame.setSize(300, 400);//apiã�ƺ���

		//�����찡 �����Ǿ����Ƿ�, ������ �ȿ� ��ġ�� ���� ������Ʈ �÷����ƺ���
		//��ư Button(�Ϲ�, �߻�, �������� ��, �Ϲ� new ������ ����)
		Button bt = new Button("����ư");

		//��ư�� �����ϱ� ����, ���̾ƿ� ��Ÿ���� �����ؾ� �ϴµ�, ���̾ƿ��� ���� ���Ŵϱ�
		//�ϴ� FlowLayout�� ����غ���
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);//�����쿡 �÷ο����� ��ġ����

		//��ư�� ������ �����̳ʿ� ��������
		frame.add(bt); //add�޼����� �Ű������� Component���̹Ƿ�,
		//Button�� Component�� �ڽ��̱� ������ ���� �ڷ����� �ش��Ͽ�, add()��
		//�μ��� �� �� �ִ�.

		//html ������ imput type = "text"�� �ڹٿ����� TextField�� �Ѵ�.
		TextField t = new TextField("ȸ������", 10);
		frame.add(t);

		Checkbox ch1 = new Checkbox("����");
		Checkbox ch2 = new Checkbox("����");
		Checkbox ch3 = new Checkbox("��ǻ��");
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);

		TextArea area = new TextArea(5, 20); //5��, 20��
		frame.add(area);

		//�׳� �ؽ�Ʈ
		Label la = new Label("ȸ������ ����Դϴ�.");
		frame.add(la);

		//�̹��� �ֱ�
		//Image�� �߻�Ŭ�����̸�, �÷���(win, mac, linux)�� ������ ������� ���� �� �ִ�.
		//�÷����� �°� ����������, DefaultToolkit Ŭ�����κ��� �ڿ��� ���� �Ѵ�.
		Toolkit kit = Toolkit.getDefaultToolkit(); //static �޼��� ���� Ŭ���������� ������ �� �ִ�.
		//��Ŷ�� �̹����� ���û��� ��ηκ��� ���� �� �ִ�.
		//��λ��� ������ �� : �������ô� ������os������ ����ϴ� ǥ���̹Ƿ�,
		//���� �� �ڹ��ڵ尡 ��� os���� ����Ƿ���, ��� �߸����� ��η� �����Ѵ�.
		Image img = kit.getImage("D:/User/yong/LN/workspace/athome/workspace-HTML/java_workspace/project1026/res/mario.png");
		System.out.println("�̹��� �ּҰ��� " + img); //null ������ �� ������ ����

		//���ݱ��� html������ �̹����� ������ ���ٿ��� ����������, �ڹٿ� ���� �Ϲ����� �����ϱ���� ���α׷��� ������ ������(���� �׸��� �۾�)�� �ؾ��ϱ� �����̴�.
		

	}
}
