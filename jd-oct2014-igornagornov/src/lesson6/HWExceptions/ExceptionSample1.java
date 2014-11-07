package lesson6.HWExceptions;

public class ExceptionSample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		catcher();
		System.out.println("It's done!");
		
	}

	public static void catcher() {
		try {
			return; //dazhe nesmotrya na return vipelnitsya blok finally
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("I want to be executed!");
		}
	}

}
