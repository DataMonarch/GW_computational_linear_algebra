// Instructions:
// Plot the result of alpha vs. theta for three choices of matrix:
// (1) B = A, where A is a random matrix
// (2) B = U, where U is the first matrix of the SVD
// (3) B = V, where V is the second matrix of the SVD


import edu.gwu.lintool.*;
import java.awt.*;
import java.util.*;

public class SVDExplore {

    public static void main (String[] argv)
    {
	double[][] A = makeRandomMatrix ();

	// Compute SVD
	LinResult L = LinToolLibrary.computeSVD (A);
	
	// Now explore the effect of U or V by itself.

	double[][] B;

	// Un-comment one of the three below:

	B = A;
	// B = L.U;
	// B = L.V;

	MatrixTool.print (B);

	// Number of vectors to explore:
	int N = 16;

	double delTheta = 2*Math.PI / N;

	double[] u = new double [2];
	Function F = new Function ("alpha vs theta");
	Function G = new Function ("45-degree line");

	for (double theta=0; theta<=2*Math.PI; theta+=delTheta) {
	    // Generate next vector along unit circle.
	    u[0] = Math.cos(theta);
	    u[1] = Math.sin(theta);
	    // Apply B to u.
	    double[] z = MatrixTool.matrixVectorMult (B, u);
	    double alpha = Math.atan2 (z[1], z[0]);
	    // Get z's angle.
	    alpha = fixAngle (alpha);
	    // Add to data set.
	    F.add (theta, alpha);      // plot alpha vs. theta.
	    G.add (theta, theta);      // 45 degree line
	}

	// Plot data set.
	F.show (F, G);
    }


    static double[][] makeRandomMatrix ()
    {
	// Random seed for generation.
	UniformRandom.set_seed (System.currentTimeMillis());

	// Start with a random unit length vector: a random angle.
	double theta = UniformRandom.uniform (0, 2.0*Math.PI);
	double[] x = new double [2];
	x[0] = Math.cos(theta);  x[1] = Math.sin(theta);

	// The second column will be also be generated randomly.
	theta = UniformRandom.uniform (0, 2.0*Math.PI);
	double[] y = new double [2];
	y[0] = Math.cos (theta);   y[1] = Math.sin (theta);

	// Make the matrix with x and y as columns.
	double[][] A = new double [2][2];
	A[0][0] = x[0];  A[1][0] = x[1];
	A[0][1] = y[0];  A[1][1] = y[1];

	return A;
    }

    static double fixAngle (double a)
    {
	if (a < 0) {
	    a = a + 2*Math.PI;
	}
	return a;
    }


}

