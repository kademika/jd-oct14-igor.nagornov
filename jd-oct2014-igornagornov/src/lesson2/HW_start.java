package lesson2;

public class HW_start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start(2);
		start(-3);		
		start(0);
		start(10);
	}

	static void start(int number)
	{
		if(number>=0){
			while(number>=0)
			{
				System.out.println(number);
				number--;
			}
			System.out.println("GO!");
		}
		else System.out.println("This nimber is less than zero");
		
	}
}
	

