package lesson4.Video14;

public class printTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		static void printAllTankInfo(){
			
			Tank t = new Tank();
			t.color = "������";
			t.crew = 3 ;
			t.maxSpeed = 100;
			
			System.out.println("�� ������� " + t.color + " ����" + ", ������ �� " + t.crew + " �������," +
						" ������������ �������� - " + t.maxSpeed);
			
			Tank t2 = new Tank("c����", 5, 150);
			System.out.println("�� ������� " + t2.color + " ����" + ", ������ �� " + t2.crew + " �������," +
					" ������������ �������� - " + t2.maxSpeed);
		}

}
