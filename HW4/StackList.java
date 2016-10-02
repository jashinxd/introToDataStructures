public class StackList<AnyType> {

    private MyLinkedList<AnyType> stack;
    
    public StackList() {
	stack = new MyLinkedList<AnyType>();
	stack.doClear();
    }
    
    public void push( AnyType x ) {
	stack.add(x);
    }
    
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

    public boolean isEmpty() {
	return stack.isEmpty();
    }

    public String toString() {
	return stack.toString();
    }
}
