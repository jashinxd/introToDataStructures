//Jason Shin (jjs270)
public class DriverLinkedList {

    //Adds ints from 1 to N to end of lnkLst
    private static void addNToEnd(MyLinkedList<Integer> lnkLst, int times) {
	for (int i = 0; i < times; i++) {
	    lnkLst.add(i);
	}
    }

    //Adds ints from 1 to N to beginning of lnkLst
    private static void addNToBegin(MyLinkedList<Integer> lnkLst, int times) {
	for (int i = 0; i < times; i++) {
	    lnkLst.add(0, i);
	}
    }

    //Removes value from end of data without an iterator until empty.
    private static void rmEndNoIter(MyLinkedList<Integer> lnkLst, int times) {
	for (int i = times - 1; i >= 0; i--) {
	    lnkLst.remove(i);
	}
    }

    //Removes value from beginning of data without an iterator until empty.
    private static void rmBeginNoIter(MyLinkedList<Integer> lnkLst, int times) {
	for (int i = 0; i < times; i++) {
	    lnkLst.remove(i);
	}
    }

    //Removes value from beginning of data without an iterator until empty.
    private static void rmBeginWithIter(MyLinkedList<Integer> lnkLst, int times, java.util.Iterator<Integer> itr) {
	while (itr.hasNext()) {
	    itr.next();
	    itr.remove();
	}
    }

    //Summation of all elements
    private static int summation(MyLinkedList<Integer> lnkLst, int times, int sum) {	
	for (int i = 0; i < times; i++) {
	    sum += lnkLst.get(i);
	}
	return sum;
    }

    //Adding 0 to end N times
    private static void add0ToEndNTimes(MyLinkedList<Integer>lnkLst, int times) {
	for (int i = 0; i < times; i++) {
	    lnkLst.add(0);
	}
    }
    
    //Main method
    public static void main(String[] args) {
        long startTime, stopTime;
	MyLinkedList<Integer> lnkLst = new MyLinkedList<Integer>();
	int N = 100000;

	//Tests for MyLinkedList
	System.out.println("MyLinkedList...");
	
	//1a. Adding values to end of data structure
	startTime = System.currentTimeMillis();
	addNToEnd(lnkLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Add to end: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	lnkLst.doClear();
	
	//1b. Adding values to beginning of data structure
	startTime = System.currentTimeMillis();
	addNToBegin(lnkLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Add to beginning: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	lnkLst.doClear();
	
	//1c. Adding then removing from end without an iterator
	//Filling list before removing
	addNToEnd(lnkLst, N);
	startTime = System.currentTimeMillis();
	rmEndNoIter(lnkLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Remove from end: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(lnkLst.isEmpty());
	lnkLst.doClear();

	//1d. Adding then removing from beginning without an iterator
	//Filling list before removing
	addNToEnd(lnkLst, N);
	System.out.println(lnkLst.size());
	startTime = System.currentTimeMillis();
	rmBeginNoIter(lnkLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Remove from beginning: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(lnkLst.isEmpty());
	lnkLst.doClear();

	//1e. Adding then removing from beginning with an iterator
	//Filling list before removing
	addNToEnd(lnkLst, N);
	//Iterator
	java.util.Iterator<Integer> itr = lnkLst.iterator();
	startTime = System.currentTimeMillis();
	rmBeginWithIter(lnkLst, N, itr);
	stopTime = System.currentTimeMillis();
	System.out.println("Remove from beginning with iterator: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(lnkLst.isEmpty());
	lnkLst.doClear();	

	//1f. Adding then taking the sum of all elements.
	//Filling list before summing
	addNToEnd(lnkLst, N);
	int sum = 0;
	startTime = System.currentTimeMillis();
	sum = summation(lnkLst, N, sum);
	stopTime = System.currentTimeMillis();
	System.out.println("Summing all element: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(sum);
	lnkLst.doClear();		

	//1g. Add 0 a total of N times to the end
	startTime = System.currentTimeMillis();
	add0ToEndNTimes(lnkLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Add to 0 end N times: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(lnkLst);
	lnkLst.doClear();
	
	//System.out.println(lnkLst);
    }
    
}
