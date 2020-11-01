package day1030.FileChooser;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileChooserTask extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu m_file;
	JMenuItem[] items;
	JTextArea area;
	JScrollPane scroll;
	
	String[] item_title = {"열기", "저장"};
	
	public FileChooserTask() {
		super("File Editer");
		//생성
		bar = new JMenuBar();
		m_file = new JMenu("파일");
		items = new JMenuItem[item_title.length];
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		//items에 item_title 연결
		for (int i = 0; i < item_title.length; i++) {
			items[i] = new JMenuItem(item_title[i]);
			m_file.add(items[i]);
			items[i].setPreferredSize(new Dimension(60, 25));
		}
		
		//조립
		this.setJMenuBar(bar);
		add(scroll);
		bar.add(m_file);
		
		//스타일 적용
		m_file.setPreferredSize(new Dimension(75, 25));
		
		//리스너 연결
		items[0].addActionListener(this);
		items[1].addActionListener(this);
		
		//JFrame에 기본값
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == items[0]) {
			open();			
		}else if(obj == items[1]) {
			save();
		}
	}
	
	public void open() {
		JFileChooser chooser = new JFileChooser();
		int c_value = chooser.showOpenDialog(this);
		if (c_value == 0) {
			File file = chooser.getSelectedFile();
			try {
				String tmp, str = "";
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((tmp = br.readLine()) != null) {
					str += tmp;
				}
				System.out.println(str);
				area.append(str);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("파일 열기를 선택하셨습니다.");			
		}else {
			System.out.println("파일 열기를 취소하였습니다.");
		}
	}
	
	public void save() {
		JFileChooser chooser = new JFileChooser();
		int c_value = chooser.showSaveDialog(this);
		if (c_value == 0) {
			File file = chooser.getSelectedFile();
			
			System.out.println("파일 저장을 선택하셨습니다.");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(area.getText());
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("파일 저장을 취소하였습니다.");
		}
	}
	
	public static void main(String[] args) {
		new FileChooserTask();
	}

}
