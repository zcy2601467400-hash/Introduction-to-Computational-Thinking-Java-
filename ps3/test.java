public class test 
{
    public static void main(String[] args) 
    {
        printNumberCoolness(3);
        printNumberCoolness(9);
    }

    static void printNumberCoolness(int n) 
    {
        int i = 1, num = 0;                        
        while (i <= n) 
        {
            num = num * 10 + i;
            int result = num * 8 + i , spacesCount = n - i;
            String spaces = spacesCount > 0 ? String.format("%" + spacesCount + "s", "") : ""; 
            System.out.println(spaces + num + " x 8 + " + i + " = " + result);                 
            i++;                                                                              
        }
    }
}