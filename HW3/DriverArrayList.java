//Jason Shin (jjs270)
public class DriverArrayList {

    //Adds ints from 1 to N to end of arrLst
    private static void addNToEnd(MyArrayList<Integer> arrLst, int times) {
	for (int i = 0; i < times; i++) {
	    arrLst.add(i);
	}
    }

    //Adds ints from 1 to N to beginning of arrLst
    private static void addNToBegin(MyArrayList<Integer> arrLst, int times) {
	for (int i = 0; i < times; i++) {
	    arrLst.add(0, i);
	}
    }

    //Removes value from end of data without an iterator until empty.
    private static void rmEndNoIter(MyArrayList<Integer> arrLst, int times) {
	for (int i = 0; i < times - 2; i++) {
	    arrLst.remove(arrLst.size() - 1);
	}
    }

    //Removes value from beginning of data without an iterator until empty.
    private static void rmBeginNoIter(MyArrayList<Integer> arrLst, int times) {
	for (int i = 0; i < times; i++) {
	    arrLst.remove(0);
	}
    }

    //Removes value from beginning of data without an iterator until empty.
    private static void rmBeginWithIter(MyArrayList<Integer> arrLst, int times, java.util.Iterator<Integer> itr) {
	while (itr.hasNext()) {
	    itr.next();
	    itr.remove();
	}
    }

    //Summation of all elements
    private static int summation(MyArrayList<Integer> arrLst, int times, int sum) {	
	for (int i = 0; i < times; i++) {
	    sum += arrLst.get(i);
	}
	return sum;
    }

    //Adding 0 to end N times
    private static void add0ToEndNTimes(MyArrayList<Integer>arrLst, int times) {
	for (int i = 0; i < times; i++) {
	    arrLst.add(0);
	}
    }
    
    //Main method
    public static void main(String[] args) {
        long startTime, stopTime;
	MyArrayList<Integer> arrLst = new MyArrayList<Integer>();
	int N = 100000;

	//Tests for MyArrayList
	System.out.println("MyArrayList...");
	
	//1a. Adding values to end of data structure
	startTime = System.currentTimeMillis();
	addNToEnd(arrLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Add to end: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	arrLst.clear();
	
	//1b. Adding values to beginning of data structure
	startTime = System.currentTimeMillis();
	addNToBegin(arrLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Add to beginning: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	arrLst.clear();
	
	//1c. Adding then removing from end without an iterator
	//Filling array before removing
	addNToEnd(arrLst, N);
	startTime = System.currentTimeMillis();
	rmEndNoIter(arrLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Remove from end: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(arrLst.isEmpty());
	arrLst.clear();

	//1d. Adding then removing from beginning without an iterator
	//Filling array before removing
	addNToEnd(arrLst, N);
	startTime = System.currentTimeMillis();
	rmBeginNoIter(arrLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Remove from beginning: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	arrLst.clear();

	//1e. Adding then removing from beginning with an iterator
	//Filling array before removing
	addNToEnd(arrLst, N);
	//Iterator
	java.util.Iterator<Integer> itr = arrLst.iterator();
	startTime = System.currentTimeMillis();
	rmBeginWithIter(arrLst, N, itr);
	stopTime = System.currentTimeMillis();
	System.out.println("Remove from beginning with iterator: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(arrLst.isEmpty());
	arrLst.clear();	

	//1f. Adding then taking the sum of all elements.
	//Filling array before summing
	addNToEnd(arrLst, N);
	int sum = 0;
	startTime = System.currentTimeMillis();
	sum = summation(arrLst, N, sum);
	stopTime = System.currentTimeMillis();
	System.out.println("Summing all elements: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(sum);
	arrLst.clear();		

	//1g. Add 0 a total of N times to the end
	startTime = System.currentTimeMillis();
	add0ToEndNTimes(arrLst, N);
	stopTime = System.currentTimeMillis();
	System.out.println("Add to 0 end N times: N = " + N + ", t = " + (stopTime - startTime) + "ms");
	//System.out.println(arrLst);
	arrLst.clear();
	
	//System.out.println(arrLst);
    }
    
}
