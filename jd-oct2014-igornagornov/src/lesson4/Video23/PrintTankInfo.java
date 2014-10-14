package lesson4.Video23;

import lesson4.Video14.Tank;

public class PrintTankInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tank[] t = new Tank[3];
		t[0] = new Tank();
		t[1] = new Tank("������", 4, 250);
		t[2] = new Tank("�������", 3 ,200);		
		
		printTankInfo(t);
	}
	
	static void printTankInfo(Tank tank[]){
		
		if(tank==null){
			System.out.println("������ ������ ����");
		}
		else{
		
			for(Tank value: tank){
				if(value!=null){
					System.out.println(value.getColor());
					System.out.println(value.getCrew());
					System.out.println(value.getMaxSpeed());	
				}
				else {
					System.out.println("���������� �� ����� ����� �� ���������");
				}
				System.out.println();						
			}
			
		}		
		
	}

}
