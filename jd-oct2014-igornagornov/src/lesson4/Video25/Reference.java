package lesson4.Video25;

public class Reference {
	
	private String name;
	private Reference ref;
	
	public Reference(String name){
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRef(Reference ref) {
		this.ref = ref;
	}
	
	public void printRef(){
		System.out.println(name + " -> " + ref.getName());
	}
	
	

}
