import java.util.Random;

public class GuitarString {

    private RingBuffer buffer;    // 循环缓冲区
    private int time;             // tic() 被调用的次数
    private static final double DECAY = 0.996; // 能量衰减系数
    private static final int SAMPLING_RATE = 44100;

    // 创建给定频率的琴弦
    public GuitarString(double frequency) {
        // 计算容量 N = SAMPLING_RATE / frequency，向上取整
        int capacity = (int) Math.ceil(SAMPLING_RATE / frequency);
        buffer = new RingBuffer(capacity);
        time = 0;
        // 初始化为 0 (静止状态)
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(0.0);
        }
    }

    // 创建指定采样数组的琴弦 (用于调试)
    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        time = 0;
        for (double val : init) {
            buffer.enqueue(val);
        }
    }

    // 拨动琴弦：用白噪声替换缓冲区中的内容
    public void pluck() {
        int n = buffer.size();
        // 清空当前缓冲区并填充随机值 [-0.5, 0.5)
        for (int i = 0; i < n; i++) {
            buffer.dequeue();
            double noise = Math.random() - 0.5;
            buffer.enqueue(noise);
        }
    }

    // 执行 Karplus-Strong 更新步骤
    public void tic() {
        double first = buffer.dequeue();
        double second = buffer.peek();
        // 计算平均值并衰减
        double newSample = DECAY * 0.5 * (first + second);
        buffer.enqueue(newSample);
        time++;
    }

    // 返回当前采样
    public double sample() {
        return buffer.peek();
    }

    // 返回 tic() 调用次数
    public int time() {
        return time;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}

