//*******************************************************************
//
//   File: SudokuSolver.java          Assignment No.: 7
//
//   Author: 曾诚誉                   Email: zcy19859231839@126.com
//
//   Class: SudokuSolver
// 
//   Time spent on this problem: 3h+
//   --------------------
//      Please give a description about your design.  null
//*******************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuSolver
{
  public static void main(String[] args) throws FileNotFoundException
  {
    
    if (args.length != 1) {
       usage();
       System.exit(1);
    } 
    String sudokuFile = args[0];
    System.out.println("Solving " + sudokuFile);

    File f = new File( sudokuFile );
    Scanner s = new Scanner( f );
    int[][] sudoku = new int[9][9]; 

    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            if (s.hasNextInt()) {
                sudoku[row][col] = s.nextInt();
            }
        }
    }

    
    boolean hasMadeProgress;
    
    do {
        hasMadeProgress = false;

        
        for (int row = 0; row < 9; row++) {
            for (int num = 1; num <= 9; num++) {
                int possibleCount = 0;
                int targetCol = -1;

                
                for (int col = 0; col < 9; col++) {
                    if (sudoku[row][col] == 0) {
                        if (isPossible(sudoku, row, col, num)) {
                            possibleCount++;
                            targetCol = col;
                        }
                    }
                }

                if (possibleCount == 1) {
                    sudoku[row][targetCol] = num;
                    hasMadeProgress = true;
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            for (int num = 1; num <= 9; num++) {
                int possibleCount = 0;
                int targetRow = -1;

                for (int row = 0; row < 9; row++) {
                    if (sudoku[row][col] == 0) {
                        if (isPossible(sudoku, row, col, num)) {
                            possibleCount++;
                            targetRow = row;
                        }
                    }
                }

                if (possibleCount == 1) {
                    sudoku[targetRow][col] = num;
                    hasMadeProgress = true;
                }
            }
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                
                for (int num = 1; num <= 9; num++) {
                    int possibleCount = 0;
                    int targetRow = -1;
                    int targetCol = -1;

                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            int currentRow = boxRow + r;
                            int currentCol = boxCol + c;

                            if (sudoku[currentRow][currentCol] == 0) {
                                if (isPossible(sudoku, currentRow, currentCol, num)) {
                                    possibleCount++;
                                    targetRow = currentRow;
                                    targetCol = currentCol;
                                }
                            }
                        }
                    }

                    if (possibleCount == 1) {
                        sudoku[targetRow][targetCol] = num;
                        hasMadeProgress = true;
                    }
                }
            }
        }

    } while (hasMadeProgress);

    System.out.println("Result: ");
    printSudoku( sudoku );
    
  }
  
  public static void printSudoku(int[][] sudoku)
  {
    for (int row = 0; row < 9; row++)
    {
      for (int column = 0; column < 9; column++)
      {
        System.out.print(sudoku[row][column]+ " ");
      }
      System.out.println();
    }
  }
  
  public static boolean isPossible(int[][] sudoku, 
                                   int row, int column, 
                                   int numToCheck)
  {
    for (int c = 0; c < 9; c++) {
        if (sudoku[row][c] == numToCheck) {
            return false;
        }
    }

    for (int r = 0; r < 9; r++) {
        if (sudoku[r][column] == numToCheck) {
            return false;
        }
    }

    int boxRowStart = (row / 3) * 3;
    int boxColStart = (column / 3) * 3;

    for (int r = boxRowStart; r < boxRowStart + 3; r++) {
        for (int c = boxColStart; c < boxColStart + 3; c++) {
            if (sudoku[r][c] == numToCheck) {
                return false;
            }
        }
    }

  
    return true;
  }
  
  public static void usage()
  {
     System.out.println("java SudokuSolver <sudoku_input>");
  } 

}
