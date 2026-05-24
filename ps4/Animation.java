//*******************************************************************
//
//   File: Animation.java         Assignment No.: 4
//
//   Author: 曾诚誉             Email: zcy19859231839@126.com
//
//   Class: Animation
// 
//   Time spent on this problem: 3h
//   --------------------
//    
//
//*******************************************************************

import java.awt.*;
public class Animation 
{
    //设置画布的大小
    final static int CANVAS_WIDTH  = 600 ; 
	final static int CANVAS_HEIGHT = 600 ;

    
    final static int x0 = 50 , y0 = 120, V1x = 0, V1y = 10; // 火箭的初始状态
	final static int n0 = 500 , m0 = 535 , V2x = -80, V2y = 20; // 小车的初始状态
	
    final static int size = 100 ; // 设置火箭与小车的尺寸

    final static double G = -9.81 ; // 重力加速度

    final static int FRAME_T = 50 ;  // 50 ms /frame
	final static int       n = 10 ;  // 程序运行的时长


    //主程序
    public static void main( String[] args )
    {
        //设置画布尺寸和基础背景
        initStdDraw();
        //倒计时
        countdown();
        //火箭与小车出发
        start();

    }

    //倒计时
    public static void drawClock(double cx, double cy, double r, int n, int t) 
    {
        // 绘制时钟
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(cx, cy, r);

        // 计算时钟指针的角度
        // t=n 时 (开始), 角度应为 PI / 2 (12点钟方向)
        // t=0 时 (结束), 角度应为 PI / 2 - 2 * PI (也是12点钟方向)
        // 角度 = 起始角度 - (已过去的比例 * 2 * PI)
        double fractionPassed = (double) (n - t) / n;
        double angle = (Math.PI / 2) - (fractionPassed * 2 * Math.PI);

        // 计算指针的终点
        double endX = cx + r * Math.cos(angle);
        double endY = cy + r * Math.sin(angle);

        // 绘制指针
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(cx, cy, endX, endY);

        // 在指针末端绘制剩余时间
        //稍微把数字往外移一点
        double textX = cx + (r * 1.1) * Math.cos(angle);
        double textY = cy + (r * 1.1) * Math.sin(angle);
        StdDraw.text(textX, textY, Integer.toString(t));

    }

    //设置画板尺寸
    public static void initStdDraw()
    {
        StdDraw.setCanvasSize(CANVAS_WIDTH,CANVAS_HEIGHT) ; 

        StdDraw.setXscale(0 , CANVAS_WIDTH );
        StdDraw.setYscale(0 , CANVAS_HEIGHT);
        

    }

    //火箭与小车出发
    public static void start()
    {
        StdAudio.loop("RocketLaunch.wav");

        for (double t = 0; t < n ; t += FRAME_T / 1000.0)
        {
            double x1 = position(x0, t, V1x, 0); 

            double y1 = position(y0, t, V1y, -G);

            double x2 = position(n0, t, V2x, 0);

            double y2 = position(m0, t, V2y, G);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(550, 225, 50, 300); //大楼
            drawRocket(x1, y1, size);
            drawCar(x2 , y2 , size);
            
            StdDraw.show(FRAME_T);
			StdDraw.clear();

        }


    }
    //用于计算位置的Method
    public static double position(double initP, double t, 
			                      double v,     double a)
    {
        double pos = initP + v * t + 0.5 * a * t * t;
        return pos;

    }

    //倒计时
    public static void countdown()
    {
        double cx = CANVAS_WIDTH / 2 ;
        double cy = CANVAS_HEIGHT / 2 ;
        double r = Math.min(CANVAS_WIDTH, CANVAS_HEIGHT) / 4 ;
        int n = 10 ;
        for (int t = n ; t >= 0; t--) 
        {
            drawRocket(x0, y0, size);
            drawCar(n0 , m0 , size);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(550, 225, 50, 300);
            
            drawClock(cx, cy, r , n, t);

            StdDraw.show(1000);
			StdDraw.clear();

        }


    }

    //绘制火箭
    public static void drawRocket(double x0, 
                                  double y0, 
                                  double size) 
    {
        final double Rocket_WIDTH = 0.50, Rocket_HEIGHT = 1.00;

        double[] xCoords = {x0 - size * Rocket_WIDTH ,
                            x0 + size * Rocket_WIDTH ,
                            x0 + size * Rocket_WIDTH / 2,
                            x0 - size * Rocket_WIDTH /2};
        
        
        double[] yCoords = {y0 - size * Rocket_HEIGHT ,
                            y0 - size * Rocket_HEIGHT ,
                            y0 - size * Rocket_HEIGHT * 3 / 2,
                            y0 - size * Rocket_HEIGHT * 3 / 2 } ;
        

        //绘制身体
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(x0 , 
                                y0  , 
                                size * Rocket_WIDTH , 
                                size * Rocket_HEIGHT);

        //绘制顶部
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.filledCircle(x0 ,
                             y0 + size * Rocket_HEIGHT, 
                             size * Rocket_WIDTH);

        //绘制尾焰
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledPolygon(xCoords, yCoords);
        
        
        
    }

    //绘制小车
    public static void drawCar(double n0, 
                               double m0, 
                               double size) 
    {
        final double CAR_WIDTH = 1.00, CAR_HEIGHT = 0.50;
        final double WHEEL_MARGIN = 0.15, WHEEL_RADIUS = 0.10;
        final double WINDOW_WIDTH = 0.30, WINDOW_HEIGHT = 0.20;

        //绘制车身
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(n0 + size * CAR_WIDTH / 2, 
                                m0 + size * CAR_HEIGHT / 2, 
                                size * CAR_WIDTH / 2, 
                                size * CAR_HEIGHT / 2);

        //绘制车轮
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(n0 + size * (WHEEL_MARGIN + WHEEL_RADIUS),
                             m0, 
                             size * WHEEL_RADIUS);
        StdDraw.filledCircle(n0 + size * (CAR_WIDTH - WHEEL_MARGIN - 
                                          WHEEL_RADIUS), 
                             m0, 
                             size * WHEEL_RADIUS);

        //绘制车窗
        StdDraw.setPenColor(Color.CYAN);
        StdDraw.filledRectangle(n0 + size * (CAR_WIDTH - WINDOW_WIDTH / 2), 
                                m0 + size  * CAR_HEIGHT / 2, 
                                size * WINDOW_WIDTH / 2, 
                                size * WINDOW_HEIGHT / 2);  

    }

    
}




    

