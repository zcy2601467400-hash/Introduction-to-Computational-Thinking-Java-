
//==========================================================
// 
// CarLaunch.java              CS112
// 
// Author: Richard Yang         Email: yry@cs.yale.edu 
//  
// 
// Class: CarLaunchV1
// 
// ---------------------------------------------------------
//   See SimpleStdDrawX.java for how to use StdDraw. This is
// an intermediate version. See CarLaunchV2.java for final 
// version.
//==========================================================

import java.awt.Color;


public class CarLaunch {
	final static int CANVAS_WIDTH = 800;
	final static int CANVAS_HEIGHT = 450;

	final static int WIDTH = 550;
	final static int HEIGHT = 600;

	final static double G = -9.81;

	final static int CAR1_SIZE = 40;
	final static int CAR2_SIZE = 50;

	final static int H1 = 541, V1x = 50, V1y = 30;
	final static int H2 = 381, V2x = 30, V2y = 10;
	
	final static int FRAME_T = 60;  // 60 ms /frame
	final static int       T = 10;
	
	public static void main(String[] args) {

		initStdDraw();
	
		//countDown();
		
		race();

	} // end of main

	public static void countDown() {
		for (int count = 10; count >= 0; count --) {
			Car.drawCar(0, H1, CAR1_SIZE, "1");
			StdDraw.picture(0, H2, "angry-bird-r.png");
			
			StdDraw.setPenColor(Color.RED);
			StdDraw.text(WIDTH/2, HEIGHT/2, ""+count);
			
			StdDraw.show(1000);
			StdDraw.clear();
		}
	}
	
	public static void race() {
		
		StdAudio.loop("race-car.wav");
		
		// Simulate time from 0 to 10 sec.
		for (double t = 0; t < T; t += FRAME_T / 1000.0) {
			// Compute car 1's position
			//double x1 = V1x * t;
			double x1 = position(0, t, V1x, 0);
			//double y1 = H1 + V1y * t + 0.5 * G * t * t;
			double y1 = position(H1, t, V1y, G);
			
			// Compute car 2's position
			//double x2 = V2x * t;
			double x2 = position(0, t, V2x, 0);
			//double y2 = H2 + V2y * t + 0.5 * G * t * t;
			double y2 = position(H2, t, V2y, G);
			
			
			Car.drawCar(x1, y1, CAR1_SIZE, "WTC");
			StdDraw.picture(x2, y2, "angry-bird-r.png");
			//Car.drawCar(x2, y2, CAR2_SIZE, "ESB");
			
			//labelHLine(H1, "WTC");
			//labelHLine(H2, "ESB");
			//labelHLine(0,  "Ground");
			
			StdDraw.show(FRAME_T);
			StdDraw.clear();	
			
		} // end of for
	}
	
	public static double position(double initP, double t, 
			                      double v,     double a) {
		
		double pos = initP + v * t + 0.5 * a * t * t;
		return pos;
	}
	
	public static void initStdDraw() {
		// Change from the default of 512x512.
		StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

		// Change scale from the default of [0 - 1.0].
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(0, HEIGHT);

		// Draw border
		StdDraw.rectangle(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
	}

	//public static void labelHLine(double height, String s) {
	//	StdDraw.setPenColor(Color.gray);
	//	StdDraw.line(0, height, WIDTH, height);
	//	StdDraw.text(0, height, s);
	//}
} // end of CarLaunch
