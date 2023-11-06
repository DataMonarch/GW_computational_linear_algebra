
public class LinCombExample4 {

    public static void main (String[] argv) 
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	double[] u = {1, 2};
	double[] v = {3, 6};
	double[] z = {7.5,10};
	
	// Let's plot the vectors u, v, and z.
	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (u);
	DrawTool.setArrowColor ("red");
	DrawTool.drawVector (v);
	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (z);

	}

}
