//Jason Shin (jjs270)

import java.io.*;
import java.util.*;

public class ExpressionTree
{
    private static class Node {
	
	public void printPostorder()  {
	    printPostorder(this);
	}

	public void printPostorder(Node n) {
	    if (n != null) {
		if (n.left != null)
		    printPostorder(n.left);
		if (n.right != null)
		    printPostorder(n.right);
		System.out.print(n.data);
	    }
	}
	
        public Node(Character d) {
            data = d; left = null; right = null;
        }
        
        public Node(Node l, Character d, Node r) {
            data = d; left = l; right = r;
        }

	// Method that calls compute(Node n) and returns the answer
	public double compute() {
	    compute(this);
	    return nums.pop(); 
	}

	// Nums Stack for computing the sum
	public StackList<Double> nums = new StackList<Double>();

	// Stack operations for computing the sum
	public void compute(Node n) {
	    if (n != null) {
		if (n.left != null) {
		    compute(n.left);
		}
		if (n.right != null) {
		    compute(n.right);
		}
		if (Character.isDigit(n.data)) {
		    nums.push((double)(n.data - '0'));
		}
		if (!Character.isDigit(n.data)) {
		    double result = 0;
		    char operator = n.data;
		    double operand2 = nums.pop();
		    double operand1 = nums.pop();
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
		    nums.push(result);
		}
	    }
	}

	// Stack for parent and children nodes
	public StackList<Node> parents = new StackList<Node>();
	public StackList<Node> children = new StackList<Node>();
	public Node createTree(String str) {
	    for (int i = 0; i < str.length(); i++) {
		char currChar = str.charAt(i);
		if (currChar == ')') {
		    Node operator = parents.pop(); 
		    Node operand2 = children.pop();
		    Node operand1 = children.pop();
		    Node tree = new Node(operand1, operator.data, operand2);
		    children.push(tree);
		}
		else {
		    Node newNode = new Node(currChar);
		    if (Character.isDigit(currChar)) {
			children.push(newNode);
		    }
		    else if (currChar != '(') {
		        parents.push(newNode);
		    }
		}
	    }
	    return children.pop();
	}
	
	public Character data;
        public Node left;
        public Node right;
    }
    
    public static void main(String [] args) {
	Scanner sc = new Scanner(System.in);
	
	// Example of creating an expression tree
	Node operand1 = new Node('4');
	Node operand2 = new Node('5');
	Node tree = new Node(operand1, '-', operand2);
	operand1 = new Node('3');
	tree = new Node(operand1, '*', tree);
	operand2 = new Node('6');
	tree = new Node(tree, '-', operand2);

	// Example of pushing a Node onto a stack of Nodes
	StackList<Node> s = new StackList<>();
	s.push(tree);

	// Example of popping a Node from a stack of Nodes
	operand1 = new Node('2');
	tree = new Node(operand1, '*', s.pop());
	tree.printPostorder();
	// Printing new line
	System.out.println();

	// Evaluating Expression Tree
	System.out.print("Evaluating Expression Tree: ");
	System.out.println(tree.compute());
	Node testTree = new Node('.');
	String infixInput = "";
	while (infixInput == "") {
	    System.out.println("Input a fully parenthesized infix expression");
	    System.out.print("   Enter an expression: ");
	    infixInput = sc.nextLine();
	    testTree = testTree.createTree(infixInput);
	    System.out.println("   Result: " + testTree.compute());
	}
	//testTree = testTree.createTree("(((2*(3+4))-5)/3)");
	//System.out.println(testTree.compute());
    }
}
