//*******************************************************************
//
// File: TaskMan.java
//
// Author: 曾诚誉     Email: zcy19859231839@126.com
//
// Class: TaskMan
// 
// Time spent on this problem:  3h
//   --------------------
// 
//   This program shows count down timers for events from a file.
//
//*******************************************************************
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TaskMan {

    
    final static int    MS_PER_SEC      = 1000;


    final static String TASK_FILE     = "tasks.txt";
    static int N;                   
    static String[]     taskNames;
    static long[]       taskDeadlines;

    
    final static int    TOTAL_WIDTH = 700;
    final static int    PICTURE_X = 630;
    final static int    TASK_X = 180;
    final static int    TIMER_X = 500;
    final static int    PER_TASK_HEIGHT = 100;
    final static String IMAGE = "images.jpg"; 

    
    final static String TIMER_FMT = "%,dd %02dh %02dm %02ds";

    public static void main(String[] args) {

        loadTasks();

        initStdDraw(TOTAL_WIDTH, PER_TASK_HEIGHT * N);

        for (;;) {
            
            long currentEPOCHTime = System.currentTimeMillis();

            for (int i = 0; i < N; i++) {
                
                try {
                    StdDraw.picture(PICTURE_X, PER_TASK_HEIGHT * N / 2, IMAGE);
                } catch (Exception e) {
                    
                }

                
                long timeDiffMS = taskDeadlines[i] - currentEPOCHTime;

                int timeDiffSec = (int) Math.round(timeDiffMS / 1000.);

                
                if (timeDiffMS > 0) {
                    StdDraw.setPenColor(StdDraw.GREEN);
                } else {
                    StdDraw.setPenColor(StdDraw.RED);
                }
                

                String timeDiffStr = fromSec2TimerString(Math.abs(timeDiffSec));

                StdDraw.textRight(TASK_X, 
                                  PER_TASK_HEIGHT / 2 + i * PER_TASK_HEIGHT, 
                                  taskNames[i] + ":");

                StdDraw.textRight(TIMER_X, 
                                  PER_TASK_HEIGHT / 2 + i * PER_TASK_HEIGHT, 
                                  timeDiffStr);
            } 

            StdDraw.show(MS_PER_SEC);
            StdDraw.clear();
        } 

    } 

    
    public static void initStdDraw(int width, int height) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        Font c = new Font("Courier", Font.PLAIN, 32);
        StdDraw.setFont(c);

        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(width / 2, height / 2, 
                                width / 2, height / 2);
    }

    
    public static void loadTasks() {

        Scanner input = null;
        
        try 
        {
            input = new Scanner(new File(TASK_FILE));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Could not open " + TASK_FILE);
            System.exit(1);
        }

        N = input.nextInt(); 
        input.nextLine();   
        taskNames     = new String[N];
        taskDeadlines = new long[N];

        
        for (int i = 0; i < N; i++) {
             String line = input.nextLine();

            
             String[] parts = line.split("\\|");
             
             
             taskNames[i] = parts[0].trim(); 
             System.out.print("Task name: " + taskNames[i] + " / ");
             
             
             String taskDeadlineStr = parts[1].trim();
             

             taskDeadlines[i] = timeString2EPOCHTime( taskDeadlineStr );
        } 
        input.close();
    } 

    
    public static long timeString2EPOCHTime(String timeStr) {

        
        String[] pieces = timeStr.split("[/ :]");
        int month = Integer.parseInt(pieces[0]) - 1; 
        int day   = Integer.parseInt(pieces[1]);
        int year  = Integer.parseInt(pieces[2]);
        int hour  = Integer.parseInt(pieces[3]);
        int min   = Integer.parseInt(pieces[4]);
        int sec   = Integer.parseInt(pieces[5]);

        
        
        
        if (pieces.length > 6) {
            String ampm = pieces[6];
            if (ampm.equalsIgnoreCase("PM")) {
                if (hour != 12) {
                    hour += 12; 
                }
            } else if (ampm.equalsIgnoreCase("AM")) {
                if (hour == 12) {
                    hour = 0;   
                }
            }
        }
        

        if (!(isValidInput(month, day, year, hour, min, sec))) {
             System.out.println(timeStr + " is not valid");
             System.exit(1);
        }

        GregorianCalendar task 
             = new GregorianCalendar(year, month, day, 
                                     hour,    min, sec);

        System.out.println("Due Date: " + task.getTime());

        
        return task.getTimeInMillis();
    }

    
    public static String fromSec2TimerString(int sec) {
      
      int day = sec / (24 * 3600);
      int remainder = sec % (24 * 3600);
      
      int hour = remainder / 3600;
      remainder = remainder % 3600;
      
      int min = remainder / 60;
      
      sec = remainder % 60;
      

      return String.format(TIMER_FMT, day, hour, min, sec);
    }

    public static boolean isValidInput(int mon, int day, int year, 
                                     int hour, int min, int sec) {
      
      if (year < 0) return false;
      
      
      if (mon < 0 || mon > 11) return false;
      
      
      if (hour < 0 || hour > 23) return false;
      
     
      if (min < 0 || min > 59) return false;
      
      
      if (sec < 0 || sec > 59) return false;
      
      
      int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
      
      if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
          daysInMonth[1] = 29; 
      }
      
      if (day < 1 || day > daysInMonth[mon]) return false;
      
      return true;
      
    } 

} 
