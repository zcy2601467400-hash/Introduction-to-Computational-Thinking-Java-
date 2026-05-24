import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Hangman {


    public static final String[] WORD_LIST = {
       "ABSTRACT", "ALFALFA", "AMBASSADOR", "BOOK", "COMPUTER",
      "CRYPT",  "DISPEL", "FOYER", "FUZZY", "GNOME", "GYPSY",
      "HUBBUB", "IMP", "JUNK", "KEYHOLE", "MESSY", "ONYX",
      "PUEBLO", "QUAGMIRE", "QUIET", "SLITHER", "SQUIRMY",
      "SUCCUMB", "TELEVISION", "WALLABY", "ZIRCON"
    };

    public static final Random random = new Random();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            playOneRound(); // 运行一轮游戏

            // 询问是否重玩
            System.out.println("\nPlay another round of Hangman (y/n)? ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("n")) {
                playAgain = false;
            }
        }
        System.out.println("Goodbye!");
    }

    private static void playOneRound() {
        System.out.println("Welcome to Hangman!");

        // 1. 随机选择一个单词
        String secretWord = getRandomWord();
        
        // 2. 创建用于显示的字符数组（初始全为 '-'）
        char[] currentGuessState = new char[secretWord.length()];
        Arrays.fill(currentGuessState, '-');

        int guessesLeft = 8;
        boolean wordIsGuessed = false;

        // 3. 游戏主循环：只要还有机会且没猜出来，就继续
        while (guessesLeft > 0 && !wordIsGuessed) {
            System.out.println("The word now looks like this: " + String.valueOf(currentGuessState));
            
            if (guessesLeft == 1) {
                System.out.println("You only have one guess left.");
            } else {
                System.out.println("You have " + guessesLeft + " guesses left.");
            }

            System.out.print("Your guess: ");
            String input = scanner.next();

            // 输入校验：确保输入了内容
            if (input.length() == 0) continue;

            // 统一转为大写，处理大小写不敏感的要求
            char guessChar = input.toUpperCase().charAt(0);

            // 4. 检查字母是否在单词中
            if (secretWord.indexOf(guessChar) >= 0) {
                // 猜对了
                System.out.println("That guess is correct.");
                
                // 更新显示的单词状态
                // 如果是重复猜对的字母，程序"do nothing"
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guessChar) {
                        currentGuessState[i] = guessChar;
                    }
                }
            } else {
                // 猜错了
                System.out.println("There are no " + guessChar + "'s in the word.");
                guessesLeft--; // 扣除一次机会
            }

            // 5. 检查是否完全猜出单词
            wordIsGuessed = isWordComplete(currentGuessState);
        }

        // 6. 游戏结束状态判断
        if (wordIsGuessed) {
            System.out.println("You guessed the word: " + secretWord);
            System.out.println("You win.");
        } else {
            System.out.println("You're completely hung.");
            System.out.println("The word was: " + secretWord);
            System.out.println("You lose.");
        }
    }

    /**
     * 从列表中随机获取一个单词
     */
    private static String getRandomWord() {
        int index = random.nextInt(WORD_LIST.length);
        return WORD_LIST[index];
    }

    /**
     * 检查当前猜测状态中是否还有 '-'，如果没有则表示猜完了
     */
    private static boolean isWordComplete(char[] currentGuessState) {
        for (char c : currentGuessState) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
}
