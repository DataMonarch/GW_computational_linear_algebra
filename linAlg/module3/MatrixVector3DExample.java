// Instructions:
// Copy over the matrixMult() and matrixVectorMult() code from
// previous exercises.
// NOTE: you need to have draw3d.jar in your classpath.

import org.edisonwj.draw3d.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;


public class MatrixVector3DExample extends Application {

    String title = "Vector example";

    void drawingCommands () 
    {
	double[][] A = {
	    {3, 2, 1},
            {-2, 3, 5},
	    {0, 0, 3}
        };
	double[][] B = {
	    {-4, 1, 0},
            {1, 0, 1},
	    {3, -2, 1}
        };
	double[] x = {1, -1, 2};

	double[] y = matrixVectorMult (A, x);
	print (y);

	double[] z = matrixVectorMult (B, y);
	print (z);

	double[][] C = matrixMult (B, A);
	print (C);
	
	double[] z2 = matrixVectorMult (C, x);
	print (z2);

	d3.setDrawColor (Color.BLUE);
	d3.drawVector (x);
	d3.setDrawColor (Color.GREEN);
	d3.drawVector (y);
	d3.setDrawColor (Color.RED);
	d3.drawVector (z);
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
		// Compute the product of A and v and return the result.
		double[] result = new double[v.length];
		for (int i = 0; i < v.length; i++) {
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

    //////////////////////////////////////////////////////////

    Draw3D d3;

    void preambleCommands ()
    {
	d3.setAmbientLight(false);
	d3.setPointLight(true);
	d3.setCumulate(false);
	d3.setSequencingOn();
	d3.setVectorRadius(1);
        d3.setArrowRadius(1);
    }

    public void start (Stage primaryStage) 
    {
	d3 = new Draw3D ();
	Scene scene = d3.buildScene ();
	preambleCommands ();
	drawingCommands ();
	d3.setStart ();
	primaryStage.setScene (scene);
	primaryStage.setTitle (title);
	primaryStage.show ();
    }

    public static void main (String[] argv)
    {
	launch (argv);
    }


}
