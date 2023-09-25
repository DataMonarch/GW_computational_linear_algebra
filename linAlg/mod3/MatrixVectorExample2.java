// Instructions:
// Write code in the matrixMult() method to compute the
// the product of two matrices. Also, copy over your code
// for matrixVectorMult() from MatrixVectorExample.java

public class MatrixVectorExample2 {

    public static void main (String[] argv)
    {
	double[][] A = {
	    {2, -3},
            {0, 1}
        };
	double[][] B = {
	    {1, 2},
            {0, -3}
        };
	double[] x = {2, 3};

	double[][] C = matrixMult (B, A);
	print (C);

	double[] z = matrixVectorMult (C, x);
	print (z);

	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);
	DrawTool.drawVector (x);
	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (z);

    }


    static double[][] matrixMult (double[][] A, double[][] B)
    {
		/* Compute the product of A and B using the matrixVectorMult() method
		 * and return the result. */

		 // Get the number of rows for matrix A and columns for matrix B
		 int rowsA = A.length;
		 int colsB = B[0].length;
	 
		 // Check if the matrices can be multiplied
		 if (A[0].length != B.length) {
			 throw new IllegalArgumentException("Number of columns of A must be equal to number of rows of B");
		 }
	 
		 // Initialize the result matrix C
		 double[][] C = new double[rowsA][colsB];
	 
		 // Compute each column of the result matrix C using matrixVectorMult method
		 for (int j = 0; j < colsB; j++) {
			 // Extract the j-th column from matrix B
			 double[] columnB = new double[B.length];
			 for (int i = 0; i < B.length; i++) {
				 columnB[i] = B[i][j];
			 }
	 
			 // Multiply matrix A with the extracted column vector
			 double[] columnC = matrixVectorMult(A, columnB);
	 
			 // Assign the computed column vector to the result matrix C
			 for (int i = 0; i < rowsA; i++) {
				 C[i][j] = columnC[i];
			 }
		 }
	 
		 // Return the result matrix C
		 return C;
	 
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

    static void print (double[][] A)
    {
	System.out.println ("Matrix (" + A.length + "x" + A[0].length + "):");
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		System.out.printf (" %6.3f", A[i][j]);
	    }
	    System.out.println ();
	}
    }

}
