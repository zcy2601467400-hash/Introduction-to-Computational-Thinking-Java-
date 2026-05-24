//************************************************************************
// File: GuitarHeroLite.java         Assignment 9
// 
// Author: <your name>  Email: <your email>
//
// Class: GuitarHeroLite
// Dependencies: RingBuffer GuitarString StdAudio StdDraw 
//
// Description  :  GuitarHero template
//  
//  Plays two guitar strings (concert A and concert C) when the user
//  types the lowercase letters 'a' and 'c', respectively in the 
//  standard drawing window.
//************************************************************************

public class GuitarHeroLite {

    public static void main(String[] args) {
	int    DRAW_SAMPLE_RATE = 20;    // draw at a rate of 20/sec
	int    AUDIO_PER_DRAW   = StdAudio.SAMPLE_RATE / DRAW_SAMPLE_RATE;
	int    PLAY_TIME        = 10;    // target 60 seconds display window
	int    XWIDTH           = DRAW_SAMPLE_RATE * PLAY_TIME;

        // Create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        // Set up parameters for visualization
	StdDraw.setCanvasSize(768, 256);
	StdDraw.setPenColor(StdDraw.RED);
	StdDraw.setXscale(0, XWIDTH);
	StdDraw.setYscale(-1, 1);

	// fence post
	double xprev = 0, yprev = 0;

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if (key == 'a') { stringA.pluck(); }
                if (key == 'c') { stringC.pluck(); }
            }

	    // compute the superposition of the samples for duration
	    double sample = stringA.sample() + stringC.sample();

	    // send the result to standard audio
	    StdAudio.play(sample);

	    // advance the simulation of each guitar string by one step
	    stringA.tic();
	    stringC.tic();

	    // Decide if we need to draw. 
	    //   Audio sample rate is StdAudio.SAMPLE_RATE per second
	    //   Draw sample rate is DRAW_SAMPLE_RATE
	    //   Hence, we draw every StdAudio.SAMPLE_RATE / DRAW_SAMPLE_RATE
	    if (stringA.time() % AUDIO_PER_DRAW == 0) {
		StdDraw.line(xprev, yprev, xprev+1, sample);
		xprev ++;
		yprev = sample;
		// check if wrapped around
	    } // end of if

	} // end of while

    } // end of main

} // end of class
