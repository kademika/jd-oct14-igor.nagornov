package lesson7.video4CollectionsList;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	List<Student> students = new ArrayList<>();

	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}

	public void enter(Student s) {

		students.add(s);
	}

	public void leave(Student s) {

		students.remove(s);
	}

	public int getStudentCount() {

		return students.size();
	}

	public void isPresent(String name, String secondName) {

		for (Student studentTemp : students) {

			if (name != null && secondName != null) {
				if (studentTemp.getName().equals(name)
						&& studentTemp.getSecondName().equals(secondName)) {
					System.out
							.println("I'm searching student by entered name... "
									+ studentTemp.getName()
									+ " "
									+ studentTemp.getSecondName()
									+ " is present");
					return;
				}
			}
		}

		System.out.println("This student is not present!");
	}

	public void isPresent(Student student) {	
		
		if(students.contains(student)){
			System.out.println("I'm searching student by entered name... "
					+ student.getName()
					+ " "
					+ student.getSecondName()
					+ " is present");
		}
		else{
			System.out.println("This student is not present!");
		}
		
	}

	public void printStudents() {

		for (Student studentTemp : students) {
			System.out.println(studentTemp.getName() + " "
					+ studentTemp.getSecondName());

		}

		System.out.println(getStudentCount() + " are present now");
	}

	public List<Student> getListOfStudents() {

		return new ArrayList<>(students); // shallow copy(return copy of
											// students),
											// don't return students reference

	}

}
