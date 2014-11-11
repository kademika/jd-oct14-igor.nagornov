package lesson7.video4CollectionsList;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassRoom c = new ClassRoom();
		Student s1 = new Student("Igor", "Nagornov");
		c.enter(s1);
		Student s2 = new Student("Petr", "Ivanov");
		c.enter(s2);
		Student s3 = new Student("Ivan", "Ivanov");
		c.enter(s3);
		Student s4 = new Student("Sergey", "Petrov");
		c.enter(s4);
		Student s5 = new Student("Petr", "Sergeev");
		c.enter(s5);
		Student s6 = new Student("Mihail", "Lomonosov");
		c.enter(s6);
		c.leave(s6);
		
		c.isPresent("Ivan", "Ivanov");	
		c.isPresent("Mihail", "Lomonosov");	
		System.out.println();
		c.printStudents();
		
		
	}

}
