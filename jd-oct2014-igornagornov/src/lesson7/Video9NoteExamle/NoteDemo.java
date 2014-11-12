package lesson7.Video9NoteExamle;

public class NoteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleLinkedList sll = new SimpleLinkedList();

		sll.addFirst("1");
		sll.addFirst("2");
		sll.addFirst("3");
		System.out.print(sll.getSize() + " ");
		sll.printList();

		String last1 = new String("0");
		sll.addLast(last1);
		sll.addLast("7");
		sll.addLast("8");
		sll.addLast("9");
		System.out.print(sll.getSize() + " ");
		sll.printList();

		String last2 = new String("6");
		sll.addAfter(last2, last1);
		System.out.print(sll.getSize() + " ");
		sll.printList();

		sll = new SimpleLinkedList();
		sll.addLast(last1);
		sll.addAfter(last2, last1);
		System.out.print(sll.getSize() + " ");
		sll.printList();

	}

}
