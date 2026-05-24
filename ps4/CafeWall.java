//*******************************************************************
//
//   File: CafeWall.java         Assignment No.: 4
//
//   Author: 曾诚誉             Email: zcy19859231839@126.com
//
//   Class: CafeWall
// 
//   Time spent on this problem: 45min
//   --------------------
//    
//
//*******************************************************************
import java.awt.*;

public class CafeWall
{
    final static int MORTAR = 2; // 泥浆的宽度
    final static int WIDTH  = 650;
    final static int HEIGHT = 400;

    public static void main( String[] args )
    {
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

	// Change from Color.GRAY to change background color.
        StdDraw.setPenColor( Color.GRAY );
        StdDraw.filledRectangle(WIDTH/2, HEIGHT/2, WIDTH/2, HEIGHT/2);

	drawRow(    0, 378, 4, 20 );
	drawRow(   50, 300, 5, 30 );

	drawGrid(  10, 36, 4, 25, 0 );

	drawGrid( 250, 40,  3, 25, 10 );

	drawGrid( 425, 2, 5, 20, 10 );

	drawGrid( 400, 234,  2, 35, 35 );
    }

    // Draw a row of squares, the total number of squares is pairs * 2
    // (x, y) is the lower left corner of the first box
    public static void drawRow( int x, int y, int pairs, int size )
    {
        for( int i = 0 ; i < pairs ; i++ ) // 用for循环输出4组黑白拼接方块
        {
            StdDraw.setPenColor( Color.black ); 

            StdDraw.filledSquare( x + size / 2 + i * 2 * size , 
                                  y + size / 2 , 
                                  size / 2 ); // 画出黑色方块

            StdDraw.setPenColor(Color.blue);

            StdDraw.line( x + 2 * i * size  ,
                          y ,
                          x + 2 * i * size + size ,
                          y + size );

            StdDraw.line( x + 2 * i * size + size ,
                          y , 
                          x + 2 * i * size , 
                          y + size ) ; // 在黑色方块中画出蓝色X

            StdDraw.setPenColor( Color.white );

            StdDraw.filledSquare( x + size / 2 + 2 * i * size + size,
                                  y + size / 2 ,
                                  size / 2 ) ; // 画出白色方块
            
        }
    

        
    }

    // Draw a grid of 2 * pairs rows
    public static void drawGrid( int x, 
                                 int y, 
                                 int pairs, 
                                 int size, 
				                 int offset )
    {
        for(int i = 0 ; i < pairs ; i++) // 用for循环输出pairs个砖块组
        {
            drawRow( x ,
                     y + 2 * i * size +  2 * i * MORTAR ,
                     pairs, 
                     size ); // 输出初始的砖块 
           
            drawRow( x - offset ,
                     y + 2 * i * size + size + 2 * i * MORTAR + MORTAR ,
                     pairs ,
                     size ); // 输出偏移的砖块
        }
    }


}
