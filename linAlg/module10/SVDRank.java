// Instructions:
// (1) Make a 3x3 matrix with rank=1
// (2) Add code to count the number of rank<3 matrices randomly generated.

import edu.gwu.lintool.*;
import java.awt.*;
import java.util.*;

public class SVDRank {

    public static void main (String[] argv)
    {
	// Make a 3x3 matrix with rank=1
	double[][] A = {
	    {1, 2, 3},
	    {2, 4, 6},
	    {3, 6, 9}
	};

	// Compute SVD
	LinResult L = LinToolLibrary.computeSVD (A);
	
	// Now explore the effect of U or V by itself.

	System.out.println ("rank=" + L.rank);

	int numMatrices = 100;
	double totalRank = 0;
	for (int i=0; i<numMatrices; i++) {
	    // Generate random matrix
	    A = makeRandomMatrix (3);
	    L = LinToolLibrary.computeSVD (A);
	    totalRank += L.rank;
	}

	System.out.println ("Avg rank: " + (totalRank/numMatrices));
    }


    static double[][] makeRandomMatrix (int n)
    {
	// Random seed for generation.
	UniformRandom.set_seed (System.currentTimeMillis());

	double[][] A = new double [n][n];
	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++) {
		A[i][j] = UniformRandom.uniform ();
	    }
	}
	return A;
    }


}

