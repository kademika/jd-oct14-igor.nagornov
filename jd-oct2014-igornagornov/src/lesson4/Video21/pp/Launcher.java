package lesson4.Video21.pp;

import lesson4.Video21.Private;
import lesson4.Video21.Public;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Private p = new Private(); // �� ����� ������������ ���� s �� ������, ��� ��� ��� �������� ������ ������ ������
				
		Public pu = new Public(); // ����� ������������ ������ public ���� color, ���� style ����������, �.�. �� � ������ ������
		pu.color = "blue";
		
		PackageOnly po = new PackageOnly();
		po.color = "red"; // ���� color ��������, �.� �� � ���� �� ������
		

	}

}
