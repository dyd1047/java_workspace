package day1113.xml.down;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import common.file.FileManager;

public class DownLoader extends JFrame{
	JButton bt_down;
	JProgressBar bar;
	MovieHandler movieHandler;
	Thread parsingThread;
	
	public DownLoader() {
		bt_down = new JButton("다운로드");
		bar = new JProgressBar();
		
		//스타일
		bar.setPreferredSize(new Dimension(580, 45));
		bar.setForeground(Color.DARK_GRAY);
		bar.setBackground(Color.BLACK);
		
		bar.setFont(new Font("Verdana", Font.BOLD, 25));
		bar.setStringPainted(true);
		
		setLayout(new FlowLayout());
		add(bt_down);
		add(bar);
		
		
		bt_down.addActionListener((e)->{//다운로드 버튼과 리스너 연결
			parsingThread = new Thread() {
				@Override
				public void run() {
					parseData();
					int len = movieHandler.movieList.size(); //총 다운로드 파일 갯수
					for (int i = 0; i < movieHandler.movieList.size(); i++) {
						Movie movie = movieHandler.movieList.get(i); //영화 추출
						download(movie.getUrl());
					}
					//반복문이 모두 수행된 이후 시점이 바로, 다운로드가 모두 완료된 시점
					JOptionPane.showMessageDialog(DownLoader.this, "총 " + len + "개의 파일을 다운로드 완료!!");
				}
			};
			parsingThread.start();
		});
		
		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void parseData() {
		//xml을 파싱하여 url만 추출해야 함
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser(); //파서 객체 생성
			URL url = this.getClass().getClassLoader().getResource("res/marvel.xml");
			File file = new File(url.toURI());
			saxParser.parse(file, movieHandler = new MovieHandler()); //파싱 시작
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//인터넷상의 자원과 연결한 후, 스트림으로 데이터를 읽어와 로컬 하드 경로에 저장하기!
	public void download(String path) { //매개변수로 가져올 자원을 지정한다.
		InputStream is = null;
		FileOutputStream fos = null; //다운받은 파일을 저장할 스트림
		int total = 0; //다운로드 받을 자원의 총 바이트 수
		int count = 0; //현재까지 읽은 바이트 수
		bar.setValue(0); //프로그래스바 초기화
		
		try {
			URL url = new URL(path);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection)con; //웹에 특화된 커넥션 객체.. 따라서 get/post등 웹기반의 요청이 가능
			
			http.setRequestMethod("GET");
			
			//커넥션 객체를 이용하면, 대상 자원의 크기까지 얻어올 수 있다.
			total = con.getContentLength(); //연결된 자원의 총 바이트 반환
			
			is = http.getInputStream(); //연결된 URL로 부터 입력 스트림 얻기
			long time = System.currentTimeMillis(); //파일명으로 사용하자
			String ext = FileManager.getExtend2(path); //확장자 제대로 가져오기
			String filename = time + "." + ext; //최종적으로 부여된 파일명
			fos = new FileOutputStream("D:/User/yong/LN/workspace/athome/workspace-HTML/java_workspace/SeProject/res/download/"+filename);
			int data = -1;
			while(true) {
				data = is.read();
				count++;
				
				bar.setValue((int)getPercent(count, total));
				
				System.out.println((int)getPercent(count, total));
				
				if(data == -1)break;
				fos.write(data);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//퍼센트를 구하는 메서드 정의
	public float getPercent(int read, float total) {
		//읽은 수/ 총바이트 수 * 100
		return (read/total)*100;
	}
	
	public static void main(String[] args) {
		new DownLoader();
	}

}
