package lesson4.HW_Library;

public enum Genre {
	
	ÔİÍÒÀÇÈ(0), ÓÆÀÑÛ(1), ÄÅÒÅÊÒÈÂ(2), ÏĞÈÊËŞ×ÅÍÈß(3), ÈÑÒÎĞÈß(4), ÊÎÌÏÜŞÒÅĞÛ(5);

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
		case 0: result = ÔİÍÒÀÇÈ; break;
		case 1: result = ÓÆÀÑÛ; break;
		case 2: result = ÄÅÒÅÊÒÈÂ; break;
		case 3: result = ÏĞÈÊËŞ×ÅÍÈß; break;
		case 4: result = ÈÑÒÎĞÈß; break;
		case 5: result = ÊÎÌÏÜŞÒÅĞÛ; break;
		}
		return result;
	}
	
	
	
	
	
}
