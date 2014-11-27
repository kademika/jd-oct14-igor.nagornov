package lesson7.hwStackExample;

public class Stack {

	private Note root;
	private Note last;
	private int size;

	public Stack() {
		// TODO Auto-generated constructor stub
		size = 0;

	}

	private class Note {

		private Object object;
		private Note ref;

	}

	public void push(Object object) {

		Note last = new Note();
		last.object = object;

		if (root == null || last == null) {
			root = last;
			this.last = last;
		} else {
			Note currentNote = root;
			Note nextNote = currentNote.ref;

			while (currentNote.ref != null) {
				currentNote = nextNote;
				nextNote = nextNote.ref;
			}
			currentNote.ref = last;
			this.last = last;
		}
		size++;

	}

	public Object peak() {

		if (root == null || last == null) {
			throw new IllegalStateException(
					"There is no objects in stack! Operation failed");
		}

		Object returnObject;
		returnObject = last.object;

		return returnObject;
	}

	public Object pop() {

		if (root == null || last == null) {
			throw new IllegalStateException(
					"There is no objects in stack! Operation failed");
		}

		Object returnObject;
		returnObject = last.object;

		Note currentNote = root;
		if(root.ref!=null){
			Note nextNote = currentNote.ref;

			while (nextNote.ref != null) {
				currentNote = nextNote;
				nextNote = nextNote.ref;
			}
			last = currentNote;
			last.ref = null;
		}else{
			root=null;
			last=null;
		}
		
		size--;

		return returnObject;
	}

	public void printStack() {

		if (size == 0) {
			System.out.println("Stack is empty");
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

	public Note getLast() {
		return last;
	}

	public int getSize() {
		return size;
	}

	// private Object[] object;
	//
	// public void push(Object addedObject) {
	//
	// Object[] tempArray;
	//
	// if (object == null) {
	// object = new Object[1];
	// object[0] = addedObject;
	// return;
	// }
	//
	// tempArray = new Object[object.length + 1];
	//
	// tempArray[tempArray.length - 1] = addedObject;
	// for (int i = 0; i < object.length; i++) {
	// tempArray[i] = object[i];
	// }
	//
	// object = tempArray;
	//
	// }
	//
	// public Object pop() {
	//
	// Object[] tempArray;
	// Object returnObject;
	//
	// if (object == null||object.length==0) {
	// throw new IllegalArgumentException(
	// "There is no elements in Stack! Nothing could be poped!");
	// }
	//
	// tempArray = new Object[object.length - 1];
	//
	// for (int i = 0; i < object.length - 1; i++) {
	// tempArray[i] = object[i];
	// }
	//
	// returnObject = object[object.length - 1];
	// object[object.length - 1] = null;
	//
	// object = tempArray;
	//
	// return returnObject;
	//
	// }
	//
	// public Object peak(){
	//
	// if (object == null||object.length==0) {
	// throw new IllegalArgumentException(
	// "There is no elements in Stack");
	// }
	//
	// return object[object.length - 1];
	// }
	//
	// public Object[] getObject() {
	// return object;
	// }
	//
	// public void printStack() {
	// System.out.print("[");
	// for (int i = 0; i < object.length; i++) {
	//
	// if (i == object.length - 1) {
	// System.out.print(object[i]);
	// } else {
	// System.out.print(object[i] + ", ");
	// }
	//
	// }
	// System.out.println("]");
	// }

}
