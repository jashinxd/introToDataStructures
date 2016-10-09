//Jason Shin (jjs270)

// BinarySearchTree2 class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printInorder( )      --> Print tree in sorted order
// NEW METHODS:
// void printPostorder()  --> Print tree in postorder
// void printPreorder()   --> Print tree in preorder
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree2<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BinarySearchTree2( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
	//        if( isEmpty( ) )
	//            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
	//        if( isEmpty( ) )
	//            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printInorder( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printInorder( root );
    }

    /** NEW METHOD
     * Print the tree contents in postorder.
     */
    public void printPostorder() {
	if (isEmpty()) {
	    System.out.println("Empty Tree");
	}
	else {
	    printPostorder(root);
	    System.out.println("");
	}
    }

    /** NEW METHOD
     * Print the tree contents in postorder.
     */
    public void printPreorder() {
	if (isEmpty()) {
	    System.out.println("Empty Tree");
	}
	else {
	    printPreorder(root);
	    System.out.println("");
	}
    }
    
    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
	    {
		t.element = findMin( t.right ).element;
		t.right = remove( t.element, t.right );
	    }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printInorder( BinaryNode<AnyType> t )
    {
        if( t != null )
	    {
		printInorder( t.left );
		System.out.print( t.element );
		System.out.print(" ");
		printInorder( t.right );
	    }
    }

    /** NEW METHOD
     * Internal method to print a subtree in postorder
     * @param t the node that roots the subtree
     */
    private void printPostorder(BinaryNode<AnyType> t) {
	if (t != null) {
	    printPostorder(t.left);
	    printPostorder(t.right);
	    System.out.print(t.element);
	    System.out.print(" ");
	}
    }

    /** NEW METHOD
     * Internal method to print a subtree in postorder
     * @param t the node that roots the subtree
     */
    private void printPreorder(BinaryNode<AnyType> t) {
	if (t != null) {
	    System.out.print(t.element);
	    System.out.print(" ");
	    printPreorder(t.left);
	    printPreorder(t.right);
	}
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
	// Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


    /** The tree root. */
    private BinaryNode<AnyType> root;


    // Test program
    public static void main( String [ ] args )
    {
	//int[] x = {5, 2, 8, 1, 3, 9, 7, 4, 6};
	int[] x = {9, 3, 2, 1, 6, 7, 5, 4, 8};
	BinarySearchTree2<Integer> t = new BinarySearchTree2<>( );
        for(int i = 0; i < x.length; i++)
            t.insert(x[i]);
	System.out.println("Print inorder: ");
	t.printInorder();
	System.out.println();
	System.out.println("Print preorder: ");
	t.printPreorder();
	System.out.println("Print postorder: ");
	t.printPostorder();
    }
}
