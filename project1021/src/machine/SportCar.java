class  SportCar{
   String color="None Color";    

   public SportCar(String color){
		this.color=color
   }

	public void setColor(String color){
		this.color=color
	}

	public static void main(String[] args){
		SportCar sc = new SportCar("red");
		setColor("black");
	}
   
}
