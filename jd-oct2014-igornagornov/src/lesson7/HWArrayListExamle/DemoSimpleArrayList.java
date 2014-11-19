package lesson7.HWArrayListExamle;

public class DemoSimpleArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object o1 = new String("3");
		Object o2 = new String("4");

		SimpleArrayList sar = new SimpleArrayList();

		sar.addFirst("1");
		sar.addLast("2");
		sar.addLast(o1);
		sar.addAfter(o1, o2);
		// sar.remove(o1);

		sar.printArrayList();

	}

}
