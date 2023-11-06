
public class PlotSin3CosSin {

    public static void main (String[] argv)
    {
        Function F1 = new Function ("sin(x+0)");
        Function F2 = new Function ("sin(x+pi/2)");
        Function F3 = new Function ("cos(x+0)");
        Function F4 = new Function ("cos(x+pi/2)");
  
        double ph = Math.PI/2;

        for (double x=0; x<=1; x+=0.02) {
            // calculate the values of the functions at x
            F1.add (x, Math.sin(2*Math.PI*x));
            F2.add (x, Math.sin(2*Math.PI*x + ph));
            F3.add (x, Math.cos(2*Math.PI*x));
            F4.add (x, Math.cos(2*Math.PI*x + ph));
        }
        Function.show (F1, F2, F3, F4);
    }
    
}
