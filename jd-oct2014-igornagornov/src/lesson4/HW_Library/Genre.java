package lesson4.HW_Library;

public enum Genre {
	
	�������(0), �����(1), ��������(2), �����������(3), �������(4), ����������(5);

	private int id;
	
	private Genre(int id){
		this.id=id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
			
	}
	
	public Genre genreName(){
		Genre result=null;
		switch (id){
		case 0: result = �������; break;
		case 1: result = �����; break;
		case 2: result = ��������; break;
		case 3: result = �����������; break;
		case 4: result = �������; break;
		case 5: result = ����������; break;
		}
		return result;
	}
	
	
	
	
	
}
