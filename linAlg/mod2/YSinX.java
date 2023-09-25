
public class YSinX {

    public static void main (String[] argv)
    {
        Function F1 = new Function ("sin(x)");
        Function F2 = new Function ("2*sin(x)");
        Function F3 = new Function ("4*sin(x)");
        Function F4 = new Function ("0.5*sin(x)");
  

        for (double x=0; x<=1; x+=0.02) {
            // calculate the values of the functions at x
            F1.add (x, Math.sin(2*Math.PI*x));
            F2.add (x, 2*Math.sin(2*Math.PI*x));
            F3.add (x, 4*Math.sin(2*Math.PI*x));
            F4.add (x, 0.5*Math.sin(2*Math.PI*x));
        }
        Function.show (F1, F2, F3, F4);
    }
    
}
