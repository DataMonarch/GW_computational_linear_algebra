// Instructions:
// Write code in the method matrixVectorMult() below to 
// compute the product of a matrix and a vector. Although
// the examples are 2x2, assume a general NxN size. You can
// assume that the matrix and vector are size-matched.

public class MatrixVectorExample {

    public static void main (String[] argv)
    {
	double[][] A = {
	    {2, -3},
            {0, 1}
        };
	double[] x = {2, 3};

	// Compute Ax = y and print y.
	double[] y = matrixVectorMult (A, x);
	print (y);

	double[][] B = {
	    {1, 2},
            {0, -3}
        };
	double[] z = matrixVectorMult (B, y);
	print (z);

	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);
	DrawTool.drawVector (x);
	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (y);
	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (z);
    }


    static double[] matrixVectorMult (double[][] A, double[] v)
    {
		// Get the number of rows of matrix A
		int rowsA = A.length;

		// Check if the matrix A and vector v can be multiplied
		if (A[0].length != v.length) {
			throw new IllegalArgumentException("Number of columns of A must be equal to the number of rows of v");
		}
	
		// Compute the product of A and v and return the result.
		double[] result = new double[rowsA];
		for (int i = 0; i < rowsA; i++) {
			result[i] = 0;
			for (int j = 0; j < v.length; j++) {
				result[i] += A[i][j] * v[j];
			}
		}
	
		return result;
    }

    static void print (double[] x)
    {
	System.out.print ("Vector:");
	for (int i=0; i<x.length; i++) {
	    System.out.printf (" %6.3f", x[i]);
	}
	System.out.println ();
    }

}
