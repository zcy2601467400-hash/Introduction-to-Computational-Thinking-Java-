
public class RandomWords {
   public static final String[] wordList = {
      "ABSTRACT", "ALFALFA", "AMBASSADOR", "BOOK", "COMPUTER",
      "CRYPT",  "DISPEL", "FOYER", "FUZZY", "GNOME", "GYPSY",
      "HUBBUB", "IMP", "JUNK", "KEYHOLE", "MESSY", "ONYX",
      "PUEBLO", "QUAGMIRE", "QUIET", "SLITHER", "SQUIRMY",
      "SUCCUMB", "TELEVISION", "WALLABY", "ZIRCON"
   };

   public static String pickAWord() {
      // need to change it to make it correct
      int max = 26 ;
      int min = 0 ;
      return wordList[(int)(Math.random() * (max - min + 1) + min)] ; //随机抽取单词 

   }

} // end of class RandonWords
