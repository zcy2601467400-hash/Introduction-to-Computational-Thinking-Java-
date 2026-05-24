public class GuitarHero {
    public static void main(String[] args) {
        //定义 37 个按键映射
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[37];

        // 初始化 37 根琴弦
        for (int i = 0; i < 37; i++) {
            double freq = 440.0 * Math.pow(2, (i - 24.0) / 12.0);
            strings[i] = new GuitarString(freq);
        }

        int DRAW_SAMPLE_RATE = 20;
        int AUDIO_PER_DRAW = StdAudio.SAMPLE_RATE / DRAW_SAMPLE_RATE;
        int PLAY_TIME = 10;
        int XWIDTH = DRAW_SAMPLE_RATE * PLAY_TIME;

        StdDraw.setCanvasSize(768, 256);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setXscale(0, XWIDTH);
        StdDraw.setYscale(-1, 1);
        double xprev = 0, yprev = 0;

        //主循环
        while (true) {
            // 处理按键输入
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    strings[index].pluck();
                }
            }

            // 计算所有琴弦样本的叠加
            double sample = 0;
            for (int i = 0; i < 37; i++) {
                sample += strings[i].sample();
            }

            // 播放音频
            StdAudio.play(sample);

            // 推进所有琴弦状态
            for (int i = 0; i < 37; i++) {
                strings[i].tic();
            }

            if (strings[0].time() % AUDIO_PER_DRAW == 0) {
                StdDraw.line(xprev, yprev, xprev + 1, sample);
                xprev++;
                yprev = sample;
                
                if (xprev > XWIDTH) {
                    StdDraw.clear();
                    xprev = 0;
                }
            }
        }
    }
}
