package lesson2;

public class video23_isSpring {

	static int isSpring(int month){
		
		if(month>=3&&month<6) 
			{
			 System.out.println("ћес€ц " + month + " весенний");
			 return 1;
			}
		else if (month>=1&&month<3||month>=6&&month<=12) 
		{
			System.out.println("ћес€ц " + month + " невесенний");
			return 0;
		}
		System.out.println(month + " неверное значение мес€ца");
		return -1;
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isSpring(6);
		isSpring(3);
		isSpring(4);
		isSpring(10);
		isSpring(-20);
		isSpring(13);
		isSpring(25);
	}
	
}
