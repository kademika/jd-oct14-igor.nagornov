package lesson5.video3;

public class PrintTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		private static void printAllTankInfo(){
			
			Tank t = new Tank();			
			
			System.out.println("�� ������� " + t.getColor() + " ����" + ", ������ �� " + t.getCrew() + " �������," +
						" ������������ �������� - " + t.getMaxSpeed());
			
			BT7 t2 = new BT7(3);
			System.out.println("�� ������� " + t2.getColor() + " ����" + ", ������ �� " + t2.getCrew() + " �������," +
					" ������������ �������� - " + t2.getMaxSpeed());
			
			T34 t3 = new T34(6);
			System.out.println("�� ������� " + t3.getColor() + " ����" + ", ������ �� " + t3.getCrew() + " �������," +
					" ������������ �������� - " + t3.getMaxSpeed());
			
			Tiger t4 = new Tiger(4);
			System.out.println("�� ������� " + t4.getColor() + " ����" + ", ������ �� " + t4.getCrew() + " �������," +
					" ������������ �������� - " + t4.getMaxSpeed() +  ", ������� ������� ����� - " + t4.getArmor());
			
			
		}

}
