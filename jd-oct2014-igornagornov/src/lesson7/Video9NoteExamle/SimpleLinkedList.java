package lesson7.Video9NoteExamle;

public class SimpleLinkedList {

	private Note root;
	private int size;

	private class Note {

		private Object object;
		private Note ref;

	}

	public SimpleLinkedList() {
		// TODO Auto-generated constructor stub
		size = 0;
	}

	public void addFirst(Object object) {

		Note first = new Note();
		first.object = object;

		if (root != null) {
			first.ref = root;
		}

		root = first;
		size++;

	}

	public void addLast(Object object) {

		Note last = new Note();
		last.object = object;

		if (root == null) {
			root = last;
		} else {
			Note currentNote = root;
			Note nextNote = currentNote.ref;

			while (currentNote.ref != null) {
				currentNote = nextNote;
				nextNote = nextNote.ref;
			}
			currentNote.ref = last;
		}
		size++;

	}

	public void addAfter(Object addedObject, Object prevObject) {

		Note prevNote = null;
		Note currentNote = root;

		if (currentNote == null){
			return;
		}			

		do {
			if (currentNote.object == prevObject) {
				prevNote = currentNote;
				break;
			}
			currentNote = currentNote.ref;
		} while (currentNote != null && currentNote.ref != null);

		if (prevNote == null) {
			throw new IllegalStateException("List doesn't contain this object!");
		}

		Note insertObject = new Note();
		insertObject.object = addedObject;

		if (prevNote.ref != null) {
			insertObject.ref = prevNote.ref;
		}
		prevNote.ref = insertObject;

		size++;

	}

	public void printList() {

		if (size == 0) {
			System.out.println("List is empty");
			return;
		}

		System.out.print("[");

		Note currentNote = root;
		while (currentNote.ref != null) {
			System.out.print(currentNote.object + ", ");
			currentNote = currentNote.ref;
		}

		System.out.print(currentNote.object);
		System.out.println("]");

	}

	public Note getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}

}
