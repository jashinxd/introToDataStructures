public class Driver {

    // Checks to see if parenthesis are balanced.
    public static String checkParens(String str) {
	StackList<String> stack = new StackList<String>();
	for (int i = 0; i < str.length(); i++) {
	    switch (str.charAt(i)) {
	    case '(':
		stack.push("(");
		break;
	    case ')':
		if (stack.isEmpty()) {
		    return "Parenthesis are NOT balanced";
		}
		stack.pop();
		break;
	    }
	}
        if (stack.isEmpty()) {
	    return "Parenthesis are balanced";
	} else {
	    return "Parenthesis are NOT balanced";
	}
    }

    // Solves infix expression. Only works with single digits.
    public static String calcInfix(String str) {
	StackList<Double> nums = new StackList<Double>();
	StackList<Character> ops = new StackList<Character>();
	for (int i = 0; i < str.length(); i++) {
	    //System.out.println(nums);
	    char currChar = str.charAt(i);
	    if (currChar == ')') {
		char operator = ops.pop();
		double operand2 = nums.pop();
		double operand1 = nums.pop();
		double result = 0;
		switch (operator) {
		case '+': result = operand1 + operand2;
		    break;
		case '-': result = operand1 - operand2;
		    break;
		case '*': result = operand1 * operand2;
		    break;
		case '/': result = operand1 / operand2;
		    break;
		}
		//System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
		nums.push(result);
	    } else if (Character.isDigit(currChar)) {
		nums.push((double)currChar - '0');
	    } else if (currChar != '(') {
		ops.push(currChar);
	    }
	}
	return "Result = " + nums.pop();
    }

    // Solves postfix expression. Only works with single digits. 
    public static String calcPostfix(String str) {
	StackList<Character> stack = new StackList<Character>();
	for (int i = 0; i < str.length(); i++) {
	    //System.out.println(stack);
	    char currChar = str.charAt(i);
	    if (Character.isDigit(currChar)) {
		stack.push(currChar);
	    } else {
		char operator = currChar;
		double operand2 = stack.pop() - '0';
		double operand1 = stack.pop() - '0';
		double result = 0;
		switch (operator) {
		case '+': result = operand1 + operand2;
		    break;
		case '-': result = operand1 - operand2;
		    break;
		case '*': result = operand1 * operand2;
		    break;
		case '/': result = operand1 / operand2;
		    break;
		}
		//System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
		stack.push((char)(result + '0'));
	    }
	}
	return "Result = " + ((double)stack.pop() - '0');
    }

    //Main method. Executes test cases.
    public static void main( String[] args ) {	
	System.out.println(checkParens("(2*(3+4)-5)/6") + ": should be true");
	System.out.println(checkParens("(2*(3+4-5)/6") + ": should be false");
	System.out.println(checkParens("2*(3+4)-5)/6") + ": should be false");
	System.out.println(checkParens(")()()()(") + ": should be false");
	System.out.println(calcPostfix("23+4*"));
	System.out.println(calcPostfix("6523+8*+3+*"));
	System.out.println(calcPostfix("328+*50+-"));
	System.out.println(calcInfix("(((1+2)+3)+4)"));
	System.out.println(calcInfix("(((2*(3+4))-5)/3)"));
    }
    
}
