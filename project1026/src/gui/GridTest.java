/*
awt/swing/fx --> �ȵ���̵�
*/
package gui;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Panel;

class GridTest{
	public static void main(String[] args){
		Frame frame = new Frame("�׸��� ���̾ƿ�");

		//���̾ƿ� �޴��� ���� �� ���
		GridLayout layout = new GridLayout(1,3);

		//�÷ο��ġ������, ������Ʈ�� �ڽ��� ���� ũ�⸦ ���� �� �ִ�.
		//FlowLayout layout = new FlowLayout(2,3);

		//�׸��带 �����ϸ鼭, ������Ʈ�� �ڽ��� ����ũ�⸦ �����ϴ� ���
		//�ΰ��� ������������ �������� ����
		//�ذ�å) ������Ʈ �� ��ġ������ ������ ������ �г��� �̿��ϸ� �ȴ�.
		//�� �κ������� �ٸ� ��ġ�����ڸ� ������ �� ���� ����

		frame.setLayout(layout); //�����ӿ� ���̾ƿ� ����

		Panel p = new Panel(); //���� ������ ����

		Button bt1 = new Button("��ư1");
		Button bt2 = new Button("��ư2");
		Button bt3 = new Button("��ư3");

		p.add(bt1);//�гο� ��ư �ֱ�
		frame.add(p);//�����ӿ� �гγֱ�
		frame.add(bt2);//�гο� ��ư �ֱ�
		frame.add(bt3);//�гο� ��ư �ֱ�

		frame.setSize(300,200);
		frame.setVisible(true);
	}
}