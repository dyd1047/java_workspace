/*
jvm�� ������κ���, �̺�Ʈ ������ ������, �ش� ������ ������ ���� �˸´�
�̺�Ʈ ��ü�� �ν��Ͻ��� �޸𸮿� �ø���, �� �÷��� �ν��Ͻ� ������
�����ʶ� �Ҹ���, �̺�Ʈ ���㰴ü���� ���޵¾�����.
�̶� �����ʴ� ��ü�� �ҿ����� �������̽��� �����Ǵµ�, �� ������ Ŭ������ ������ ��
���� ��� ó�������� ���� �����ڰ� �����ؾ� �ϱ� �����̴�.
��) Ŭ���̺�Ʈ�� �ڹٿ��� �׼��̺�Ʈ�� �ϰ� �ش� ��ü�� ActionEvent�̴�.
�� ActionEvent�� �ν��Ͻ��� ����ڰ� Ŭ���� �� ������ �����ʿ��� ���޵Ǿ�����,
�����ڴ� �� �������� �߻�޼��带 ������ �����ν�, �ϰ����� ������ �ϼ���Ű�� �ȴ�.
*/
package event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyListener implements ActionListener{
	//MyListener is a ActionListener

	public void actionPerformed(ActionEvent e){
		System.out.println("�� ����?");
	}

	public static void main(String[] args) {

	}
}