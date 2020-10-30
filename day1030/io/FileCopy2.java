package day1030.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
	String ori;
	String dest;
	FileInputStream fis;
	FileOutputStream fos;
	
	public FileCopy2(String ori, String dest) {
		this.ori = ori;
		this.dest = dest;
		
		try {
			fis = new FileInputStream(ori);
			System.out.println("스트림 생성 성공!!");
			fos = new FileOutputStream(dest);
			
			int data;
			while(true) {
				data = fis.read();
				if(data == -1) {break;}
				fos.write(data);
			}
			System.out.println("복사처리를 완료하였습니다.");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
