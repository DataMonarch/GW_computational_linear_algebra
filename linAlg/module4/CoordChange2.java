// Instructions:
// Write the entries of the inverse matrix in Binv

import java.awt.*;
import java.util.*;

public class CoordChange2 {

    public static void main (String[] argv)
    {
	// If B translates by (1,2), then Binv is the inverse.
	double[][] Binv = {
	    {1,0, 1},
	    {0,1, 2},
	    {0,0, 1}
	};

	MatrixTool.print(Binv);

	// Test vector (the point (4,3))
	double[] x = {4,3,1};

	// Get coords in translated frame.
	double[] u = MatrixTool.matrixVectorMult (Binv, x);
	MatrixTool.print (u);
    }

}

