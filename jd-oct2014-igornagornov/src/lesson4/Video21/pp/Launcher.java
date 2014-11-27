package lesson4.Video21.pp;

import lesson4.Video21.Private;
import lesson4.Video21.Public;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Private p = new Private(); // ne mozhem ispolzovat' pole s iz klassa, t.k ono dostupno tolko iz etogo klassa
				
		Public pu = new Public(); // pole style nedostupno - mi v drugom pakete
		pu.color = "blue";
		
		PackageOnly po = new PackageOnly();
		po.color = "red"; // pole color dostupno - mi v etom zhe pakete
		

	}

}
