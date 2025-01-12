import Models.Grid;
import Models.Player;
import javafx.util.Pair;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private Grid grid;
    private Player currPlayer;
    private Player player1;
    private Player player2;

    public TicTacToeGame(String player1Name,String player2Name)
    {
        this.grid=new Grid(3);
        this.player1=new Player(player1Name,'X');
        this.player2=new Player(player2Name,'O');
        this.currPlayer=player1;
    }

    public void playGame()
    {
        Scanner sc=new Scanner(System.in);
        boolean noWinner=true;
        while(noWinner){
            grid.printGrid();
            List<Pair<Integer,Integer>> freeCells=grid.getFreeCells();
            if(freeCells.isEmpty())
            {
                System.out.print("Match is draw!!");
                noWinner=false;
                continue;
            }
            System.out.println("Player: " +currPlayer.getPlayerName());
            System.out.println("Enter the row no");
            int row=sc.nextInt();
            System.out.println("Enter the col no");
            int col=sc.nextInt();
            row=row-1;
            col=col-1;
            if(!grid.isValidPosition(row,col))
            {
                System.out.println("Please enter valid position");
                continue;
            }
            else if(grid.isAlreadyFilled(row,col))
            {
                System.out.println("Already filled");
                continue;
            }
            else {
                grid.addPiece(row, col, currPlayer.getMark());
                if(grid.checkWin(row, col, currPlayer.getMark()))
                {
                    grid.printGrid();
                    System.out.print(currPlayer.getPlayerName()+" Wins!!");
                    noWinner=false;
                }
            }
            if(currPlayer == player1)
            {
                currPlayer = player2;
            }
            else {
                currPlayer = player1;
            }

        }
    }

}
