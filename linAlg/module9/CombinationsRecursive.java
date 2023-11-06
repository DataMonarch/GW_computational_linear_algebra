// Instructions:
// Write a recursive version of numCombinations()
// Compile and execute

public class CombinationsRecursive {

    public static void main (String[] argv)
    {
	int n = 10;
	Function C = new Function ("n-choose-k vs k");
	for (int k=0; k<=n; k++) {
	    int r = numCombinationsRecursive (n,k);
	    C.add (k, r);
	}
	C.show ();
    }

    static int numCombinationsRecursive (int n, int k)
    {
	// Base case (already written for you)
		if ((n==k) || (n==1) || (k==0)) {
			return 1;
		}

		// INSERT one line of code here (the actual recursion):
		return numCombinationsRecursive(n-1,k-1) + numCombinationsRecursive(n-1,k);

    }

    static int factorial (int n)
    {
		if (n==0 || n==1) {
			return 1;
		}
		
		return n * factorial(n-1);
	}

}
