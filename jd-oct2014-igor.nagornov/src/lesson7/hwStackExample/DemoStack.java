package lesson7.hwStackExample;

public class DemoStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Stack stack = new Stack();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("2");
		stack.push("1");	
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.printStack();		
		System.out.println(stack.peak());
		

	}

}
