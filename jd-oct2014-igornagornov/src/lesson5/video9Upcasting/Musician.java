package lesson5.video9Upcasting;

public class Musician {
	
	public void play(Instrument i){
		
		i.sound();	//
		if(i instanceof Guitar){ //��������� �������� �� ��������� �������
			Guitar g = (Guitar)i; //������� ������� i ������ Instrument � ������ Guitar
			g.testMessage(); //���� ������� �� �������, �� ����� testMessage �� ����� ��������, ������ ��� 
		}									//� ������ Instrument ��� ������ ������
			
	}

}
