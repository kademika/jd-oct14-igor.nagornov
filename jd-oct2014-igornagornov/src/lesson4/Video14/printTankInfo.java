package lesson4.Video14;

import java.io.ObjectInputStream.GetField;

public class printTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		static void printAllTankInfo(){
			
			Tank t = new Tank();			
			
			System.out.println("�� ������� " + t.getColor() + " ����" + ", ������ �� " + t.getCrew() + " �������," +
						" ������������ �������� - " + t.getMaxSpeed());
			
			Tank t2 = new Tank("c����", 5, 250);
			System.out.println("�� ������� " + t2.getColor() + " ����" + ", ������ �� " + t2.getCrew() + " �������," +
					" ������������ �������� - " + t2.getMaxSpeed());
		}

}
