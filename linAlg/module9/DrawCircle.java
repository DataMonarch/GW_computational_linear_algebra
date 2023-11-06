// Instructions:
// Write code to complete the circle

import java.util.*;

public class DrawCircle {

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (-10,10, -10,10);
	DrawTool.drawMiddleAxes (true);


	double x0 = 2, y0 = 3; 	  // Center:
	double r = 5;             // Radius
	double delX = 0.05;        // x-increment for drawing

	ArrayList<Double> xValues = new ArrayList<Double> ();
	ArrayList<Double> yValues = new ArrayList<Double> ();

	// Note: we start x on the left.
	for (double x=x0-r; x<=x0+r; x+=delX) {
	    double y = y0 + Math.sqrt (r*r - (x-x0)*(x-x0));
	    xValues.add (x);
	    yValues.add(y);
	    DrawTool.drawPoint (x,y);
	}

	// INSERT YOUR CODE HERE:

	for (double x=x0+r; x>=x0-r; x-=delX) {
	    double y = y0 - Math.sqrt (r*r - (x-x0)*(x-x0));
	    xValues.add (x);
	    yValues.add(y);
	    DrawTool.drawPoint (x,y);
	}

	// Construct the circle using angle parameterization.
	ArrayList<Double> xValues2 = new ArrayList<Double> ();
	ArrayList<Double> yValues2 = new ArrayList<Double> ();
	double x0_2 = 0, y0_2 = 0; // Center
	double del_t = 0.05;       // t-increment for drawing

	for (double t=0; t <= 2*Math.PI; t+=del_t) {
	    double x = x0_2 + r * Math.cos (t);
	    double y = y0_2 + r * Math.sin (t);
	    xValues2.add (x);
	    yValues2.add (y);
	}

	// Draw the resulting curve.
	DrawTool.drawCurve (xValues, yValues);
	DrawTool.drawCurve (xValues2, yValues2);
    }
	

}
