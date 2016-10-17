// MaxHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//               or an array containing initial items
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMax( )--> Return and remove largest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class MaxHeap<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the binary heap.
     */
    public MaxHeap( )
    {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public MaxHeap( int capacity )
    {
        currentSize = 0;
        array = (AnyType[]) new Comparable[ capacity + 1 ];
    }
    
    /**
     * Construct the binary heap given an array of items.
     */
    public MaxHeap( AnyType [ ] items )
    {
            currentSize = items.length;
            array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( AnyType item : items )
                array[ i++ ] = item;
            buildHeap( );
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

            // Percolate up
        int hole = ++currentSize;
        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) > 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
    }


    private void enlargeArray( int newSize )
    {
            AnyType [] old = array;
            array = (AnyType []) new Comparable[ newSize ];
            for( int i = 0; i < old.length; i++ )
                array[ i ] = old[ i ];        
    }
    
    /**
     * Find the largest item in the priority queue.
     * @return the largest item, or throw an UnderflowException if empty.
     */
    public AnyType findMax( )
    {
//        if( isEmpty( ) )
//            throw new UnderflowException( );
        return array[ 1 ];
    }

    /**
     * Remove the largest item from the priority queue.
     * @return the largest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMax( )
    {
 //       if( isEmpty( ) )
 //           throw new UnderflowException( );

        AnyType maxItem = findMax( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return maxItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }

    /**
     * Prints all of the heap values in order by array index in
     * a single row.
     */
    public void printHeapArray() {
	System.out.println("Array:");
	System.out.print("[");
	for (int i = 1; i <= currentSize; i++) {
	    System.out.print(array[i]);
	    if (i != currentSize) {
		System.out.print(", ");
	    }
	}
	System.out.print("]\n");
    }
    
    /**
     * Prints each row of the maxHeap on separate lines.
     */
    public void printHeap() {
	System.out.println("Tree:");
	int nextLine = 1;
	int i;
	for (i = 1; i <= currentSize; i++) {
	    System.out.print(array[i] + " ");
	    if (i == nextLine && nextLine != currentSize) {
		System.out.print("\n");
		nextLine += (nextLine + 1);
	    }
	}
	System.out.print("\n");	
    }
    
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private AnyType [ ] array; // The heap array

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        AnyType tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    array[ child + 1 ].compareTo( array[ child ] ) > 0 )
                child++;
            if( array[ child ].compareTo( tmp ) > 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }

        // Test program
    public static void main( String [ ] args )
    {
	MaxHeap<Integer> h1 = new MaxHeap<>();
	int[] arr = {9,3,2,1,6,7,5,4,8};
	for (int i = 0; i < arr.length; i++) {
	    h1.insert(arr[i]);
	}
	System.out.println("Printing both array and tree");
	h1.printHeapArray();
	h1.printHeap();
	System.out.println();
	System.out.println("Deleting Max 3 times");
	for (int i = 0; i < 3; i++) {
	    h1.deleteMax();
	    System.out.println("Deletion #" + (i+1) + ":");
	    h1.printHeapArray();
	    h1.printHeap();
	}
	/*
        int numItems = 10000;
        MaxHeap<Integer> h = new MaxHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMax( ) != i )
                System.out.println( "Oops! " + i );
	*/
    }
}
