package lesson5.video3;

public class BT7 extends Tank{
	
	public BT7(int crew){
		setColor("�����");
		setCrew(crew);
		setMaxSpeed(72);	
		
		System.out.println("�� ������� " + getColor() + " ����" + ", ������ �� " + getCrew() + " �������," +
				" ������������ �������� - " + getMaxSpeed());
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("������� ���� " + this.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BT7";
	}
}
