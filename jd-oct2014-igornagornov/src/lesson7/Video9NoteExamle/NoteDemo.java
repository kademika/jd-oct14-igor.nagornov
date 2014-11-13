package lesson7.Video9NoteExamle;

import java.util.Iterator;

public class NoteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleLinkedList sll = new SimpleLinkedList();

		System.out.println("Testing SimpleLinkList\n");

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

//		 sll = new SimpleLinkedList();
//		 sll.addLast(last1);
//		 sll.addAfter(last2, last1);
//		 System.out.print(sll.getSize() + " ");
//		 sll.printList();

//		System.out.println();
//		System.out.println("Testing SimpleLinkListIterator");
//		for (Object tempObject : sll) {
//			String s = (String) tempObject;
//			System.out.print(s + " ");
//		}
//
//		System.out.println();
//		for (Iterator<Object> iterator = sll.iterator(); iterator.hasNext();) {
//			Object obj = iterator.next();
//			System.out.print((String) obj + " ");
//		}

		for (Iterator<Object> iterator = sll.iterator(); iterator.hasNext();) {
			iterator.next();
			iterator.next();
			iterator.remove();
			break;
			// System.out.print((String) obj + " ");
		}

		System.out.print(sll.getSize() + " ");
		sll.printList();

	}

}
