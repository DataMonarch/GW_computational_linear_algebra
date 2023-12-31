// Instructions:
// (1) First compile and execute to print mean, var, cov of data.
// (2) Then, un-comment the change of basis section in main() to
//     compute mean, var, cov in the new coordinates.
// (3) Change the data to the second (exaggerated) set.

public class ChangeOfBasisExample {

    // Number of data points:
    static int n = 8;

    // Data in standard coordinates:
    static double[] x = {1.1, 2.1, 2.8, 3.8, 5.1, 5.8, 7.2, 7.8};
    static double[] y = {1.0, 1.9, 2.9, 4.1, 5.2, 6.1, 7.3, 8.1};

    // Alternate "perfect" data, exaggerated to make a point.
    //static double[] x = {1,2,3,4,5,6,7,8};
    //static double[] y = {1,2,3,4,5,6,7,8};

    // New basis vectors v1, v2: v1=(1,1), v2=(-1,1)
    static double[] v1 = {1,1};
    static double[] v2 = {-1,1};

    // Coordinates in new basis with basis vectors u1, u2.
    static double[] xp = new double [n];
    static double[] yp = new double [n];

    public static void main (String[] argv)
    {
	System.out.println ("Before change of basis:");
	computeMeanVariance (x,y);

	// Un-comment this block to print both.

	/*
	changeBasis ();

	System.out.println ("After change of basis:");
	computeMeanVariance (xp,yp);
	*/
    }

    static void changeBasis ()
    {
	double[] z = new double [2];
	for (int i=0; i<n; i++) {
	    // z is the vector (x[i],y[i]).
	    z[0] = x[i];
	    z[1] = y[i];
	    xp[i] = MatrixTool.dotProduct(z,v1) / MatrixTool.dotProduct(v1,v1);
	    yp[i] = MatrixTool.dotProduct(z,v2) / MatrixTool.dotProduct(v2,v2);
	}
    }

    // No need to read further, unless you want to read the stats code.
    ////////////////////////////////////////////////////////////////////

    static void computeMeanVariance (double[] x, double[] y)
    {
	double meanX = computeMean (x);
	double meanY = computeMean (y);
	double varX = computeVariance (x, meanX);
	double varY = computeVariance (y, meanY);

	// Covariance:
	double total = 0;
	for (int i=0; i<x.length; i++) {
	    for (int j=0; j<y.length; j++) {
		total += (x[i]-meanX) * (y[i]-meanY);
	    }
	}
	double cov = total / (x.length-1);
	System.out.printf ("  meanX=%6.3f, meanY=%6.3f varX=%6.3f, varY=%6.3f covariance=%6.3f \n", meanX, meanY, varX, varY, cov);
    }

    static double computeVariance (double[] x, double mean)
    {
	double total = 0;
	for (int i=0; i<x.length; i++) {
	    total += (x[i]-mean) * (x[i]-mean);
	}
	return total/(x.length-1);
    }

    static double computeMean (double[] x)
    {
	double total = 0;
	for (int i=0; i<x.length; i++) {
	    total += x[i];
	}
	return total/x.length;
    }

}
