public class ArrayTest {

    public static void main(String[] args) {
        // Initialize a 2D array A
        double[][] A = new double[4][6];
        A[1][4] = 0.5;
        
        // Make a shallow copy of A by assigning it to B
        double[][] B = A;
        // Modify the value at B[1][4]
        B[1][4] = 0;
        
        // Print the value at A[1][4] to observe the effect of modifying B
        System.out.println(A[1][4]); // This will print 0.0 because B is a shallow copy of A
    }
}
