package lesson5.video9Upcasting;

public class LaunchVideo9 {
	
	public static void main(String[] args){
		Instrument i = new Instrument();
		Guitar g = new Guitar();
		Musician m = new Musician();
		
		m.play(g);	// ������ upcasting'�, �������� � ��������� ����� ��������� � ������������ ��� ��� ����� ��������	
	}					//�� ���� ����������, ��� � ���������� ����� ������ ������ Instrument, � �� ������ Guitar

}
