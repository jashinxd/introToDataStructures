//Jason Shin (jjs270)
class redundancies {

    //Main function
    public static void main(String[] args) {
	int N;
	//Loop to print out results
	for ( N = 10; N <= 40; N+=5 ) {
	    System.out.print("N = " + N + ". ");
	    System.out.print("Subsequences = " + subs(N) + ". ");
	    System.out.print("Redundancies = " + reduns(N) + ".\n");
	}
    }

    //Returns number of subsequences for a given length N
    public static int subs(int N) {
	return (int)((double)N / 2.0 * (1 + N));	
    }

    //Returns redundancies for a givern range of N values
    public static int reduns(int N) {
	int ret = 0;
	for ( int i = 0; i < N; i++ ) {
	    ret += subs(i);
	}
	return ret;
    }
}
