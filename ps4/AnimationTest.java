import java.awt.Color; // 导入颜色类

public class AnimationTest
{

    // -----------------------------------------------------------------
    // Part 3.1: 参数化图形 (Parameterized Figure)
    // -----------------------------------------------------------------
    /**
     * 绘制您自定义的图形。
     * 这是您需要自己设计的部分。
     * 作为一个示例，我将绘制一个简单的 "小车"（一个矩形和两个圆形）。
     *
     * @param x 图形的左下角 x 坐标
     * @param y 图形的左下角 y 坐标
     */
    public static void drawMyFigure(double x, double y) {
        // 这是一个示例图形 (至少3个组件, 2种颜色)
        double width = 80;
        double height = 40;

        // 1. 车身 (组件1, 颜色1)
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(x + width / 2, y + height / 2, width / 2, height / 2);

        // 2. 轮子1 (组件2, 颜色2)
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x + width * 0.25, y, height / 2 * 0.75); // 左轮

        // 3. 轮子2 (组件3, 颜色2)
        StdDraw.filledCircle(x + width * 0.75, y, height / 2 * 0.75); // 右轮
    }

    // -----------------------------------------------------------------
    // Part 3.3: 倒计时时钟 (Countdown Clock)
    // -----------------------------------------------------------------
    /**
     * 绘制倒计时时钟。
     *
     * @param cx 时钟中心的 x 坐标
     * @param cy 时钟中心的 y 坐标
     * @param r  时钟的半径
     * @param n  总倒计时秒数
     * @param t  当前剩余秒数
     */
    public static void drawClock(double cx, double cy, double r, int n, int t) {
        // 1. 绘制时钟的表盘（外圈）
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.circle(cx, cy, r);

        // 2. 计算时钟指针的角度
        // t=n 时 (开始), 角度应为 PI/2 (12点钟方向)
        // t=0 时 (结束), 角度应为 PI/2 - 2*PI (也是12点钟方向)
        // 角度 = 起始角度 - (已过去的比例 * 2*PI)
        double fractionPassed = (double) (n - t) / n;
        double angle = (Math.PI / 2) - (fractionPassed * 2 * Math.PI);

        // 3. 计算指针的终点
        double endX = cx + r * Math.cos(angle);
        double endY = cy + r * Math.sin(angle);

        // 4. 绘制指针
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(cx, cy, endX, endY);

        // 5. 在指针末端绘制剩余时间
        // 为了防止数字被压扁，我们稍微把数字往外移一点
        double textX = cx + (r * 1.1) * Math.cos(angle);
        double textY = cy + (r * 1.1) * Math.sin(angle);
        StdDraw.text(textX, textY, Integer.toString(t));
    }


    // -----------------------------------------------------------------
    // 主程序 (Main Method)
    // -----------------------------------------------------------------
    public static void main(String[] args) {

        // -------------------------------------------------------------
        // Part 3.2: 设置参数 (Animation Parameters)
        // -------------------------------------------------------------

        // 1. 设置画布大小 (例如 500x500)
        int canvasWidth = 500;
        int canvasHeight = 500;
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, canvasWidth);
        StdDraw.setYscale(0, canvasHeight);

        // 开启双缓冲，这是实现流畅动画的关键
        //StdDraw.enableDoubleBuffering();

        // 2. 设置图形参数
        double initialX = 50.0;     // 图形初始 x
        double initialY = 50.0;     // 图形初始 y
        double speed = 30.0;        // 移动速度 (像素/秒)
        double angleDeg = 45.0;     // 移动角度 (度)

        // 3. 设置音频文件
        String audioFile = "my_sound.wav"; // (替换成您的 .wav 文件名)
        String imageFile = "my_image.png"; // (替换成您的 .png 文件名)

        // 4. 设置倒计时
        int countdownTotal = 10; // 总共倒计时 10 秒

        // -------------------------------------------------------------
        // Part 3.3: 倒计时场景 (Countdown Scene)
        // -------------------------------------------------------------

        // 时钟参数
        double clockCX = canvasWidth / 2.0;
        double clockCY = canvasHeight / 2.0;
        double clockR = Math.min(canvasWidth, canvasHeight) / 4.0; // 半径为画布的 1/4

        for (int t = countdownTotal; t >= 0; t--) {
            // 1. 清除画布
            StdDraw.clear();

            // 2. 绘制静态的自定义图形
            drawMyFigure(initialX, initialY);

            // 3. 绘制静态的图片
            // (注意：StdDraw.picture() 的 x, y 是图片的中心)
            // 为了和 drawMyFigure(x,y) 对应，我们可能需要调整
            // 这里我们假设 initialX, initialY 是图片的中心
            StdDraw.picture(initialX + 40, initialY + 50, imageFile); // (调整坐标以匹配您的图形)

            // 4. 绘制倒计时时钟
            drawClock(clockCX, clockCY, clockR, countdownTotal, t);

            // 5. 显示绘制的内容
            StdDraw.show();

            // 6. 暂停 1 秒
            StdDraw.show(1000); // 1000 毫秒 = 1 秒
        }

        // -------------------------------------------------------------
        // Part 3.4: 基础动画 (Basic Animation)
        // -------------------------------------------------------------

        // 1. 播放音频 (在动画循环开始前)
        StdAudio.play(audioFile);

        // 2. 动画参数
        int framePause = 50; // 每帧 50 毫秒 (20 FPS)
        double duration = 10.0; // 动画持续 10 秒
        double numFrames = (duration * 1000) / framePause;

        // 3. 计算每帧的位移
        // 速度 (像素/秒) * 时间 (秒/帧) = 像素/帧
        double angleRad = Math.toRadians(angleDeg); // 将角度转换为弧度
        double vx = speed * Math.cos(angleRad); // x方向速度 (像素/秒)
        double vy = speed * Math.sin(angleRad); // y方向速度 (像素/秒)

        double dx = vx * (framePause / 1000.0); // x方向每帧的位移
        double dy = vy * (framePause / 1000.0); // y方向每帧的位移

        // 4. 动画循环
        double currentX = initialX;
        double currentY = initialY;

        for (int i = 0; i < numFrames; i++) {
            // 1. 清除画布
            StdDraw.clear();

            // 2. 更新位置
            currentX += dx;
            currentY += dy;

            // (可选) 处理边界，例如让它在撞墙时反弹
            // 这里为了简单，我们先不处理

            // 3. 绘制移动的图形
            drawMyFigure(currentX, currentY);

            // 4. 绘制移动的图片
            StdDraw.picture(currentX + 40, currentY + 50, imageFile); // (同样，调整坐标)

            // 5. 显示
            StdDraw.show();

            // 6. 暂停
            StdDraw.show(framePause);
        }
    }
}
