//���ݱ����� �ֿܼ����� �ڹٸ� �����������,
//�ڹٵ� �׷��� API�� �����Ѵ�.
//�ڹ��� ������� ��ư�� �̿�
package gui;
import java.awt.Frame; //�������� ��ġ ����
import java.awt.Button;
class AppTest{
	public static void main(String[] args){
		//�ڹٿ����� �������� ������ ���ִ� Ŭ������ Frame�� �����Ѵ�.
		Frame frame;//sun���� ������ Ŭ������, ������ ����.
					//���� sun���� �����ϴ� ���Ĺ����� ���� ��ġ�� �˾Ƴ���.
		frame = new Frame(); //������ ����
		frame.setSize(300, 400);//������ �������� �ʺ� ���� �ֱ�
		frame.setVisible(true);//�������� �Ӽ��� ���̰� ó��

		//��ư �����Ͽ�, �����ӿ� ���̱�
		Button bt = new Button("�� �չ�ư");
		frame.add(bt);
	}
}
