/*
자바에서 데이터베이스를 연동하는 기술을 가리켜 JBDC(Java DataBase Connectivity)
라고 하며 java.sql 패키지에서 api가 지원된다.
데이터베이스를 연동업무의 순서
1. DB기종에 알맞는 드라이버를 로드 (oracle, mysql, mssql.. 각각 jar가 필요함)
2. 접속
3. 원하는 쿼리 수행
4. 접속 해제(특히 스트림 및 DB는 사용 후 반드시 해제하자..)
*/
package day1105.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class OracleTest{
	public static void main(String[] args){
		Connection con = null; //메서드의 지역변수라서 반드시 초기화해야함(멤버변수처럼 자동으로 해주는 일 없다.)
		PreparedStatement pstmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //사용하고자 하는 드라이버 클래스를 등록!(클래스 로드)
			//현재 사용중인 os플랫폼의 클래스 패스에 등록되어 있어야 한다..
			System.out.println("드라이버 로드 성공입니다");

			//DB서버의 url, id, password
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; //정해진 규칙
			String user = "user1104";
			String password = "user1104";

			//접속 시도 후, 접속이 성공되면 Connection이라는 인터페이스의 인스턴스를 반환해줌
			//Connection에는 성공한 접속 정보가 들어있다.
			//접속 성공여부는 Connection 객체의 null 여부로 판단한다.
			con = DriverManager.getConnection(url, user, password); //접속 시도
			if(con == null){
				System.out.println("접속 실패");
			}else{
				System.out.println("접속 성공");
				//접속이 성공했으므로, 쿼리문을 수행할 수 있다.
				//쿼리문을 수행하는 객체는 PreparedStatement 인터페이스이다.
				String sql = "insert into member(member_id, name, age, phone)";
				sql += " values(seq_member.nextval, 'adams', 38, '010')";

				//접속이 성공 되어야, 쿼리문을 수행할 수 있으므로, Connection 객체로부터 인스턴스를 얻어야 한다.
				pstmt = con.prepareStatement(sql); //쿼리 수행할 준비
				//쿼리 수행 후 성공여부를 판단하기 위해서는 executeUpdate() 메서드의 반환형을 이용한다.
				//반환형은 int값이며, 쿼리문 수행에 의해 반영된 레코드의 수를 반환한다.
				//따라서 insert의 경우 반환값이 1, update, delete는 몇건이 영향 받았는지 알 수는 없다.. 조건에 따라 틀림
				//그치만 insert, update, delete건 모두 0이면 실패로 간주하면 된다.

				int result = pstmt.executeUpdate(); //DML(insert, update, delete)쿼리 실행시 이 메서드 사용함
				if(result != 1){
					System.out.println("입력 실패");
				}else{
					System.out.println("입력 성공");
				}

			}

		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("지정한 드라이버를 찾을 수 없습니다.");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//db 연동에 사용되었던 모든 객체는 닫아야 한다.
			if(pstmt != null){ //존재할 때만 닫는다.
				try{
					pstmt.close();
				}catch(SQLException e){
					
				}
			}
			if(con != null){ //존재할 때만 닫는다.
				try{
					con.close();
				}catch(SQLException e){
					
				}
			}
		}
	}
}
