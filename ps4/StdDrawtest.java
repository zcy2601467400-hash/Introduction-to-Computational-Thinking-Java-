import java.awt.Color;

public class StdDrawtest
{
    public static void main(String[] args)
    {
        StdDraw.setCanvasSize(650,400);
        StdDraw.setXscale(0,650);
        StdDraw.setYscale(0,400);
        //StdDraw.rectangle(100,450,100,50);
        StdDraw.setPenColor( Color.black );
        StdDraw.filledSquare(100, 100, 50);
        StdDraw.setPenColor(Color.blue);
        StdDraw.line(50,50,150,150);
        StdDraw.line(50,150,150,50);
    }
}