package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout;

public class MultiButton extends Frame{
	Button bt1, bt2;
	TextField t;

	public MultiButton(){
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		t = new TextField(20);

		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(t);

		MyActionListener listener = new MyActionListener(bt1, bt2, t);

		//버튼과 리스너 연결
		bt1.addActionListener(listener);
		bt2.addActionListener(listener);
		t.addActionListener(listener); //텍스트박스에도 클릭이벤트 적용 가능

		setSize(300,400);
		setVisible(true);
	}
	public static void main(String[] args){
		new MultiButton();
	}
}
