import java.util.Scanner;

public class myself_version 
{
    static final int MAXCHANCES = 8 ;

    public static final String[] wordList = 
    {
      "ABSTRACT", "ALFALFA", "AMBASSADOR", "BOOK", "COMPUTER",
      "CRYPT",  "DISPEL", "FOYER", "FUZZY", "GNOME", "GYPSY",
      "HUBBUB", "IMP", "JUNK", "KEYHOLE", "MESSY", "ONYX",
      "PUEBLO", "QUAGMIRE", "QUIET", "SLITHER", "SQUIRMY",
      "SUCCUMB", "TELEVISION", "WALLABY", "ZIRCON"
   };

   //随机抽取单词
   public static String pickAWord() 
   {
      // need to change it to make it correct
      int max = 26 ;
      int min = 0 ;
      return wordList[(int)(Math.random() * (max - min + 1) + min)] ;  

   }

   public static void main(String[] args)
   {
    do
    {
        System.out.println("Welcome to Hangman !") ;
        String WordToGuess = pickAWord() ;
        
        char[] Bar ;
        for(int i = 0 ; i < WordToGuess.length() ; i++  )
        {
            Bar[i] = '-' ;
        }
        Scanner Guess = new Scanner(System.in) ;
        
    }
     


   }

    
}
