
public class LinCombExample5 {

    public static void main (String[] argv) 
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);

	double[] u = {1, 2};
	double[] v = {3, 6};
	double[] z = {4,8};

	DrawTool.setArrowColor ("blue");
	DrawTool.drawVector (u);
	DrawTool.setArrowColor ("red");
	DrawTool.drawVector (v);
	DrawTool.setArrowColor ("green");
	DrawTool.drawVector (z);

    }

}
