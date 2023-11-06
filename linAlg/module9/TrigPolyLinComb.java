// Instructions:
// Try adding additional terms until k=13.

public class TrigPolyLinComb {

    public static void main (String[] argv)
    {
	Function Fsum = new Function ("sin-sum");
	for (double x=0; x<=1; x+=0.01) {
	    double y = Math.sin (2*Math.PI*x);

		for (int k=1; k<=411; k+=2)
		{
			y += 1.0/k * Math.sin (2*Math.PI*k*x);
		}

            // INSERT MORE HARMONICS TO ABOVE STATEMENT.

	    Fsum.add (x, y);
	}
	Fsum.show ();
    }

}
