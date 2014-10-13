package lesson4;

public class Video4_GreetingService {

	public static void main(String[] args) {		
		
		if(args.length>0){
			System.out.println("Hello, " + args[0]);	
		}
		else{
			System.out.println("Пожалуйста введите свое имя!");
		}

	}

}
