/*
�ڹٿ��� �����ͺ��̽��� �����ϴ� ����� ������ JBDC(Java DataBase Connectivity)
��� �ϸ� java.sql ��Ű������ api�� �����ȴ�.
�����ͺ��̽��� ���������� ����
1. DB������ �˸´� ����̹��� �ε� (oracle, mysql, mssql.. ���� jar�� �ʿ���)
2. ����
3. ���ϴ� ���� ����
4. ���� ����(Ư�� ��Ʈ�� �� DB�� ��� �� �ݵ�� ��������..)
*/
package day1105.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class OracleTest{
	public static void main(String[] args){
		Connection con = null; //�޼����� ���������� �ݵ�� �ʱ�ȭ�ؾ���(�������ó�� �ڵ����� ���ִ� �� ����.)
		PreparedStatement pstmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����ϰ��� �ϴ� ����̹� Ŭ������ ���!(Ŭ���� �ε�)
			//���� ������� os�÷����� Ŭ���� �н��� ��ϵǾ� �־�� �Ѵ�..
			System.out.println("����̹� �ε� �����Դϴ�");

			//DB������ url, id, password
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; //������ ��Ģ
			String user = "user1104";
			String password = "user1104";

			//���� �õ� ��, ������ �����Ǹ� Connection�̶�� �������̽��� �ν��Ͻ��� ��ȯ����
			//Connection���� ������ ���� ������ ����ִ�.
			//���� �������δ� Connection ��ü�� null ���η� �Ǵ��Ѵ�.
			con = DriverManager.getConnection(url, user, password); //���� �õ�
			if(con == null){
				System.out.println("���� ����");
			}else{
				System.out.println("���� ����");
				//������ ���������Ƿ�, �������� ������ �� �ִ�.
				//�������� �����ϴ� ��ü�� PreparedStatement �������̽��̴�.
				String sql = "insert into member(member_id, name, age, phone)";
				sql += " values(seq_member.nextval, 'adams', 38, '010')";

				//������ ���� �Ǿ��, �������� ������ �� �����Ƿ�, Connection ��ü�κ��� �ν��Ͻ��� ���� �Ѵ�.
				pstmt = con.prepareStatement(sql); //���� ������ �غ�
				//���� ���� �� �������θ� �Ǵ��ϱ� ���ؼ��� executeUpdate() �޼����� ��ȯ���� �̿��Ѵ�.
				//��ȯ���� int���̸�, ������ ���࿡ ���� �ݿ��� ���ڵ��� ���� ��ȯ�Ѵ�.
				//���� insert�� ��� ��ȯ���� 1, update, delete�� ����� ���� �޾Ҵ��� �� ���� ����.. ���ǿ� ���� Ʋ��
				//��ġ�� insert, update, delete�� ��� 0�̸� ���з� �����ϸ� �ȴ�.

				int result = pstmt.executeUpdate(); //DML(insert, update, delete)���� ����� �� �޼��� �����
				if(result != 1){
					System.out.println("�Է� ����");
				}else{
					System.out.println("�Է� ����");
				}

			}

		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("������ ����̹��� ã�� �� �����ϴ�.");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//db ������ ���Ǿ��� ��� ��ü�� �ݾƾ� �Ѵ�.
			if(pstmt != null){ //������ ���� �ݴ´�.
				try{
					pstmt.close();
				}catch(SQLException e){
					
				}
			}
			if(con != null){ //������ ���� �ݴ´�.
				try{
					con.close();
				}catch(SQLException e){
					
				}
			}
		}
	}
}
