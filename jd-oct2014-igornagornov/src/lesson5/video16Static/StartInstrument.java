package lesson5.video16Static;

public class StartInstrument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Instrument i1 = new Instrument();
		Instrument i2 = new Instrument();		
		
		System.out.println("���� fabric, ����� ��� ���� �������� ������ - " + Instrument.fabric);
		System.out.println(i1.fabric);
		System.out.println(i2.fabric);
		System.out.println(); 
		
		i2.fabric = "Jackson"; //������ ����������� ���� � ����� �������

		System.out.println("���� fabric, ����� ��� ���� �������� ������ - " + Instrument.fabric);
		System.out.println(i1.fabric); //��������, ��� � ������ ������� ��� ���� ���������, �.�. ����������� ���� �����
		System.out.println(i2.fabric); 			//��� ���� �������� ������ � ����������� � ������ ������, 
													//� �� � ���������� ��������
														

	}

	
	void temp(){
		System.out.println(1);
	}
}
