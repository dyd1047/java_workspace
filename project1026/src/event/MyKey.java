package event;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//Ű����� ������ �̺�Ʈ�� �߻��ϸ�, �ڹ� ����ӽ��� KeyListener ���� KeyEvent �ν��Ͻ��� �����Ѵ�.
//�� ���޵� �ν��Ͻ��� KeyListener�� ������ �߻�޼���鿡 ���޵Ǿ����Ƿ�,
//�����ڴ� �߻�޼��带 �������ϸ鼭 ���ϴ� ������ �ۼ��ϸ� ��
public class MyKey implements KeyListener{
	//�������̵��ϰ�, Ű���� ���������� ������? �޼��� ������ ó��
	//KeyListener�� ��� �������� �޼��尡 ���� 3���� �ȴ�.
	public void keyPressed(KeyEvent e){
		System.out.println("KeyPressed called..."); //Ű�� ������
	}

	public void keyReleased(KeyEvent e){
		System.out.println("KeyReleased called..."); //Ű�� ������ ����
	}

	public void keyTyped(KeyEvent e){
		//System.out.println("KeyTyped called..."); //Ű�� ĥ��
	}
}
