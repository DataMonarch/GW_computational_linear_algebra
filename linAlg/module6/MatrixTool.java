// Instructions:
// Write code for matrix-matrix multiplication and matrix-vector multiplication

public class MatrixTool {

    public static double[] matrixVectorMult (double[][] A, double[] v)
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

    public static double[][] matrixMult (double[][] A, double[][] B)
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

	public static double [] scalarMult (double alpha, double[] A)
	{
		// Compute the product of alpha and A and return the result.
		double[] result = A.clone();
		
		for (int i = 0; i < A.length; i++) {
			result[i] *= alpha;
		}

		return result;

	}

	public static double [] add(double[] A, double[] B)
	{
		// Check if the vectors A and B have the same length
		if (A.length != B.length) {
			throw new IllegalArgumentException("Vectors A and B must have the same length");
		}
		
		// Compute the sum of A and B and return the result.
		double[] result = A.clone();

		for (int i = 0; i < A.length; i++) {
			result[i] += B[i];
		}

		return result;

	}



    public static void print (double[] x)
    {
	System.out.print ("Vector:");
	for (int i=0; i<x.length; i++) {
	    System.out.printf (" %6.3f", x[i]);
	}
	System.out.println ();
    }

    public static void print (double[][] A)
    {
	System.out.println ("Matrix (" + A.length + "x" + A[0].length + "):");
	for (int i=0; i<A.length; i++) {
	    for (int j=0; j<A[0].length; j++) {
		System.out.printf (" %6.3f", A[i][j]);
	    }
	    System.out.println ();
	}
    }
    
    public static double dotProduct (double[] v, double[] u)
    {
	// Compute the dot product of v and u and return the result.

	// Check if the vectors v and u have the same length
	if (v.length != u.length) {
		throw new IllegalArgumentException("Vectors v and u must have the same length");
	}

		// Compute the dot product of v and u
		double res = 0;

		for (int i = 0; i < v.length; i++) {
			res += v[i] * u[i];
		}

		return res;
    }

    public static double norm (double[] u)
    {
		// Compute the norm of u and return the result.

		// This is equivalent to the square root of the dot product of u with itself
		return Math.sqrt(dotProduct(u, u));
    }

    public static double[] proj (double[] v, double[] u)
    {
		// Compute the projection of v onto u and return the result.
		double [] w = u.clone();
		double w_norm = dotProduct(v, u) / dotProduct(u, u);

		for (int i = 0; i < w.length; i++) {
			w[i] *= w_norm;
		}

		return w;
    }

    public static double[] sub (double[] u, double[] v)
    {
	double[] w = new double [u.length];
	for (int i=0; i<w.length; i++) {
	    w[i] = u[i] - v[i];
	}
	return w;
    }
}
