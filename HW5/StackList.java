public class StackList<AnyType> {

    // Stack represented by a LinkedList
    private MyLinkedList<AnyType> stack;

    // Instantiating LinkedList
    public StackList() {
	stack = new MyLinkedList<AnyType>();
	stack.doClear();
    }

    // Pushes AnyType x on top of stack
    public void push( AnyType x ) {
	stack.add(x);
    }

    // Pops the top value of stack
    public AnyType pop() {
	AnyType ret = null;
	try {
	    ret = stack.get(stack.size() - 1);
	    stack.remove(stack.size() - 1);
	    return ret;
	} catch (Exception e) {
	    //throw e;
	    //System.out.println(e);
	}
	return ret;
    }

    // Checks to see if stack is empty
    public boolean isEmpty() {
	return stack.isEmpty();
    }

    // toString method
    public String toString() {
	return stack.toString();
    }
}
