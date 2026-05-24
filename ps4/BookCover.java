
import java.awt.Color;

public class BookCover {
    final static int WIDTH = 500;
    final static int HEIGHT = 600;

    public static void initialize() {
        // Change from the default of 512x512.
        StdDraw.setCanvasSize(WIDTH, HEIGHT);

        // Change scale from the default of [0 - 1.0].
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

        // Draw border
        StdDraw.rectangle(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
    }

    public static void main(String[] args) {

        initialize();
        
        drawBook(20,  415, 150);
        drawBook(175, 330, 120);
        drawBook(220, 85,  240);

    } // end of main

    public static void drawBook(int x0, int y0, int size) {
        // draw XMU blue background
        StdDraw.setPenColor(0, 53, 107);
        StdDraw.filledSquare(x0 + size / 2, 
                             y0 + size / 2, 
                             size / 2);

        // draw text
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.textLeft(x0 + size / 2.0, y0 + 4 * size / 5.0, "CT-F25");

        // draw strips
        final int N = 10;
        double unit = (double)size / N;
        for (int line = 1; line <= N; line++) {
            double xLeft = x0;
            double length = (N + 1 - line) * unit;

            double yLow = y0 + (line - 1) * unit;
            double height = unit - 2; // leave 2 points as space
            StdDraw.setPenColor(192, 128, 64);
            StdDraw.filledRectangle( xLeft + length / 2.0, 
                                     yLow  + height / 2.0,
                                     length / 2.0, 
                                     height / 2.0);
        }
    }

} // end of BookCover
