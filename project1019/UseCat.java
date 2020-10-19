class  UseCat{
	public static void main(String[] args) {
		Cat c=new Cat; // 고양이 인스턴스 1개 생성
		System.out.println("고양이의 이름 : "+c.name);
		System.out.println("고양이의 나이 : "+c.age);
		System.out.println("고양이의 결혼여부 : "+c.married);
		c.walk();
		c.miu();
	}
}
