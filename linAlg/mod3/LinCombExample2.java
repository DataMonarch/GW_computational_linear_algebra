// Instructions:
// 1. Write code to implement vector addition and scalar multiplication
// 2. Then compile and execute.

public class LinCombExample2 {

    public static void main (String[] argv) 
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	double[] u = {1,4};
	double[] v = {3,2};
	double alpha = 1.5,  beta = 2;
	double[] u_alpha = scalarMult (alpha, u);
	double[] v_beta = scalarMult (beta, v);

	double[] z = add(u_alpha, v_beta);
	
	DrawTool.drawVector (u);
	DrawTool.drawVector (v);

	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (u_alpha);
	DrawTool.drawVector (v_beta);

	double[] w = add (u,v);

	DrawTool.setArrowColor ("red");
	DrawTool.drawVector (w);

	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (z);
    }

    static double[] add (double[] u, double[] v)
    {
	// method returns the vector sum of u and v
	
	double x = u[0] + v[0];
	double y = u[1] + v[1];

	return new double[] {x,y};

    }

    static double[] scalarMult (double alpha, double[] v)
    {
	// method returns the scalar multiple of alpha and v

	double x = alpha * v[0];
	double y = alpha * v[1];

	return new double[] {x,y};

    }

}
