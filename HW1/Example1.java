// Jason Shin (jjs270)
public class Example1 {
    public static void main(String[] args) {
	long nVal = 100000000L;
	for (int incN = 0; incN < 9; incN++) {
	    for (int trial = 0; trial < 5; trial++) {
		addTo(nVal);
	    }
	    System.out.println();
	    nVal += 100000000L;
	}
    }
    
    private static void addTo(long nVal) {
	long startTime, stopTime; // For recording start/stop times
	long x = 0;
	startTime = System.currentTimeMillis();
	//System.out.println("startTime: " + startTime);
	for (long i = 0; i < nVal; i++) {
	    x = x + 1;
	}
	stopTime = System.currentTimeMillis();
	//System.out.println("stopTime: " + stopTime);
	System.out.print(stopTime - startTime + "\t");
    }
    
}
