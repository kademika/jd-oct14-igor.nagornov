package lesson4.Video21.pp;

import lesson4.Video21.Private;
import lesson4.Video21.Public;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Private p = new Private(); // не можем использовать поле s из класса, так как оно доступно только внутри класса
				
		Public pu = new Public(); // можем использовать только public поле color, поле style недоступно, т.к. мы в другом пакете
		pu.color = "blue";
		
		PackageOnly po = new PackageOnly();
		po.color = "red"; // поле color доступно, т.к мы в этом же пакете
		

	}

}
