// Instructions:
// To blur an image, we'll use a simple idea. Consider the first
// 4 x 4 block of pixels in the image at the top left. Suppose
// we compute the average intensity of the 16 pixels in that block.
// Call this average avg. Then, in the blurred image, all 16 of
// those pixels will have the same intensity, equal to avg. Thus,
// we replace the intensity of each pixel with the average intensity
// of the k x k block it belongs to. Clearly, large values of k will
// cause significant blurring.
//
// In the code below, your job is to take an image and blur it using
// the above approach.

public class ImageBlur {

    public static void main(String[] argv) {
        ImageTool imTool = new ImageTool();
        int[][] pixels = imTool.imageFileToGreyPixels("ace.jpg");
        imTool.showImage(pixels, "original");
        // Each block of k x k pixels has the same color.
        int k = 4;
        int[][] blurredPixels = blur(pixels, k);
        imTool.showImage(blurredPixels, "blurred");
    }

    static int[][] blur(int[][] pixels, int blurSize) {
        // Get the dimensions of the image
        int height = pixels.length;
        int width = pixels[0].length;

        // Initialize a copy of the original array with the same dimensions
        int[][] blurredPixels = new int[height][width];

        // Iterate through the image in blocks of size blurSize x blurSize
        for (int i = 0; i < height; i += blurSize) {
            for (int j = 0; j < width; j += blurSize) {
                int sum = 0;
                int count = 0;

                // Calculate the average intensity in the current block
                for (int ki = 0; ki < blurSize && i + ki < height; ki++) {
                    for (int kj = 0; kj < blurSize && j + kj < width; kj++) {
                        sum += pixels[i + ki][j + kj];
                        count++;
                    }
                }
                int avg = sum / count;

                // Set the intensity of each pixel in the current block to the average
                for (int ki = 0; ki < blurSize && i + ki < height; ki++) {
                    for (int kj = 0; kj < blurSize && j + kj < width; kj++) {
                        blurredPixels[i + ki][j + kj] = avg;
                    }
                }
            }
        }

        // Return the blurred image
        return blurredPixels;
    }
}
