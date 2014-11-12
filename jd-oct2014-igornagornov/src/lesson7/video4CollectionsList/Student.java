package lesson7.video4CollectionsList;

public class Student {
	
	private String name;
	private String secondName;	
	
	public Student(String name, String  secondName) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.secondName = secondName;		
	}
	
	public String getName() {
		return name;
	}
	public String getSecondName() {
		return secondName;
	}
	
	
	public boolean equals(Object object){
		
		if(object instanceof Student){
			
			Student student = (Student)object;
			if((name!=null&&name.equals(student.getName()))&&(secondName!=null&&secondName.equals(secondName))){
				return true;
			}
		}	
		
		return false;		
	}

}
