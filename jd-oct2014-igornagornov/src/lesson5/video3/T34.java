package lesson5.video3;

public class T34 extends Tank{

	public T34(int crew){
		setColor("������");
		setCrew(crew);
		setMaxSpeed(50);	
		
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
		return "T34";
	}
	
}
