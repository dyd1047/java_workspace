//�۾� ũ�� ���� ctrl + (+, -)
//font : window > Preferences > font serch
//����Ű ��� ���� ctrl + shift + L
//�ڵ� ����Ʈ : ctrl + shift + O
//�ڵ� ���� : ctrl + shift + F
//�ش� ��ü�� API���� �ٷΰ��� : �ش� Ŭ������ Ŀ�� �ø� �� shift + F2

package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame {
	// �ڹٿ����� üũ�ڽ��� ������ �����
	CheckboxGroup group = new CheckboxGroup();

	public RadioTest() {
		setLayout(new FlowLayout());
		this.add(new Checkbox("운동", group, false));
		this.add(new Checkbox("독서", group, false));
		this.add(new Checkbox("컴퓨터", group, false));
		this.add(new Checkbox("요리", group, false));
		this.add(new Checkbox("애견돌보기", group, false));
		
		setSize(300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RadioTest();
	}
}
