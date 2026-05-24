//==========================================================
// 
// Car.java              IOCT F25 
// 
// Author: Y. Richard Yang
//         Qiao Xiang
//
// Class: Car
// 
// ---------------------------------------------------------
//   See SimpleStdDrawX.java for how to use StdDraw
//==========================================================
import java.awt.Color;

public class Car {
    // declare these as class variables because they
    // are needed by multiple methods
    final static int WIDTH  = 600;
    final static int HEIGHT = 400;

    public static void main(String[] args) {

        initialize();

        drawCar(80, 100, 100,  "1");
       // drawCar(300, 280, 200, "2");
       // drawCar(250, 180, 150, "3");
       // drawCar(450, 160, 80,  "4");

        /*
        final int NROWS = 4;
        final int NCOLS = 6;
        final double xUnit = WIDTH  / (NCOLS + 2.0);
        final double yUnit = HEIGHT / (NROWS + 2.0);
        int n = 1;
        for (int row = 1; row <= NROWS; row++, n++) {
            for (int col = 1; col <= NCOLS; col++) {
                drawCar(col * xUnit, 
                        row * yUnit,
                        xUnit * 0.75,
                        ""+n);
            }
        }
        */
    } // end of main

    public static void initialize() {
        // Change from the default of 512x512.
        StdDraw.setCanvasSize(WIDTH, HEIGHT);

        // Change scale from the default of [0 - 1.0].
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

        // Draw border
        StdDraw.rectangle(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
    }

    // assume body lower left corner is at (x0, y0)
    // body: 100% x 50% rect of size
    // wheel: radius = 10%, margin 15%
    // window: 30% x 20% in the right, middle
    public static void drawCar(double x0, 
                               double y0, 
                               double size,
                               String label) {
        // Define the variables to avoid magic numbers
        // A more general version of drawCar may make
        // some into method parameters
        final double CAR_WIDTH = 1.00, CAR_HEIGHT = 0.50;
        final double WHEEL_MARGIN = 0.15, WHEEL_RADIUS = 0.10;
        final double WINDOW_WIDTH = 0.30, WINDOW_HEIGHT = 0.20;

        // Black body
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(x0 + size * CAR_WIDTH / 2, 
                                y0 + size * CAR_HEIGHT / 2, 
                                size * CAR_WIDTH / 2, 
                                size * CAR_HEIGHT / 2);

        // Two wheels
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x0 + size * (WHEEL_MARGIN + WHEEL_RADIUS),
                             y0, 
                             size * WHEEL_RADIUS);
        StdDraw.filledCircle(x0 + size * (CAR_WIDTH - WHEEL_MARGIN - 
                                          WHEEL_RADIUS), 
                             y0, 
                             size * WHEEL_RADIUS);

        // Window
        StdDraw.setPenColor(Color.CYAN);
        StdDraw.filledRectangle(x0 + size * (CAR_WIDTH - WINDOW_WIDTH / 2), 
                                y0 + size  * CAR_HEIGHT / 2, 
                                size * WINDOW_WIDTH / 2, 
                                size * WINDOW_HEIGHT / 2);

        // Label
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.textLeft(x0 + size * CAR_WIDTH / 2, 
                         y0 + size * CAR_HEIGHT / 2,
                         label);

    }
}
