import java.util.*;
import java.io.*;
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
	} try {
	    return "Result = " + ((double)stack.pop() - '0');
	}
	catch (Exception e) {
	    return "Invalid Input";
	}
    }

    //Main method. Executes test cases.
    public static void main( String[] args ) {
	Scanner sc = new Scanner(System.in);
	String parensInput = "";
	String infixInput = "";
	String postfixInput = "";
	while (parensInput == "") {
	    System.out.println("1. Check to see if an expression has correctly balanced parenthesis.");
	    System.out.print("   Enter Expression: ");
	    parensInput = sc.nextLine();
	    System.out.println("   " + checkParens(parensInput));     
	}
	while (infixInput == "") {
	    System.out.println("2. Solves an infix notation.");
	    System.out.print("   Enter Expression: ");
	    infixInput = sc.nextLine();
	    System.out.println("   " + calcInfix(infixInput));
	}
	while (postfixInput == "") {
	    System.out.println("3. Solves an postfix notation.");
	    System.out.print("   Enter Expression: ");
	    postfixInput = sc.nextLine();
	    System.out.println("   " + calcPostfix(postfixInput));
	}
	System.out.println("\nTest cases:");
	System.out.println("Check Balanced Parenthesis");
	System.out.print("1. Input: (2*(3+4)-5)/6\t");
	System.out.print(checkParens("(2*(3+4)-5)/6") + "\n");
	System.out.print("2. Input: (2*(3+4-5)/6\t");
	System.out.print(checkParens("(2*(3+4-5)/6") + "\n");
	System.out.print("3. Input: 2*(3+4)-5)/6\t");
	System.out.print(checkParens("2*(3+4)-5)/6") + "\n");
	System.out.print("4. Input: )()()()(\t");
	System.out.print(checkParens(")()()()(") + "\n");
	
	System.out.println("Infix Notation: ");
	System.out.print("1. Input: (((1+2)+3)+4) \t");
	System.out.print(calcInfix("(((1+2)+3)+4)") + "\n");
	System.out.print("2. Input: (((2*(3+4))-5)/3) \t");
	System.out.print(calcInfix("(((2*(3+4))-5)/3)") + "\n");

	System.out.println("Postfix Notation: ");
	System.out.print("1. Input: 23+4* \t");
	System.out.print(calcPostfix("23+4*") + "\n");
	System.out.print("2. Input: 6523+8*+3+* \t");
	System.out.print(calcPostfix("6523+8*+3+*") + "\n");
	//System.out.println(calcPostfix("328+*50+-"));
    }
    
}
