package lesson7.HWArrayListExamle;

public class DemoSimpleArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object o1 = new String("3");
		Object o2 = new String("4");

		SimpleArrayList simpleArrayList = new SimpleArrayList();

		simpleArrayList.addFirst("1");
		simpleArrayList.addLast("2");		
		simpleArrayList.addLast(o1);		
		simpleArrayList.addAfter(o1, o2);		
		
		simpleArrayList.remove(o1);		
		simpleArrayList.getByPosition(2);

		simpleArrayList.printArrayList();		

	}

}
