package bank;
//고객의 계좌를 정의한다. : 업무가 신중해짐.. 예민한 데이터를 많이 다룸
//패키지에 넣은 클래스를 public으로 공개하지 않으면, 다른 어떠한 클래스도 이
//클래스를 사용할 수 없습니다. 이건 보안이 아니라, 그냥 의미없는 짓입니다.
//클래스는 쓰라고 만드는 것이기 때문에 public으로 공개하되, 그 안의 내용들에 대해
//보안처리 하면 되는거에요
//따라서 public으로 공개
public class Account{
	//계좌에 들어갈 속성들 정의
	public String bank="기업은행";//은행명
	protected String customer;//고객이름
	String num="022-333-85465";//계좌번호
	private int balance=100000;//금액 진짜 중요한 변수

	//private으로 선언된 변수는 절대 아무도 외부에서 접근할 수 없으므로
	//변수에 접근하려면, 메서드를 이용해야 한다.
	//현재 Account 클래스 소스로만 접근할 수 있어요.
	//따라서 멤버 메서드를 제공
	public void setBalance(int balance){
		this.balance=balance;
	}

	//잔고 확인 메서드 정의
	//이와 같이 private으로 선언된 변수의 값을 리턴하는 메서드를 가리켜 getter라 한다.
	//그리고 위와같이 setBalance처럼 private 변수의 갑을 변경하는 메서드를 가리켜 setter라 한다.
	//게터와 세터는 아주아주 유명한 메서드
	public int getBalance(){
		return balance;
	}
	
}
