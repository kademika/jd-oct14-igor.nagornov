package lesson6.HWExceptions;

public class ExceptionSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		catcher();
		System.out.println("It's done!"); //ne napechataetsya - viskochit ISException
		
	}

	public static void catcher() {
		try {
			throw new Exception();
		} catch (Exception e) {
			throw new IllegalStateException();
		} finally {
			System.out.println("I want to be executed!"); //vipolnitsya v lyubom sluchae
		}
	}

}
