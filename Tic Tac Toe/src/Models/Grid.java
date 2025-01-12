package Models;
import java.util.*;
import javafx.util.Pair;

public class Grid {
    public int size;
    public char[][] grid;

    public Grid(int size)
    {
        this.size=size;
        grid=new char[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                grid[i][j]= ' ';
            }
        }
    }

    public void printGrid()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++) {
                System.out.print(grid[i][j]);
                if (j < size - 1) {
                    System.out.print("   |   ");
                }
            }
            System.out.println();
            if(i<size-1)
            {
                System.out.println("------------------");
            }
        }
    }

    public void addPiece(int row,int col,char mark)
    {
        grid[row][col]=mark;
    }
     public boolean isValidPosition(int row,int col)
     {
         if(row<0 || row>=size || col<0 || col>=size)
         {
             return false;
         }
         return true;
     }

    public boolean isAlreadyFilled(int row,int col)
    {
        if(grid[row][col] != ' ')
            return true;
        return false;
    }

    public List<Pair<Integer,Integer>> getFreeCells()
    {
        List<Pair<Integer,Integer>> freeCellsList=new ArrayList<>();
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++)
            {
                if(grid[i][j] == ' ')
                {
                    Pair<Integer,Integer> row=new Pair<>(i,j);
                    freeCellsList.add(row);
                }
            }
        }
        return freeCellsList;
    }

    public boolean checkWin(int row,int col,char mark)
    {
        boolean rowCheck=true;
        boolean colCheck=true;
        boolean diagonalCheck=true;
        boolean antiDiagonalCheck=true;
        for(int i=0;i<size;i++) {
            if (grid[row][i] == ' ' || grid[row][i] != mark) {
                rowCheck = false;
            }
        }
        for(int i=0;i<size;i++){
            if(grid[i][col] == ' ' || grid[i][col] != mark) {
                colCheck = false;
            }
        }
        for(int i=0,j=0;i<size;i++,j++)
        {
            if(grid[i][j] == ' ' || grid[i][j] != mark)
            {
                diagonalCheck = false;
            }
        }
        for(int i=0,j=size-1;i<size && j>=0;i++,j--)
        {
            if(grid[i][j] == ' ' || grid[i][j] != mark)
            {
                antiDiagonalCheck =  false;
            }
        }
        if(rowCheck || colCheck || diagonalCheck || antiDiagonalCheck)
        {
            return true;
        }
        return false;
    }

}
