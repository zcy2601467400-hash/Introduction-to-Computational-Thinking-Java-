//*******************************************************************
//
//   File: NBody.java
//
//   Author: 曾诚誉  
//
//   Class: NBody 
// 
//   Description: 
//      This program simulates the motion of N particles in a plane
//      mutually affected by gravitational forces.
//
//*******************************************************************

public class NBody {

    public static final String PLANETS_FILE = "planets.txt";

    
    public static final int DELAY = 20;

    
    public static final String MUSIC = "2001theme.wav";

    
    public static final String BACKGROUND = "starfield.jpg";

    
    public static final double G = 6.67e-11;

                                        
    public static double T;             
    public static double dt;           

                                        
    public static int N;                
    public static double R;             

    public static double[] rx;          
    public static double[] ry;          
    public static double[] vx;          
    public static double[] vy;          
    public static double[] mass;        
    public static String[] image;       

    public static void loadPlanets(String planetFileName) {
        
        In in = new In(planetFileName);

        
        N = in.readInt();
        
        
        R = in.readDouble();

        
        rx = new double[N];
        ry = new double[N];
        vx = new double[N];
        vy = new double[N];
        mass = new double[N];
        image = new String[N];

        
        for (int i = 0; i < N; i++) {
            rx[i] = in.readDouble();
            ry[i] = in.readDouble();
            vx[i] = in.readDouble();
            vy[i] = in.readDouble();
            mass[i] = in.readDouble();
            image[i] = in.readString();
        }
    }

    public static void runSimulation() {

        
        for (double t = 0.0; t < T; t += dt) {

            
            double[] fx = new double[N];
            double[] fy = new double[N];

            
            for (int i = 0; i < N; i++) {
                
                fx[i] = 0;
                fy[i] = 0;
                
                for (int j = 0; j < N; j++) {
                    if (i == j) continue; 

                    double dx = rx[j] - rx[i];
                    double dy = ry[j] - ry[i];
                    double dist = Math.sqrt(dx * dx + dy * dy);

                    
                    if (dist == 0) continue;

                   
                    double F = (G * mass[i] * mass[j]) / (dist * dist);

                    fx[i] += F * dx / dist;
                    fy[i] += F * dy / dist;
                }
            }

            
            for (int i = 0; i < N; i++) {
                
                double ax = fx[i] / mass[i];
                double ay = fy[i] / mass[i];

                
                vx[i] += ax * dt;
                vy[i] += ay * dt;

                
                rx[i] += vx[i] * dt;
                ry[i] += vy[i] * dt;
            }

            
            StdDraw.picture(0, 0, BACKGROUND);

            
            for (int i = 0; i < N; i++) {
                StdDraw.picture(rx[i], ry[i], image[i]);
            }

            
            StdDraw.show(DELAY);
        }

    }

    public static void main(String[] args) {

        
        if (args.length < 3) {
            System.out.println("Usage: java NBody <T> <dt> <filename>");
            return;
        }
        
        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);

        
        String planetFileName = args[2];
        loadPlanets(planetFileName);

        
        StdDraw.setXscale(-R, +R);
        StdDraw.setYscale(-R, +R);

        
        try {
            StdAudio.play(MUSIC);
        } catch (Exception e) {
        }

        
        StdDraw.show(0);

        
        runSimulation();

        
        System.out.printf("%d\n", N);
        System.out.printf("%.2e\n", R);
        for (int i = 0; i < N; i++) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          rx[i], ry[i], vx[i], vy[i], mass[i], image[i]);
        }

    }
}
