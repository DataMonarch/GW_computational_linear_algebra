
public class ExploreSpan {

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	// Two vectors:
	double[] u = {1, 4};
	double[] v = {3, 2};

	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (u);
	DrawTool.drawVector (v);

	// Range of alpha to explore:
	double alphaLow=-10, alphaHigh=10, alphaStep=0.1;
	// Range of beta:
	double betaLow=-1, betaHigh=1, betaStep=0.1;

	for (double alpha=alphaLow; alpha<=alphaHigh; alpha+=alphaStep) {
	    for (double beta=betaLow; beta<=betaHigh; beta+=betaStep) {
		double[] w = linComb (alpha, u, beta, v);
		DrawTool.drawLine (0,0, w[0], w[1]);
	    } 
	}
    }

    static double[] linComb (double alpha, double[] u, double beta, double[] v)
    {
		double[] w = new double [u.length];

		// check if the vectors are the same length
		if (u.length != v.length) {
			System.out.println("Vectors must be the same length");
			return null;
		}

		for (int i=0; i<u.length; i++) {
			w[i] = alpha * u[i] + beta * v[i];
		}

		return w;
    }

}
