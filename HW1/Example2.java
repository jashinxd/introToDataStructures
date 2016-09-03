// Jason Shin (jjs270)
public class Example2 {
    public static void main(String[] args) {
        long N = 10000L;
        for (int incN = 0; incN < 9; incN++) {
            for (int trial = 0; trial < 5; trial++) {
		addTo(N);
	    }
	    N += 10000L;
	    System.out.println();
	}
    }
    
    private static void addTo(long N) {
        long startTime, stopTime; // For recording start/stop times      
        long x = 0;
        startTime = System.currentTimeMillis();                 
        for (long i = 0; i < N; i++) {
	    for (long j = 0; j < N; j++) {
		x = x + 1;
	    }
	}
        stopTime = System.currentTimeMillis();                   
        System.out.print(stopTime - startTime + "\t");
    }
    
}
