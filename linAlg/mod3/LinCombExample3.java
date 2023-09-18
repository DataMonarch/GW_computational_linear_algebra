// Instructions:
// Write code to systematically search over alpha, beta values.


public class LinCombExample3 {

    public static void main (String[] argv) 
    {
	double[] u = {1,4};
	double[] v = {3,2};
	double[] z = {7.5,10};
	double epsilon = 0.001;

	for (double alpha=0; alpha<=10; alpha+=0.1) {
	    for (double beta=0; beta<=10; beta+=0.1) {
		// See if alpha*u + beta*v is approximately z.

			double[] u_alpha = scalarMult (alpha, u);
			double[] v_beta = scalarMult (beta, v);

			double[] w = add (u_alpha, v_beta);

			if (Math.abs(w[0]-z[0])<epsilon && Math.abs(w[1]-z[1])<epsilon) {
				System.out.println ("Approximate solution found! Precision="+epsilon);
				System.out.println ("alpha="+alpha+", beta="+beta);
			}
	    }
	}

    }


    static double[] add (double[] u, double[] v)
    {
	// INSERT YOUR CODE HERE (from previous exercise)

	double x = u[0] + v[0];
	double y = u[1] + v[1];

	return new double[] {x,y};
    }

    static double[] scalarMult (double alpha, double[] v)
    {
	// INSERT YOUR CODE HERE (from previous exercise)

	double x = alpha * v[0];
	double y = alpha * v[1];

	return new double[] {x,y};
    }

}
