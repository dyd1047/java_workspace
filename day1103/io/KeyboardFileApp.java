package day1103.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class KeyboardFileApp {
	String dir;
	FileWriter writer;
	
	public KeyboardFileApp() {
		URL url = this.getClass().getClassLoader().getResource("res/");
		
		try {
			URL url2 = new URL(url, "empty.txt"); //디렉토리 + 파일명
			URI uri = url2.toURI();
			File file = new File(uri);
			writer = new FileWriter(file);
			System.out.println(uri);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile() {
		//키보드로부터 입력 받은 데이터를 파일로 저장해본다.
		//키보드 스트림은 System으로부터 얻어와야 한다.
		InputStream is = System.in; //바이트(영어)
		//문자기반 스트림으로 업그레이드
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader buffr = new BufferedReader(reader); //버퍼기반의 문자 입력 스트림으로 업그레이드
		
		//파일 출력스츠림 계열은 (empty)빈 파일을 생성해준다.
//		FileWriter writer = new FileWriter();
		
		String msg = "";
		try {
			msg = buffr.readLine();
			System.out.println(msg); //모니터에 출력
			writer.write(msg);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new KeyboardFileApp().saveFile();;
	}
}
