// Jason Shin (jjs270)
public class Example3 {
    public static void main(String[] args) {
        long N = 10000L;
        for (long incN = 0; incN < 9; incN++) {
            for (long trial = 0; trial < 5; trial++) {
		addTo(N);
	    }
	    System.out.println();
	    N += 10000L;
	}
    }

    private static void addTo(long N) {
        long startTime, stopTime; // For recording start/stop times      
        long x = 0;
        startTime = System.currentTimeMillis();
	for (long i = 0; i < N; i++) {
	    x = x + 1;
	}
	for (long i = 0; i < N; i++) {
	    for (long j = 0; j < N; j++) {
		x = x + 1;
	    }
	}
	stopTime = System.currentTimeMillis();
	System.out.print(stopTime - startTime + "\t");
    }
}
