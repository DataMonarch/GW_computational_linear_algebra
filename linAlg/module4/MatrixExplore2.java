// A simple application of matrix A to u produces v.
// The goal is to see: what is v? Try the two values of u below.

import java.awt.*;
import java.util.*;

public class MatrixExplore2 {

    public static void main (String[] argv)
    {
	double[][] A = new double [2][2];
	A[0][0] = 5;  A[0][1] = -2;
	A[1][0] = 0;  A[1][1] = 1;

	DrawTool.display ();
	DrawTool.setXYRange (-5,5, -5,5);
	DrawTool.drawMiddleAxes (true);

	// Try u=(1,2). Then try u=(1,0).
	double[] u = {1,2};
	MatrixTool.print (u);
	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (u);     // Draw in blue
	// Apply A to u
	double[] v = MatrixTool.matrixVectorMult (A, u);
	DrawTool.setArrowColor ("black");
	DrawTool.drawVector (v);
	MatrixTool.print (v);
    }

}


