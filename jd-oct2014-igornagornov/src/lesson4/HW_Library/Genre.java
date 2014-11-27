package lesson4.HW_Library;

public enum Genre {

	FANTASY(0), HORRORS(1), DETECTIVE(2), ADVANTURES(3), HISTORY(4), COMPUTERS(5);

	private int id;

	private Genre(int id) {
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public Genre genreName() {
		Genre result = null;
		switch (id) {
		case 0:
			result = FANTASY;
			break;
		case 1:
			result = HORRORS;
			break;
		case 2:
			result = DETECTIVE;
			break;
		case 3:
			result = ADVANTURES;
			break;
		case 4:
			result = HISTORY;
			break;
		case 5:
			result = COMPUTERS;
			break;
		}
		return result;
	}

}
