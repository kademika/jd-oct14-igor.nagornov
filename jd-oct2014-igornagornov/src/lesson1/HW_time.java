package lesson1;

public class HW_time {

	public static void main(String[] args) {
		long ms=1000, sec=60, min=60, hours=24;
		long t = System.currentTimeMillis();		
		System.out.println(t + " ����������� ������ � 1 ������ 1970 ����");
		
		System.out.println(t/(ms*sec*min*hours) + " ���� " + ":" 
				+ (t/(ms*sec*min))%hours + " ����� " + ":" 
					+ (t/(ms*sec))%min + " ����� " + ":" 
						+ (t/(ms)%sec) + " ������ ������ � 1 ������ 1970 ����");
		
		/*
		System.out.println(t%ms);
		t/=ms;
		System.out.println(t%sec);
		t/=sec;
		System.out.println(t%min);
		t/=min;
		System.out.println(t%hours);
		t/=hours;
		System.out.println(t);
		
		*/
		
	}

}