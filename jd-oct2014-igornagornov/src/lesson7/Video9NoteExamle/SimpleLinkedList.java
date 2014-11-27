package lesson7.Video9NoteExamle;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object> {

	private Note root;
	private int size;
	
	public SimpleLinkedList() {
		// TODO Auto-generated constructor stub
		size = 0;

	}

	private class Note {

		private Object object;
		private Note ref;

	}

	private class SLLIterator implements Iterator<Object> {

		private Note previosNote;
		private Note currentNote;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			boolean result = false;

			if(root==null){
				throw new IllegalStateException("List is Empty! Operation failed");
			}
			
			if ((currentNote == null && root != null) || (currentNote != null && currentNote.ref != null)) {
				result = true;
			}		

			return result;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub

			if (currentNote == null && root != null) {
				currentNote = root;	
				return currentNote.object;
			}

			if (hasNext()) {
				previosNote = currentNote;
				currentNote = currentNote.ref;				
			}
			
			return currentNote.object;

		}
		
		@Override
		public void remove(){
			
			if(!hasNext()&&previosNote==null){
				currentNote = null;
				root=null; //only one element
			}else if(!hasNext()&&previosNote!=null){
				previosNote.ref = null;
				currentNote = null; //last element
			}else if(hasNext()&&previosNote==null){
				root = currentNote.ref;
				currentNote = root; //first element
			}else{
				previosNote.ref = currentNote.ref;
				currentNote = currentNote.ref; //middle element
			}
			
			size--;
		}

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

		if (currentNote == null) {
			throw new IllegalStateException(
					"List is empty, I can't insert object!");
		}

		do {
			if (currentNote.object == prevObject) {
				prevNote = currentNote;
				break;
			}
			currentNote = currentNote.ref;
		} while (currentNote.ref != null);

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

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return new SLLIterator();
	}

}
