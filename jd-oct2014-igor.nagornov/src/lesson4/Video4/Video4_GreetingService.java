package lesson4.Video4;

public class Video4_GreetingService {

	public static void main(String[] args) {		
		
		if(args.length>0){
			System.out.println("Hello, " + args[0]);	
		}
		else{
			System.out.println("Please enter your name!");
		}

	}

}
