package lesson6.Video6Exceptions;

public class TryBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			doThisForMe();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Do something with e");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 				//print exception to console
		} finally{
			System.out.println("Always print!"); //Finally is always perform
		}
		
	}

	public static void doThisForMe() throws InterruptedException{
		Thread.sleep(1000);
	}
}
