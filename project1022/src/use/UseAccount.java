package use;
//사용하려는 클래스의 위치 명시
import bank.Account; //bank 이전의 경로는 이미 classpath에 등록되어있음
class UseAccount{
	public static void main(String[] args) {
		Account acc = new Account(); //계좌 클래스 생성
		//bank 은행명은 public으로 선언되어 있으므로, 무조건 접근이 가능
		System.out.println(acc.bank);

		//customer는 protected로 선언되어 있으므로 상속관계에 있거나, 같은 패키지 경우에만 접근이 가능
		//현재 UseAccount는 Account와 상속관계가 없고
		//서로 다른 패키지이므로, 데이터 접근이 불가능함
		//System.out.println(acc.customer);

		//계좌번소 num변수는, 개발자가 아무것도 명시하지 않았는데요, 이러한 접근제한자를 default 접근제한자라하고,
		//default라는 키워드를 명시해서는 안된다. 그냥 냅둬야함
		//default 접근 제한자는 같은 패키지에 있는 클래스끼리만 접근을 허용해주므로, protected보다
		//한단계 더 까다롭다.(즉 상속관계에 있어도, 같은 패키지가 아니라면 접근 불가임)
		//System.out.println(acc.num);
		//"공개되어 있지 않으므로 외부에서 접근이 불가합니다."라는 메시지가 나옴
		//지금까지 실습했던 모든 클래스가 사실default였고, 우리는 같은 디렉토리에서
		//실습을 해왔기 때문에 지금까지 이런 에러를 만나지 않았던 것뿐... 이제 패키지를 사용하기
		//때문에 접근제한자를 조금 알아야함
		
		//계좌 잔액 balance를 테스트해본다.
		//balance는 가장 강력한 접근제한자인 private이 적용되어 있으므로, Account 클래스 스스로
		//만 접근이 가능하다. 따라서 우리는 Account 자신이 아니라서, 절대절대 사용 못함
		//완전 폐쇠적이다.
		//System.out.println(acc.balance);
		//balance has private access in Account(private 접근제한자가 적용되어 있다는 의미)

		//잔고 세팅
		acc.setBalance(10);

		//잔고 확인
		System.out.println(acc.getBalance());
	}
}
