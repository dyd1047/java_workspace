//���콺 �̺�Ʈ �����ϱ�
package event;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MyMouse implements MouseListener{
	//���콺 Ŭ����, ���콺 Ŭ���߾� �޼��� ����
	public void mouseClicked(MouseEvent e){
		System.out.println("���콺 Ŭ���߾�");
	}
	public void mouseEntered(MouseEvent e){
		System.out.println("mouseEntered called...");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("mouseExited called...");
	}
	public void mousePressed(MouseEvent e){
		System.out.println("mousePressed called...");
	}
	public void mouseReleased(MouseEvent e){
		System.out.println("mouseReleased called...");
	}

}
