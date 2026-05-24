/**
 * 这是一个用于演示 StdDraw 倒计时时钟的独立程序。
 * * *重要*：此版本不使用双缓冲，也不使用 StdDraw.pause()。
 * 这将导致动画在运行时出现明显的闪烁。
 * * * 编译和运行要求：
 * 1. 将此文件保存为 ClockTest.java
 * 2. 确保您的 (旧版本) StdDraw.java 文件在同一目录中
 * * 编译: javac ClockTest.java
 * 运行: java ClockTest
 */
public class ClockTest {

    // -----------------------------------------------------------------
    // Part 3.3: 倒计时时钟 (Countdown Clock)
    // -----------------------------------------------------------------
    /**
     * 绘制倒计时时钟。
     * (此方法无需更改)
     *
     * @param cx 时钟中心的 x 坐标
     * @param cy 时钟中心的 y 坐标
     * @param r  时钟的半径
     * @param n  总倒计时秒数 (例如 10)
     * @param t  当前剩余秒数 (例如 7)
     */
    public static void drawClock(double cx, double cy, double r, int n, int t) {
        
        // 1. 绘制时钟的灰色外圈 (表盘)
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(cx, cy, r);

        // 2. 计算当前时间所对应的角度 (以弧度为单位)
        double pastfraction = (double) (n - t) / n;
        double angle = (Math.PI / 2) - (pastfraction * 2 * Math.PI);

        // 3. 计算指针的终点 (x, y) 坐标
        double endX = cx + r * Math.cos(angle);
        double endY = cy + r * Math.sin(angle);

        // 4. 绘制时钟指针 (从中心到终点)
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(cx, cy, endX, endY);

        // 5. 在指针末端显示剩余时间
        double textX = cx + (r * 1.1) * Math.cos(angle);
        double textY = cy + (r * 1.1) * Math.sin(angle);
        
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(textX, textY, Integer.toString(t));
    }


    // -----------------------------------------------------------------
    // 主程序 (Main Method) - 用于测试时钟
    // -----------------------------------------------------------------
    public static void main(String[] args) {

        // 1. 设置画布
        int canvasWidth = 600;
        int canvasHeight = 600;
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, canvasWidth);
        StdDraw.setYscale(0, canvasHeight);

        
        // 3. 设置时钟参数
        double clockCX = canvasWidth / 2.0;   // 中心 x
        double clockCY = canvasHeight / 2.0;  // 中心 y
        double clockR = 150.0;                // 半径
        int totalSeconds = 10;                // 从 10 秒开始倒计时

        // 4. 倒计时循环
        for (int t = totalSeconds; t >= 0; t--) {
            
            // 1. 清除画布 (这将立即显示一个白色屏幕)
            StdDraw.clear(StdDraw.WHITE); 

            // 2. 绘制时钟 (这将立即在白色屏幕上绘制)
            drawClock(clockCX, clockCY, clockR, totalSeconds, t);

            // 3. !! 移除 StdDraw.show() !!
            // StdDraw.show(); 

            // 4. !! 替换 StdDraw.pause() !!
            // 使用 Java 内置的 Thread.sleep()
            try {
                Thread.sleep(1000); // 暂停 1000 毫秒 (1 秒)
            } catch (InterruptedException e) {
                // 如果线程在睡眠时被中断，则会发生此异常
                // 在这个简单程序中，我们可以忽略它或打印堆栈跟踪
                e.printStackTrace();
            }
        }
        
        // 倒计时结束
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(clockCX, clockCY, "Countdown Finished!");
        
    }
}
