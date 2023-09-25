
public class PlotSin3 {

    public static void main (String[] argv)
    {
        Function F1 = new Function ("ph=0");
        Function F2 = new Function ("ph=p/4");
        Function F3 = new Function ("ph=p/2");
        Function F4 = new Function ("ph=p");
        double ph1 = 0;
        double ph2 = Math.PI/4;
        double ph3 = Math.PI/2;
        double ph4 = Math.PI;

        for (double x=0; x<=1; x+=0.005) {
            // calculate the values of the functions at x
            F1.add (x, Math.cos(2*Math.PI*x + ph1));
            F2.add (x, Math.cos(2*Math.PI*x + ph2));
            F3.add (x, Math.cos(2*Math.PI*x + ph3));
            F4.add (x, Math.cos(2*Math.PI*x + ph4));           
        }
        Function.show (F1, F2, F3, F4);
    }
    
}
