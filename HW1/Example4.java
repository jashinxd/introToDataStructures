// Jason Shin (jjs270)
public class Example4 {
    public static void main(String[] args) {
	int N = 35;
        for (int incN = 0; incN < 9; incN++) {
            for (int trial = 0; trial < 5; trial++) {
		long startTime = System.currentTimeMillis();
		long x = fib(N);
		long endTime = System.currentTimeMillis();
		System.out.print(endTime - startTime + "\t");
		//System.out.println(x);
	    }
	    System.out.println();
	    N += 2;
	}
    }

    public static long fib( int n ) {
        if( n <= 1 )
            return 1;
        else
            return fib( n - 1 ) + fib( n - 2 );
    }
}
