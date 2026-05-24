//==========================================================
// 
// SimpleStdDrawLoop.java       IOCT F25 
// 
// Author: Y. Richard Yang
//         Qiao Xiang 
// 
// Class: SimpleStdDrawLoop
//   See SimpleStdDrawX.java for how to use StdDraw
//==========================================================

public class SimpleStdDrawLoop {
	final static int SIZE  = 512;
	final static int N      = 8; 

	public static void main(String[] args) {

		setCanvasScale();
		
		int unit = SIZE / (N+2);
		int x0 = unit;
		int y0 = unit;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				StdDraw.square(x0 + i * unit + unit / 2, 
					       y0 + j * unit + unit / 2, 
					       unit / 2);
				StdDraw.text(x0 + i * unit + unit / 2, 
					     y0 + j * unit + unit / 2,
					     "" + (j * N + i));
			} // end of inner loop
		} // end of outer loop
	} // end of main

	public static void setCanvasScale() {
		// Change from the default of 512x512.
		StdDraw.setCanvasSize(SIZE, SIZE);

		// Change scale from the default of [0 - 1.0].
		StdDraw.setXscale(0, SIZE);
		StdDraw.setYscale(0, SIZE);
	}

} // end of SimpleDrawLoop
