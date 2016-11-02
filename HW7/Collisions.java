//Jason Shin - jjs270
import java.util.Random;

public class Collisions {

    //Hash function
    public static int hash( int key, int size ) {
	return key % size;
    }
    
    //Calculates the total and max collisions for key values 0-10,000
    public static void calcCollisions( int size ) {
	int[] arr = new int[size];
	int total = 0;
	int max = 0;
	for (int i = 0; i < 10000; i++) {
	    arr[i%size]++;
	}
	for (int i = 0; i < size; i++) {
	    if (arr[i] > max) {
		max = arr[i] - 1;
	    }
	    total += (arr[i] - 1);
	}
	System.out.println("Total collisions = " + total + ", Max collisions = " + max);
    }

    public static void calcRandomCollisions( int size, int numKeys, int maxVal, int trials) {
	for (int t = 0; t < trials; t++) {
	    int[] arr = new int[size];
	    int total = 0;
	    int max = 0;
	    Random r = new Random();
	    for (int i = 0; i < numKeys; i++) {
		int rand = r.nextInt(maxVal + 1);
		arr[rand%size]++;
	    }
	    for (int i = 0; i < size; i++) {
		if (arr[i] > max) {
		    max = arr[i] - 1;
		}
		if (arr[i] > 1) {
		    total += (arr[i] - 1);
		}
	    }
	    System.out.println("Total collisions = " + total + ", Max collisions = " + max);
	}
    }

    public static void nl() {
	System.out.println();
    }
    
    //Main method
    public static void main(String[] args) {
	//size = 100
	System.out.println("calcCollisions(100)");
	calcCollisions(100);
	nl();
	//size = 200
	System.out.println("calcCollisions(200)");
	calcCollisions(200);
	nl();
	//size = 100, numKeys = 50, maxVal = 10000, trials = 3
	System.out.println("calcRandomCollisions(100, 50, 10000, 3)");
	calcRandomCollisions(100, 50, 10000, 3);
	nl();
	//size = 200, numKeys = 50, maxVal = 10000, trials = 3
	System.out.println("calcRandomCollisions(200, 50, 10000, 3)");
	calcRandomCollisions(200, 50, 10000, 3);
	nl();
	//size = 100, numKeys = 100, maxVal = 10000, trials = 3
	System.out.println("calcRandomCollisions(100, 100, 10000, 3)");
	calcRandomCollisions(100, 100, 10000, 3);
	nl();
	//size = 100, numKeys = 50, maxVal = 100000, trials = 3
	System.out.println("calcRandomCollisions(100, 50, 100000, 3)");
	calcRandomCollisions(100, 50, 100000, 3);
    }
}
